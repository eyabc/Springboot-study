package com.eyabc.springboot.facade;

import com.eyabc.springboot.dto.search.MovieDTO;
import com.eyabc.springboot.service.search.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class SearchFacade {
    public MovieDTO getMoviesSortByUserRating(MovieService movieService, String query) {
        MovieDTO movies = movieService.getByQuery(query);
        movies.getItems().sort((a, b) -> b.getUserRating() > a.getUserRating() ? 1 : -1);
        return movies;
    }

    public MovieDTO getMoviesHavingUserRating(MovieService movieService, String query) {
        MovieDTO movies = movieService.getByQuery(query);
        List filtered = movies.getItems()
                .stream()
                .filter(v -> v.getUserRating() != 0.0)
                .collect(toList());

        return MovieDTO.builder()
                .lastBuildDate(movies.getLastBuildDate())
                .total(filtered.size())
                .items(filtered)
                .build();
    }

}
