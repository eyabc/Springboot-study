package com.eyabc.springboot.adapter;

import com.eyabc.springboot.config.RestTemplateConfiguration;
import com.eyabc.springboot.property.KakaoSecretProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("!test & kakao")
public class KakaoSearchAdapter implements Adapter {

    private final KakaoSecretProperty kakaoSecretProperty;
    private final String BASE_URL = "https://dapi.kakao.com/v3/search/";
    private final RestTemplateConfiguration restTemplateConfiguration;

    public <T> T callSearch (String service, String target, String query, Class<T> className) {
        String url = BASE_URL + target + "?query=" + query;
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE);
        header.add("Host", "dapi.kakao.com");
        header.add("Authorization", kakaoSecretProperty.getRestapiKey());

        ResponseEntity<T> response = restTemplateConfiguration.restTemplate().exchange(
                url, HttpMethod.GET, new HttpEntity(header), className);

        return response.getBody();
    }
}