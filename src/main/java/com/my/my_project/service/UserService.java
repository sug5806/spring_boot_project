package com.my.my_project.service;

import com.my.my_project.domain.User;
import com.my.my_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }
}
