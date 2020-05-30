package com.eyabc.springboot.dto.Naver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NaverMovieDto extends NaverSearchDto<NaverMovieDto.MovieItem> {
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
        private double userRating;
    }
}
