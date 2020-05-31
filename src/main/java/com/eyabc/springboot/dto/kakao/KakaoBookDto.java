package com.eyabc.springboot.dto.kakao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class KakaoBookDto extends KakaoSearchDto<KakaoBookDto.BookItem> {

    @Setter
    @Getter
    @NoArgsConstructor
    public static class BookItem {
        private List<String> authors;
        private String contents;
        private String datetime;
        private String isbn;
        private int price;
        private String publisher;
        private int sale_price;
        private String status;
        private String thumbnail;
        private String title;
        private List<String> translators;
        private String url;
    }
}
