package com.my.my_project.controller;

import com.my.my_project.domain.Login;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LoginControllerTest {
    @Test
    public void LoginRequestTest() {
        Login login = new Login("id", "password");

        String message = login.login();

        assertThat("success").isEqualTo(message);
    }
}