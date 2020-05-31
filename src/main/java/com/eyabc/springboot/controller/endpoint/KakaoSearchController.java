package com.eyabc.springboot.controller.endpoint;

import com.eyabc.springboot.dto.kakao.KakaoBookDto;
import com.eyabc.springboot.service.search.KakaoBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kakao-search")
public class KakaoSearchController {
    private final KakaoBookService kakaoBookService;

    @GetMapping("books")
    public KakaoBookDto getBooks(@RequestParam("query") String query) {
        return kakaoBookService.getByQuery(query);
    }
}
