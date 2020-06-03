package com.eyabc.springboot.facade;

import com.eyabc.springboot.config.RestTemplateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class RestTemplateFacade {
    private final RestTemplate restTemplate;
    private final RestTemplateUtil restTemplateUtil;

    public String getPoolingStates() {
        log.info(restTemplateUtil.createHttpInfo());
        try {
            return this.restTemplate.getForObject("http://localhost:8083/api/naver-shop?query=test", String.class);
        } catch (Exception e) {
            log.error(restTemplateUtil.createHttpInfo());
            return e.getMessage();
        }
    }
}
