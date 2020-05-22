package com.eyabc.springboot.endpoint;

import com.eyabc.springboot.adapter.response.Movie;
import com.eyabc.springboot.adapter.response.Shop;
import com.eyabc.springboot.facade.NaverFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {

    private NaverFacade naverFacade;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/naver-shop")
    public Shop searchShop(@RequestParam("query") String query) {
        return naverFacade.getShopList(query);
    }

    @GetMapping("/naver-movie")
    public Movie searchMovie(@RequestParam("query") String query) {
        return naverFacade.getMovieList(query);
    }


}
