package com.my.my_project.api_model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiUser {
    private String id;
    private String password;
    private String email;
}
