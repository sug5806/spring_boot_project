package com.my.my_project.controller;

import com.my.my_project.api_model.ApiUser;
import com.my.my_project.domain.User;
import com.my.my_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ApiUser apiUser) {
        User createdUser = userService.create(apiUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{user-id}")
    public ResponseEntity<?> update(@RequestBody ApiUser apiUser,
                                    @PathVariable("user-id") Long userId) {

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
