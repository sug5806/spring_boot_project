package com.my.my_project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Login {
    private String id;
    private String password;

    public User login() {
        return User.builder()
                .userId("root")
                .password("1234")
                .build();
    }
}
