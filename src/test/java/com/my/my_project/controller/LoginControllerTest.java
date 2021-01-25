package com.my.my_project.controller;

import com.my.my_project.domain.Login;
import com.my.my_project.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LoginControllerTest {
    @Test
    @DisplayName("로그인 요청")
    public void LoginRequestTest() {
        Login login = Login.builder()
                .id("root")
                .password("1234")
                .build();

        User user = login.login();

        assertThat(user).isNotNull();
        assertThat("root").isEqualTo(user.getUserId());
        assertThat("1234").isEqualTo(user.getPassword());
    }
}