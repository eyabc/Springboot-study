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
        searchFacade = new SearchFacade();
    }


    @Test
    public void 네이버영화API_평점높은순정렬_MOCK_TEST() {
        adapter = new MockAdapter();
        MovieDTO movies = searchFacade.getMoviesSortByUserRating(naverMovieService, "test");
        assertThat(5.78).isEqualTo(movies.getItems().get(0).getUserRating());
    }

    @Test
    public void 평점이있는_네이버영화API_필터_MOCK_TEST() {
        adapter = new MockAdapter();
        int expect = 1;
        MovieDTO movies = searchFacade.getMoviesHavingUserRating(naverMovieService, "test");
        assertThat(expect).isEqualTo(movies.getTotal());
    }

    @Test
    public void 태그가제거된_타이틀_네이버영화API_MOCK_TEST() {
        adapter = new MockAdapter();
        String expect = "The Test of Time";

        MovieDTO movies = searchFacade.getMoviesRemovedTags(naverMovieService, "test");
        assertThat(expect).isEqualTo(movies.getItems().get(0).getSubtitle());
    }
}
