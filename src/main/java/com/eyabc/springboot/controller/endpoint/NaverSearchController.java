package com.eyabc.springboot.controller.endpoint;

import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.naver.NaverShopDto;
import com.eyabc.springboot.dto.search.BookDTO;
import com.eyabc.springboot.dto.search.MovieDTO;
import com.eyabc.springboot.service.search.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Profile("naver")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/search")
public class NaverSearchController {
    private SearchService searchService;
    private MovieService movieService;
    final Adapter adapter;

    @GetMapping("/shops")
    public NaverShopDto searchShop(@RequestParam("query") String query) {
        searchService = new NaverShopService(adapter);
        return searchService.getByQuery(query);
    }

    @GetMapping("/movies")
    public MovieDTO searchMovie(@RequestParam("query") String query) {
        movieService = new NaverMovieService(adapter);
        return searchService.getByQuery(query);
    }

    @GetMapping("/books")
    public BookDTO getBooks(@RequestParam("query") String query) {
        searchService = new NaverBookService(adapter);
        return searchService.getByQuery(query);
    }
}
