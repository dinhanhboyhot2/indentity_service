package com.dinhanh.STDTB.controller;

import com.dinhanh.STDTB.dto.request.UserCreationRequest;
import com.dinhanh.STDTB.dto.request.UserUpdateRequest;
import com.dinhanh.STDTB.entity.User;
import com.dinhanh.STDTB.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUser();
    }

    @GetMapping("/users/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUserId(userId);
    }
    @PutMapping("/users/{userId}")
    User updateUser(@PathVariable String userId,@RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }
    @DeleteMapping("/users/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
