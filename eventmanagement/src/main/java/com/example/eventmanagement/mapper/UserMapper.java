package com.example.eventmanagement.mapper;

import com.example.eventmanagement.domain.User;
import com.example.eventmanagement.dto.UserRequestDto;
import com.example.eventmanagement.dto.UserResponseDto;

public class UserMapper {
    
        public static User toUser(UserRequestDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }
    public static UserResponseDto toUserResponseDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }


    
}
