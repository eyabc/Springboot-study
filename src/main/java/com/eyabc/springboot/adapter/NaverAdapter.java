package com.eyabc.springboot.adapter;

import com.eyabc.springboot.adapter.response.Movie;
import com.eyabc.springboot.adapter.response.Shop;
import com.eyabc.springboot.property.NaverSecretProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class NaverAdapter {
    private final NaverSecretProperty naverSecretProperty;
    private final String SEARCH = "https://openapi.naver.com/v1/search/";
    private final RestTemplate restTemplate;

    public Shop callSearchShop(String query) {

        String url = SEARCH + "shop.json?query=" + query;
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE);
        header.add("Host", "openapi.naver.com");
        header.add("X-Naver-Client-Id", naverSecretProperty.getClientID());
        header.add("X-Naver-Client-Secret", naverSecretProperty.getClientSecret());

        ResponseEntity<Shop> response = restTemplate.exchange(
          url, HttpMethod.GET, new HttpEntity(header), Shop.class
        );

        return response.getBody();
    }

    public Movie callSearchMovie(String query) {

        String url = SEARCH + "movie.json?query=" + query;
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE);
        header.add("Host", "openapi.naver.com");
        header.add("X-Naver-Client-Id", naverSecretProperty.getClientID());
        header.add("X-Naver-Client-Secret", naverSecretProperty.getClientID());

        ResponseEntity<Movie> response = restTemplate.exchange(
                url, HttpMethod.GET, new HttpEntity(header), Movie.class
        );

        return response.getBody();
    }
}