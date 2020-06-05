package com.eyabc.springboot.adapter;

import com.eyabc.springboot.config.RestTemplateConfiguration;
import com.eyabc.springboot.property.NaverSecretProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Component
@RequiredArgsConstructor
@Profile("!test & naver")
public class NaverSearchAdapter implements Adapter {

    private final NaverSecretProperty naverSecretProperty;
    private final String BASE_URL = "https://openapi.naver.com/v1/search/";
    private final RestTemplateConfiguration restTemplateConfiguration;

    public <T> T callSearch (String prefix, String target, String query, Class<T> className) {
        String url = BASE_URL + target + ".json?query=" + query;
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE);
        header.add("Host", "openapi.naver.com");
        header.add("X-Naver-Client-Id", naverSecretProperty.getClientId());
        header.add("X-Naver-Client-Secret", naverSecretProperty.getClientSecret());

        try {
            ResponseEntity<T> response = restTemplateConfiguration.restTemplate().exchange(
                url, HttpMethod.GET, new HttpEntity(header), className);
            return response.getBody();
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
}