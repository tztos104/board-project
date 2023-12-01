package com.boardproject.boardproject.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Disabled
@WebMvcTest
class BoardControllerTest {

    private final MockMvc mvc;

    BoardControllerTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("게시글 리스트 호출 테스트")
    @Test
    public void 게시글리스트테스트() throws Exception {
        mvc.perform(get("/boards"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML))
                .andExpect(view().name("boards/index"))
                .andExpect(model().attributeExists("boards"));
    }
}