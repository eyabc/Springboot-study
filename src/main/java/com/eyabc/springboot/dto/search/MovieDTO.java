package com.eyabc.springboot.dto.search;

import com.eyabc.springboot.dto.naver.NaverMovieDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class MovieDTO {
    private static final String DATE_FORMAT = "yyyyMMdd";

    private String lastBuildDate;
    private long total;
    private List<MovieDTO.MovieItemDTO> items;

    public static MovieDTO fromNaver (NaverMovieDto dto) {
        return MovieDTO.builder()
                        .lastBuildDate(LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                        .total(dto.getTotal())
                        .items(dto.getItems().stream()
                        .map(item -> MovieDTO.MovieItemDTO.builder()
                                                            .title(item.getTitle())
                                                            .link(item.getLink())
                                                            .image(item.getImage())
                                                            .subtitle(item.getSubtitle())
                                                            .pubDate(item.getPubDate())
                                                            .director(item.getDirector())
                                                            .actor(item.getActor())
                                                            .userRating(item.getUserRating())
                                                            .build())
                                .collect(Collectors.toList()))
                .build();
    }

    public static MovieDTO updateDTO (MovieDTO dto, List<MovieItemDTO> lists) {
        return MovieDTO.builder()
                .lastBuildDate(dto.getLastBuildDate())
                .total(lists.size())
                .items(lists.stream()
                        .map(item -> MovieDTO.MovieItemDTO.builder()
                                .title(item.getTitle())
                                .link(item.getLink())
                                .image(item.getImage())
                                .subtitle(item.getSubtitle())
                                .pubDate(item.getPubDate())
                                .director(item.getDirector())
                                .actor(item.getActor())
                                .userRating(item.getUserRating())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }


    @Builder
    @Getter
    public static class MovieItemDTO {
        private String title;
        private String link;
        private String image;
        private String subtitle;
        private String pubDate;
        private String director;
        private String actor;
        private double userRating;

    }
}
