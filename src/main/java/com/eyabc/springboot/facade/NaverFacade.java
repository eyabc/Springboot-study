package com.eyabc.springboot.facade;

import com.eyabc.springboot.adapter.response.Movie;
import com.eyabc.springboot.adapter.response.Shop;
import com.eyabc.springboot.service.NaverMoveService;
import com.eyabc.springboot.service.NaverShopService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NaverFacade {

    @NonNull private final NaverMoveService naverMoveService;
    @NonNull private final NaverShopService naverShopService;

    public Shop getShopList (String query) {
        return naverShopService.getShop(query);
    }

    public Movie getMovieList (String query) {
        Movie movie = naverMoveService.getMovie(query);
        movie.getItems().sort((a, b) -> b.getUserRating() > a.getUserRating() ? 1 : -1);
        return movie;
    }

}
