package com.example.eventmanagement.service;

import com.example.eventmanagement.dto.UserRequestDto;
import com.example.eventmanagement.dto.UserResponseDto;
import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);
    void deleteUser(Long id);
}
