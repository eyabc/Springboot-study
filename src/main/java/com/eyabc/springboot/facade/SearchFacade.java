package com.eyabc.springboot.facade;

import com.eyabc.springboot.dto.search.MovieDTO;
import com.eyabc.springboot.utils.MovieUtils;
import com.eyabc.springboot.service.search.MovieService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchFacade {
    public MovieDTO getMoviesSortByUserRating(MovieService movieService, String query) {
        MovieDTO movies = movieService.getByQuery(query);
        List<MovieDTO.MovieItemDTO> newLists = MovieUtils.getListOrderRating(movies.getItems());

        return MovieDTO.updateDTO(movies, newLists);
    }

    public MovieDTO getMoviesHavingUserRating(MovieService movieService, String query) {
        MovieDTO movies = movieService.getByQuery(query);
        List<MovieDTO.MovieItemDTO> newLists = MovieUtils.getListHavingUserRating(movies.getItems());

        return MovieDTO.updateDTO(movies, newLists);
    }

    public MovieDTO getMoviesRemovedTags(MovieService movieService, String query) {
        MovieDTO movies = movieService.getByQuery(query);
        List<MovieDTO.MovieItemDTO> newLists = MovieUtils.getListRemovedTags(movies.getItems());

        return MovieDTO.updateDTO(movies, newLists);
    }


}
