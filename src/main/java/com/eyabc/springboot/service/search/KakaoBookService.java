package com.eyabc.springboot.service.search;

import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.kakao.KakaoBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoBookService implements SearchService {

    @Qualifier()
    private final Adapter adapter;

    @Override
    public KakaoBookDto getByQuery(String query) {
        return adapter.callSearch("book", query, KakaoBookDto.class);
    }

}
