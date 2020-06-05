package com.eyabc.springboot.group;

import com.eyabc.springboot.dto.search.MovieDTO;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class MovieGroup {

    private final MovieDTO movieDTO;

    public MovieGroup(MovieDTO movieDTO) {
        this.movieDTO = movieDTO;
    }

    public MovieDTO getMovies() {
        return movieDTO;
    }

    public List<MovieDTO.MovieItemDTO> getMoviesOrderRating() {
        return movieDTO.getItems()
                .stream()
                .sorted((a, b) -> b.getUserRating() > a.getUserRating() ? 1 : -1)
                .collect(Collectors.toList());
    }

    public List<MovieDTO.MovieItemDTO> getListHavingUserRating() {
        return movieDTO.getItems().stream()
                .filter(v -> v.getUserRating() != 0.0)
                .collect(toList());
    }

    public List<MovieDTO.MovieItemDTO> getListRemovedTags() {
        String tagPattern = "<b>|</b>";

        return movieDTO.getItems().stream().map(item -> MovieDTO.MovieItemDTO.builder()
                .title(item.getTitle().replaceAll(tagPattern, ""))
                .link(item.getLink())
                .image(item.getImage())
                .subtitle(item.getSubtitle().replaceAll(tagPattern, ""))
                .pubDate(item.getPubDate())
                .director(item.getDirector())
                .actor(item.getActor())
                .userRating(item.getUserRating())
                .build())
                .collect(Collectors.toList());
    }


}
