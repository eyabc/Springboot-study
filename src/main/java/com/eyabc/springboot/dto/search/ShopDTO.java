package com.eyabc.springboot.dto.search;

import com.eyabc.springboot.dto.naver.NaverShopDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class ShopDTO {
    private static final String DATE_FORMAT = "yyyyMMdd";

    private String lastBuildDate;
    private long total;
    private List<ShopDTO.ShopItemDTO> items;

    public static ShopDTO fromNaver(NaverShopDto dto) {
        return ShopDTO.builder()
                .lastBuildDate(LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                .total(dto.getTotal())
                .items(dto.getItems().stream()
                        .map(item -> ShopDTO.ShopItemDTO.builder()
                                .title(item.getTitle())
                                .link(item.getLink())
                                .image(item.getImage())
                                .lprice(item.getLprice())
                                .hprice(item.getHprice())
                                .mallName(item.getMallName())
                                .productId(item.getProductId())
                                .productType(item.getProductType())
                                .brand(item.getBrand())
                                .maker(item.getMaker())
                                .category1(item.getCategory1())
                                .category2(item.getCategory2())
                                .category3(item.getCategory3())
                                .category4(item.getCategory4())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    @Builder
    @Getter
    public static class ShopItemDTO {
        private String title;
        private String link;
        private String image;
        private String lprice;
        private String hprice;
        private String mallName;
        private String productId;
        private String productType;
        private String brand;
        private String maker;
        private String category1;
        private String category2;
        private String category3;
        private String category4;
    }
}
