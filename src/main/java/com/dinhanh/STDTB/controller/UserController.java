package com.dinhanh.STDTB.controller;

import com.dinhanh.STDTB.dto.request.UserCreationRequest;
import com.dinhanh.STDTB.entity.User;
import com.dinhanh.STDTB.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }
    @GetMapping
    List<User> getUsers(){

    }
}
