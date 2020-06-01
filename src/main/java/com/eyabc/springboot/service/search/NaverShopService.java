package com.eyabc.springboot.service.search;

import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.naver.NaverShopDto;
import com.eyabc.springboot.dto.search.ShopDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverShopService implements SearchService {
    private final Adapter adapter;

    @Override
    public ShopDTO getByQuery (String query) {
        return ShopDTO.fromNaver(adapter.callSearch("naver","shop", query, NaverShopDto.class));
    }
}
