package com.dinhanh.STDTB.service;
import com.dinhanh.STDTB.dto.request.UserCreationRequest;
import com.dinhanh.STDTB.dto.request.UserUpdateRequest;
import com.dinhanh.STDTB.entity.User;
import com.dinhanh.STDTB.repository.UserRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserCreationRequest request){
        User user = new User();
        if(userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("Username already exists");
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public User getUserId(String id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User updateUser(String userID,UserUpdateRequest request){
        User user = getUserId(userID);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }
    public void deleteUser(String userID){
        userRepository.deleteById(userID);
    }
}
