package com.dinhanh.STDTB.mapper;

import com.dinhanh.STDTB.dto.request.UserCreationRequest;
import com.dinhanh.STDTB.dto.request.UserUpdateRequest;
import com.dinhanh.STDTB.dto.response.UserResponse;
import com.dinhanh.STDTB.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
