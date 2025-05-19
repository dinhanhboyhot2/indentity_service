package com.dinhanh.STDTB.service;
import com.dinhanh.STDTB.dto.request.UserCreationRequest;
import com.dinhanh.STDTB.dto.request.UserUpdateRequest;
import com.dinhanh.STDTB.entity.User;
import com.dinhanh.STDTB.exception.AppException;
import com.dinhanh.STDTB.exception.ErrorCode;
import com.dinhanh.STDTB.mapper.UserMapper;
import com.dinhanh.STDTB.repository.UserRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    private UserMapper userMapper;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    User user = new User();
    public User createUser(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
         user = userMapper.toUser(request);
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
        UserMapper userMapper = this.userMapper;
        return userRepository.save(user);
    }
    public void deleteUser(String userID){
        userRepository.deleteById(userID);
    }
}
