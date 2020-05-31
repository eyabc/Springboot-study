package com.eyabc.springboot.service.search;

import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.dto.naver.NaverMovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverMovieService implements SearchService {
    private final NaverAdapter naverAdapter;

    @Override
    public NaverMovieDto getByQuery (String query) {
        return naverAdapter.callSearch("movie", query, NaverMovieDto.class);
    }
}

