package com.eyabc.springboot.service;

import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.dto.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverShopService implements NaverSearchService {
    private final NaverAdapter naverAdapter;

    @Override
    public Shop getByQuery (String query) {
        return naverAdapter.callSearch("shop", query, Shop.class);
    }
}
