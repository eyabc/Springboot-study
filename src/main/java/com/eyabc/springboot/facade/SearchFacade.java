package com.eyabc.springboot.facade;

import com.eyabc.springboot.dto.search.MovieDTO;
import com.eyabc.springboot.service.search.NaverMovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchFacade {
    private NaverMovieService naverMovieService;

    public MovieDTO getNaverMoviesSortByUserRating(String query) {
        MovieDTO movies = naverMovieService.getByQuery(query);
        movies.getItems().sort((a, b) -> b.getUserRating() > a.getUserRating() ? 1 : -1);
        return movies;
    }
}
