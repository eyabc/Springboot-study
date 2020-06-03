package com.eyabc.springboot.service;

import com.eyabc.springboot.adapter.MockAdapter;
import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.search.MovieDTO;
import com.eyabc.springboot.dto.search.ShopDTO;
import com.eyabc.springboot.service.search.MovieService;
import com.eyabc.springboot.service.search.NaverMovieService;
import com.eyabc.springboot.service.search.NaverShopService;
import com.eyabc.springboot.service.search.SearchService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class NaverSearchServiceTest {
    SearchService searchService;
    MovieService movieService;
    Adapter adapter = new MockAdapter();

    @Test
    public void 네이버쇼핑API_TEST() throws Exception {
        int expect = 78903;
        searchService = new NaverShopService(adapter);
        ShopDTO result = searchService.getByQuery("test");
        assertThat(expect).isEqualTo(result.getTotal());
    }

    @Test
    public void 네이버영화API_TEST() throws Exception {
        int expect = 45;
        movieService = new NaverMovieService(adapter);
        MovieDTO result =  searchService.getByQuery("test");

        assertThat(expect).isEqualTo(result.getTotal());

    }

}
