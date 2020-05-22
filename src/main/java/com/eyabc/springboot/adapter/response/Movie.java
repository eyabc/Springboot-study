package com.eyabc.springboot.adapter.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Movie {
    private String lastBuildDate;
    private long total;
    private long start;
    private int display;
    private List<MovieItem> items;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class MovieItem {
        private String title;
        private String link;
        private String image;
        private String subtitle;
        private String pubDate;
        private String director;
        private String actor;
        private String userRating;
    }
}
