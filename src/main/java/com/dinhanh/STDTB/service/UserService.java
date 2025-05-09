package com.dinhanh.STDTB.service;
import com.dinhanh.STDTB.dto.request.UserCreationRequest;
import com.dinhanh.STDTB.entity.User;
import com.dinhanh.STDTB.repository.UserRepository;
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
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
