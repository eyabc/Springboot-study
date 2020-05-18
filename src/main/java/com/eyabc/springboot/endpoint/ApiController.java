package com.eyabc.springboot.endpoint;

import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.adapter.NaverAdapterResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {

    private final NaverAdapter naverAdapter;

    @GetMapping("/naver-shop")
    public NaverAdapterResponse searchShop(@RequestParam("query") String query) {
        return naverAdapter.callSearchShop(query);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
