package com.eyabc.springboot.facade;

import com.eyabc.springboot.dto.search.MovieDTO;
import com.eyabc.springboot.service.search.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public MovieDTO getMoviesRemovedTags(MovieService movieService, String query) {
        MovieDTO movies = movieService.getByQuery(query);
        String tagPattern = "<b>|</b>";

        return MovieDTO.builder()
                .lastBuildDate(movies.getLastBuildDate())
                .total(movies.getTotal())
                .items(movies.getItems().stream()
                        .map(item -> MovieDTO.MovieItemDTO.builder()
                                .title(item.getTitle().replaceAll(tagPattern, ""))
                                .link(item.getLink())
                                .image(item.getImage())
                                .subtitle(item.getSubtitle().replaceAll(tagPattern, ""))
                                .pubDate(item.getPubDate())
                                .director(item.getDirector())
                                .actor(item.getActor())
                                .userRating(item.getUserRating())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }


}
