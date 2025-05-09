package com.dinhanh.STDTB.controller;

import com.dinhanh.STDTB.dto.request.UserCreationRequest;
import com.dinhanh.STDTB.entity.User;
import com.dinhanh.STDTB.service.UserService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUser();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUserId(userId);
    }
}
