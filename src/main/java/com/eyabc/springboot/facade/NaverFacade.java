package com.eyabc.springboot.facade;

import com.eyabc.springboot.dto.Naver.NaverMovieDto;
import com.eyabc.springboot.dto.Naver.NaverShopDto;
import com.eyabc.springboot.service.NaverMovieService;
import com.eyabc.springboot.service.NaverShopService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NaverFacade {

    @NonNull private final NaverMovieService naverMovieService;
    @NonNull private final NaverShopService naverShopService;

    public NaverShopDto getShopList (String query) {
        return naverShopService.getByQuery(query);
    }

    public NaverMovieDto getMovieList (String query) {
        return  naverMovieService.getByQuery(query);
    }

    public NaverMovieDto getMovieListSortByUserRating (String query) {
        NaverMovieDto result = naverMovieService.getByQuery(query);
        result.getItems().sort((a, b) -> b.getUserRating() > a.getUserRating() ? 1 : -1);
        return result;
    }

}
