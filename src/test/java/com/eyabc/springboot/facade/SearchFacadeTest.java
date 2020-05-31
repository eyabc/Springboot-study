package com.eyabc.springboot.facade;

import com.eyabc.springboot.adapter.MockNaverAdapter;
import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.dto.naver.NaverMovieDto;
import com.eyabc.springboot.service.search.NaverMovieService;
import com.eyabc.springboot.service.search.NaverShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchFacadeTest {

    private NaverAdapter naverAdapter;
    private NaverMovieService naverMovieService;
    private SearchFacade searchFacade;

    @BeforeEach
    void setUp () {
        naverAdapter = new MockNaverAdapter();
        naverMovieService = new NaverMovieService(naverAdapter);
        searchFacade = new SearchFacade(naverMovieService);
    }


    @Test
    public void 네이버영화API_평점높은순정렬_MOCK_TEST() {
        naverAdapter = new MockNaverAdapter();
        NaverMovieDto naverMovies = searchFacade.getNaverMoviesSortByUserRating("test");
        assertThat(5.78).isEqualTo(naverMovies.getItems().get(0).getUserRating());
    }
}
