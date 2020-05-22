package com.eyabc.springboot.adapter;

import com.eyabc.springboot.adapter.response.Movie;
import com.eyabc.springboot.adapter.response.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class NaverAdapter {
    private final String SEARCH = "https://openapi.naver.com/v1/search/";
    private final String clientId = NaverAdapterSecret.getClientID();
    private final String clientSecret = NaverAdapterSecret.getClientSecret();
    private final RestTemplate restTemplate;

    public Shop callSearchShop(String query) {

        String url = SEARCH + "shop.json?query=" + query;
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE);
        header.add("Host", "openapi.naver.com");
        header.add("X-Naver-Client-Id", clientId);
        header.add("X-Naver-Client-Secret", clientSecret);

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
        header.add("X-Naver-Client-Id", clientId);
        header.add("X-Naver-Client-Secret", clientSecret);

        ResponseEntity<Movie> response = restTemplate.exchange(
                url, HttpMethod.GET, new HttpEntity(header), Movie.class
        );

        return response.getBody();
    }
}