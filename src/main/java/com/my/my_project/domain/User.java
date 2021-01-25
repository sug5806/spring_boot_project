package com.my.my_project.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long Id;

    @NonNull
    private String userId;
    @NonNull
    private String password;
    private String email;

}
