package com.eyabc.springboot.dto.naver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class NaverBookDto extends NaverSearchDto<NaverBookDto.BookItems> {

    @Setter
    @Getter
    @NoArgsConstructor
    public static class BookItems {
        private String title;
        private String link;
        private String image;
        private String author;
        private int price;
        private int discount;
        private String publisher;
        private String pubdate;
        private String isbn;
        private String description;
    }
}
