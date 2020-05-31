package com.eyabc.springboot.service.search;

import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.dto.naver.NaverShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverShopService implements SearchService {
    private final NaverAdapter naverAdapter;

    @Override
    public NaverShopDto getByQuery (String query) {
        return naverAdapter.callSearch("shop", query, NaverShopDto.class);
    }
}
