package com.eyabc.springboot.controller.endpoint;

import com.eyabc.springboot.adapter.Adapter;
import com.eyabc.springboot.dto.search.BookDTO;
import com.eyabc.springboot.service.search.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Profile("kakao")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/search")
public class KakaoSearchController {
    protected SearchService searchService;
    private final Adapter adapter;

    @GetMapping("/books")
    public BookDTO getBooks(@RequestParam("query") String query) {
        searchService = new KakaoBookService(adapter);
        return searchService.getByQuery(query);
    }
}
