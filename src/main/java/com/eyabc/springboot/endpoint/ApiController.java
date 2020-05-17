package com.eyabc.springboot.endpoint;

import com.eyabc.springboot.adapter.NaverAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
@RequiredArgsConstructor
public class ApiController {

    private final NaverAdapter naverAdapter;

    @GetMapping("/naver-shop")
    public String searchShop(@RequestParam("query") String query) {
        return naverAdapter.callSearchShop(query);
    }
}
