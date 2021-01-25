package com.my.my_project.service;

import com.my.my_project.api_model.ApiUser;
import com.my.my_project.domain.User;
import com.my.my_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public User create(ApiUser apiUser) {
        User user = User.builder()
                .userId(apiUser.getId())
                .password(apiUser.getPassword())
                .email(apiUser.getEmail())
                .build();

        return userRepository.save(user);
    }


}
