package com.eyabc.springboot.endpoint;

import com.eyabc.springboot.adapter.NaverAdapter;
import com.eyabc.springboot.facade.NaverFacade;
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

    @Test
    public void 테스트_TEST() throws Exception {

        mvc.perform(get("/api/test")).andExpect(status().isOk());

    }

    @Test
    public void 네이버쇼핑_TEST() throws Exception {

        mvc.perform(
                get("/api/naver-shop").queryParam("query", "test")
        ).andExpect(status().isOk());

    }

    @Test
    public void 네이버영화_TEST() throws Exception {

        mvc.perform(
                get("/api/naver-movie").queryParam("query", "신")
        ).andExpect(status().isOk());
    }

    @Test
    public void 네이버영화_평점높은순정렬_TEST() throws Exception {

        mvc.perform(
                get("/api/naver-movie").queryParam("query", "신")
        ).andExpect(status().isOk());
    }
}
