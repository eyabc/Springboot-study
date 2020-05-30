package com.eyabc.springboot.dto.Naver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class NaverSearchDto<T> {
    private String lastBuildDate;
    private long total;
    private long start;
    private int display;
    private List<T> items;
}
