package com.my.my_project.controller;

import com.my.my_project.domain.User;
import com.my.my_project.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("유저 생성")
    public void create() throws Exception {
        given(userService.create(any())).willReturn(
                User.builder()
                        .Id(1L)
                        .userId("admin")
                        .password("1234")
                        .email("admin@naver.com")
                        .build()
        );

        mockMvc.perform(post("/user/create")
                .content("{\"user_id\":\"admin\",\"password\":\"1234\",\"email\":\"admin@naver.com\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"user_id\":\"admin\",\"email\":\"admin@naver.com\",\"id\":1}"));

        verify(userService).create(any());
    }


    @Test
    public void update() throws Exception {
        mockMvc.perform(put("/user/1")
                .content("{\"id\":1,\"password\":\"4321\",\"email\":\"1111@naver.com\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}