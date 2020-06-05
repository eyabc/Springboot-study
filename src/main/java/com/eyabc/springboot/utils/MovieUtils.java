package com.eyabc.springboot.utils;

import com.eyabc.springboot.dto.search.MovieDTO;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class MovieUtils {
    public static List<MovieDTO.MovieItemDTO> getListOrderRating(List<MovieDTO.MovieItemDTO> list) {
        list.sort((a, b) -> b.getUserRating() > a.getUserRating() ? 1 : -1);
        return list;
    }

    public static List<MovieDTO.MovieItemDTO> getListHavingUserRating(List<MovieDTO.MovieItemDTO> list) {
        return list.stream()
                .filter(v -> v.getUserRating() != 0.0)
                .collect(toList());
    }

    public static List<MovieDTO.MovieItemDTO> getListRemovedTags(List<MovieDTO.MovieItemDTO> list) {
        String tagPattern = "<b>|</b>";

        return list.stream().map(item -> MovieDTO.MovieItemDTO.builder()
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
