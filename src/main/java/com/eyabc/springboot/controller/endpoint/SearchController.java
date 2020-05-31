package com.eyabc.springboot.controller.endpoint;

import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.kakao.KakaoBookDto;
import com.eyabc.springboot.dto.naver.NaverBookDto;
import com.eyabc.springboot.dto.naver.NaverMovieDto;
import com.eyabc.springboot.dto.naver.NaverShopDto;
import com.eyabc.springboot.dto.search.MovieDTO;
import com.eyabc.springboot.service.search.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

    private SearchService searchService;
    private final KakaoBookService kakaoBookService;
    private final NaverBookService naverBookService;

    private final Adapter adapter;

    @GetMapping("/shops")
    public NaverShopDto searchShop(@RequestParam("query") String query) {
        searchService = new NaverShopService(adapter);
        return searchService.getByQuery(query);
    }

    @GetMapping("/movies")
    public List<MovieDTO> searchMovie(@RequestParam("query") String query) {
        searchService = new NaverMovieService(adapter);
        return searchService.getByQuery(query);
    }

    @GetMapping("/books")
    public KakaoBookDto getBooks(@RequestParam("query") String query) {
        return kakaoBookService.getByQuery(query);
    }

    @GetMapping("/naver-books")
    public NaverBookDto getNaverBooks(@RequestParam("query") String query) { return naverBookService.getByQuery(query); }
}
