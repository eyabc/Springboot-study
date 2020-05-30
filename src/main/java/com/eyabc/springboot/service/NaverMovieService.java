package com.eyabc.springboot.service;

import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.dto.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverMovieService {

    private final NaverAdapter naverAdapter;

    public Movie callMovie (String query) {
        return naverAdapter.callSearch("movie", query, Movie.class);
    }
}

