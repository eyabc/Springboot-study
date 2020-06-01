package com.eyabc.springboot.facade;

import com.eyabc.springboot.adapter.MockAdapter;
import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.search.MovieDTO;
import com.eyabc.springboot.service.search.NaverMovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchFacadeTest {

    private Adapter adapter;
    private NaverMovieService naverMovieService;
    private SearchFacade searchFacade;

    @BeforeEach
    void setUp () {
        adapter = new MockAdapter();
        naverMovieService = new NaverMovieService(adapter);
        searchFacade = new SearchFacade(naverMovieService);
    }


    @Test
    public void 네이버영화API_평점높은순정렬_MOCK_TEST() {
        adapter = new MockAdapter();
        MovieDTO naverMovies = searchFacade.getNaverMoviesSortByUserRating("test");
        assertThat(5.78).isEqualTo(naverMovies.getItems().get(0).getUserRating());
    }
}
