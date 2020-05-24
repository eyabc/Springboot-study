package com.eyabc.springboot.endpoint;

import com.eyabc.springboot.facade.NaverFacade;
import com.eyabc.springboot.facade.RestTemplateFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ApiController.class)
public class ApiControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NaverFacade naverFacade;

    @MockBean
    private RestTemplateFacade restTemplateFacade;

    @Test
    public void 테스트API_TEST() throws Exception {

        mvc.perform(get("/api/test")).andExpect(status().isOk());

    }

    @DisplayName("RestTemplate의 Connection Pool을 테스트")
    @Test
    public void RestTemplatePooling_TEST() throws Exception {
        mvc.perform(get("/api/pooling-stats")).andExpect(status().isOk());
    }

    @Test
    public void 네이버쇼핑API_TEST() throws Exception {

        mvc.perform(
                get("/api/naver-shop").queryParam("query", "test")
        ).andExpect(status().isOk());

    }

    @Test
    public void 네이버영화API_TEST() throws Exception {

        mvc.perform(
                get("/api/naver-movie").queryParam("query", "신")
        ).andExpect(status().isOk());
    }

}
