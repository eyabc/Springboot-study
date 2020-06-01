package com.eyabc.springboot.service.search;

import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.naver.NaverBookDto;
import com.eyabc.springboot.dto.search.BookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverBookService implements SearchService {
    private final Adapter adapter;

    @Override
    public BookDTO getByQuery (String query) {
        return BookDTO.fromNaver(adapter.callSearch("book", query, NaverBookDto.class));
    }
}

