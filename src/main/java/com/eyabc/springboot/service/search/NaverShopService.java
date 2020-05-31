package com.eyabc.springboot.service.search;

import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.naver.NaverShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverShopService implements SearchService {
    private final Adapter adapter;

    @Override
    public NaverShopDto getByQuery (String query) {
        return adapter.callSearch("shop", query, NaverShopDto.class);
    }
}
