package com.eyabc.springboot.adapter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NaverAdapterResponse {
    private String lastBuildDate;
    private long total;
    private long start;
    private long display;
    private List<NaverAdapterResponseItems> items;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class NaverAdapterResponseItems {
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
