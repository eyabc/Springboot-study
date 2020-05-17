package com.eyabc.springboot.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NaverAdapter {
    private final String SEARCH_SHOP = "https://openapi.naver.com/v1/search/shop.json";
}
