package com.eyabc.springboot.controller.endpoint;

import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.dto.naver.NaverMovieDto;
import com.eyabc.springboot.dto.naver.NaverShopDto;
import com.eyabc.springboot.service.search.NaverMovieService;
import com.eyabc.springboot.service.search.NaverShopService;
import com.eyabc.springboot.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/naver-search")
@RequiredArgsConstructor
public class NaverSearchController {

    private SearchService searchService;

    private final NaverAdapter naverAdapter;

    @GetMapping("/shops")
    public NaverShopDto searchShop(@RequestParam("query") String query) {
        searchService = new NaverShopService(naverAdapter);
        return searchService.getByQuery(query);
    }

    @GetMapping("/movies")
    public NaverMovieDto searchMovie(@RequestParam("query") String query) {
        searchService = new NaverMovieService(naverAdapter);
        return searchService.getByQuery(query);
    }

}
