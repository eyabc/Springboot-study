package com.eyabc.springboot.service.search;

import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.naver.NaverMovieDto;
import com.eyabc.springboot.dto.search.MovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverMovieService implements SearchService {
    private final Adapter adapter;

    public MovieDTO getByQuery (String query) {
        return MovieDTO.fromNaver(adapter.callSearch("movie", query, NaverMovieDto.class));
    }
}

