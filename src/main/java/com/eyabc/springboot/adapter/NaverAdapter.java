package com.eyabc.springboot.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverAdapter {
    private final String SEARCH_SHOP = "https://openapi.naver.com/v1/search/shop.json";
    private final String clientId = NaverAdapterSecret.getClientID();
    private final String clientSecret = NaverAdapterSecret.getClientSecret();
    private final RestTemplate restTemplate;

    public NaverAdapterResponse callSearchShop(String query) {

        String url = SEARCH_SHOP + "?query=" + query;
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE);
        header.add("Host", "openapi.naver.com");
        header.add("X-Naver-Client-Id", clientId);
        header.add("X-Naver-Client-Secret", clientSecret);

        ResponseEntity<NaverAdapterResponse> response = restTemplate.exchange(
          url, HttpMethod.GET, new HttpEntity(header), NaverAdapterResponse.class
        );

        return response.getBody();
    }

    @Component
    public static class RestTemplate extends org.springframework.web.client.RestTemplate { }
}