package com.eyabc.springboot.service;

import com.eyabc.springboot.adapter.MockNaverAdapter;
import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.dto.naver.NaverMovieDto;
import com.eyabc.springboot.dto.naver.NaverShopDto;
import com.eyabc.springboot.service.search.NaverMovieService;
import com.eyabc.springboot.service.search.NaverShopService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class NaverSearchServiceTest {
    NaverAdapter naverAdapter = new MockNaverAdapter();

    @Test
    public void 네이버쇼핑API_TEST() throws Exception {
        int expect = 78903;
        NaverShopService searchService = new NaverShopService(naverAdapter);
        NaverShopDto result = searchService.getByQuery("test");
        assertThat(expect).isEqualTo(result.getTotal());

    }

    @Test
    public void 네이버영화API_TEST() throws Exception {
        int expect = 45;

        NaverMovieService searchService = new NaverMovieService(naverAdapter);
        NaverMovieDto result =  searchService.getByQuery("test");

        assertThat(expect).isEqualTo(result.getTotal());

    }

}
