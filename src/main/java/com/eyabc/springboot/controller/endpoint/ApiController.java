package com.eyabc.springboot.controller.endpoint;

import com.eyabc.springboot.dto.Movie;
import com.eyabc.springboot.dto.Shop;
import com.eyabc.springboot.facade.NaverFacade;
import com.eyabc.springboot.facade.RestTemplateFacade;
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
    private RestTemplateFacade restTemplateFacade;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/pooling-stats")
    public String getPoolingStates() {
        return restTemplateFacade.getPoolingStates();
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
