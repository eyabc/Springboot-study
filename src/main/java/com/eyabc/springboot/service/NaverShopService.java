package com.eyabc.springboot.service;

import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.adapter.response.Shop;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverShopService {

    @NonNull private final NaverAdapter naverAdapter;

    public Shop getShop (String query) {
        return naverAdapter.callSearchShop(query);
    }
}
