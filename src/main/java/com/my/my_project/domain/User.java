package com.my.my_project.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty
    private String userId;
    @NonNull
    @NotEmpty
    private String password;

    private String email;

}
