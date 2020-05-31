package com.eyabc.springboot.facade;

import com.eyabc.springboot.dto.naver.NaverMovieDto;
import com.eyabc.springboot.service.search.NaverMovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SearchFacade {
    private NaverMovieService naverMovieService;

    public NaverMovieDto getNaverMoviesSortByUserRating(String query) {
        NaverMovieDto movies = naverMovieService.getByQuery(query);
        movies.getItems().sort((a, b) -> b.getUserRating() > a.getUserRating() ? 1 : -1);
        return movies;
    }
}
