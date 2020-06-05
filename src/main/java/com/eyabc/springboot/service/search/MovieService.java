package com.eyabc.springboot.service.search;

import com.eyabc.springboot.dto.search.MovieDTO;

public interface MovieService {
    public MovieDTO getByQuery (String query);
}
