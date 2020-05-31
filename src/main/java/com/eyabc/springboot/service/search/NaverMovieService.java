package com.eyabc.springboot.service.search;

import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.naver.NaverMovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverMovieService implements SearchService {
    private final Adapter adapter;

    @Override
    public NaverMovieDto getByQuery (String query) {
        return adapter.callSearch("movie", query, NaverMovieDto.class);
    }
}

