package com.eyabc.springboot;

import com.eyabc.springboot.dto.Naver.NaverSearchDto;
import com.eyabc.springboot.dto.Naver.NaverShopDto;
import com.eyabc.springboot.utils.JsonFileParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {



    @DisplayName("JSON Parser가 정상적으로 되고 있는지 확인하는 테스트")
    @Test
    void JSON_Parser_테스트 () {
        NaverSearchDto<NaverShopDto> naverShopObject = JsonFileParser.parse("shop", NaverSearchDto.class);
        assertThat("Sun, 24 May 2020 15:38:15 +0900").isEqualTo(naverShopObject.getLastBuildDate());
    }

}
