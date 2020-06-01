package com.eyabc.springboot.service.search;

import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.kakao.KakaoBookDto;
import com.eyabc.springboot.dto.search.BookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoBookService implements SearchService {

    private final Adapter adapter;

    @Override
    public BookDTO getByQuery(String query) {
        KakaoBookDto books = adapter.callSearch("book", query, KakaoBookDto.class);
        return BookDTO.fromKakao(books);
    }

}
