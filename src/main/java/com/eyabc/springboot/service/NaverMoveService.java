package com.eyabc.springboot.service;

import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.adapter.response.Movie;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverMoveService {

    @NonNull private final NaverAdapter naverAdapter;

    public Movie getMovie (String query) {
        return naverAdapter.callSearchMovie(query);
    }
}
