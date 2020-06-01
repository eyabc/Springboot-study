package com.eyabc.springboot.dto.search;

import com.eyabc.springboot.dto.kakao.KakaoBookDto;
import com.eyabc.springboot.dto.naver.NaverBookDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;


@Getter
@Builder
public class BookDTO {

    private static final String DATE_FORMAT = "yyyyMMdd";

    private String lastBuildDate;
    private long total;
    private List<BookItemDTO> items;

    public static BookDTO fromNaver (NaverBookDto dto) {
        return BookDTO.builder()
                      .lastBuildDate(LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                      .total(dto.getTotal())
                      .items(dto.getItems().stream()
                                           .map(item -> BookItemDTO.builder()
                                                                   .title(item.getTitle())
                                                                   .author(item.getAuthor())
                                                                   .description(item.getDescription())
                                                                   .link(item.getLink())
                                                                   .image(item.getImage())
                                                                   .price(item.getPrice())
                                                                   .discount(item.getDiscount())
                                                                   .publisher(item.getPublisher())
                                                                   .pubdate(item.getPubdate())
                                                                   .isbn(item.getIsbn())
                                                                   .build())
                                           .collect(Collectors.toList()))
                      .build();
    }

    public static BookDTO fromKakao (KakaoBookDto dto) {
        return BookDTO.builder()
                      .lastBuildDate(LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                      .total(dto.getMeta().getTotal_count())
                      .items(dto.getDocuments()
                                .stream()
                                .map(item ->
                                        BookItemDTO.builder()
                                            .title(item.getTitle())
                                            .author(item.getAuthors().stream().collect(joining(",")))
                                            .description(item.getContents())
                                            .link(item.getUrl())
                                            .image(item.getThumbnail())
                                            .price(item.getPrice())
                                            .discount(item.getSale_price())
                                            .publisher(item.getPublisher())
                                            .pubdate(
                                                item.getDatetime().substring(0, 4) +
                                                item.getDatetime().substring(5, 7) +
                                                item.getDatetime().substring(8, 10)
                                            )
                                            .isbn(item.getIsbn())
                                            .build())
                                .collect(Collectors.toList()))
                      .build();
    }

    @Getter
    @Builder
    public static class BookItemDTO {
        private String title;
        private String author;
        private String description; // content
        private String link; // url
        private String image; // thumbnail
        private int price;
        private int discount; // sale_price
        private String publisher;
        private String pubdate; // datetime "2008-03-10T00:00:00.000+09:00"
        private String isbn;

    }

}
