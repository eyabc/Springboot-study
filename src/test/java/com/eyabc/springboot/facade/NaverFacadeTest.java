package com.eyabc.springboot.facade;

import com.eyabc.springboot.adapter.MockNaverAdapter;
import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.dto.Naver.NaverMovieDto;
import com.eyabc.springboot.service.NaverMovieService;
import com.eyabc.springboot.service.NaverShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NaverFacadeTest {

    private NaverAdapter naverAdapter;
    private NaverMovieService naverMovieService;
    private NaverShopService naverShopService;
    private NaverFacade naverFacade;

    @BeforeEach
    void setUp () {
        naverAdapter = new MockNaverAdapter();
        naverMovieService = new NaverMovieService(naverAdapter);
        naverShopService = new NaverShopService(naverAdapter);
        naverFacade = new NaverFacade(naverMovieService, naverShopService);
    }


    @Test
    public void 네이버영화API_평점높은순정렬_MOCK_TEST() {
        NaverMovieDto naverMovieObject = naverFacade.getMovieListSortByUserRating("test");
        assertThat(5.78).isEqualTo(naverMovieObject.getItems().get(0).getUserRating());
    }
}
