package com.eyabc.springboot.service.search;

import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.naver.NaverBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverBookService implements SearchService {
    private final Adapter adapter;

    @Override
    public NaverBookDto getByQuery (String query) {
        return adapter.callSearch("book", query, NaverBookDto.class);
    }
}

