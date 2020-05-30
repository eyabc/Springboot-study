package com.eyabc.springboot.service;

import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.dto.Naver.NaverShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverShopService implements NaverSearchService {
    private final NaverAdapter naverAdapter;

    @Override
    public NaverShopDto getByQuery (String query) {
        return naverAdapter.callSearch("shop", query, NaverShopDto.class);
    }
}
