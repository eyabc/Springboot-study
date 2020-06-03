package com.eyabc.springboot.dto.naver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NaverShopDto extends NaverSearchDto<NaverShopDto.ShopItem> {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ShopItem {
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
