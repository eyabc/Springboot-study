package com.eyabc.springboot.service;

import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.dto.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverMovieService implements NaverSearchService {
    private final NaverAdapter naverAdapter;

    @Override
    public Movie getByQuery (String query) {
        return naverAdapter.callSearch("movie", query, Movie.class);
    }
}

