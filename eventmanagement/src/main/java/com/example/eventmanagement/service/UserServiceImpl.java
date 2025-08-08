package com.example.eventmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eventmanagement.domain.User;
import com.example.eventmanagement.dto.UserRequestDto;
import com.example.eventmanagement.dto.UserResponseDto;
import com.example.eventmanagement.mapper.UserMapper;
import com.example.eventmanagement.repository.UserRepository;
import com.example.eventmanagement.exceptions.ResourceNotFoundException;
import com.example.eventmanagement.exceptions.DuplicateResourceException;
import com.example.eventmanagement.exceptions.InvalidRequestException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new DuplicateResourceException("User with email " + userRequestDto.getEmail() + " already exists");
        }
        User user = UserMapper.toUser(userRequestDto);
        User savedUser = userRepository.save(user);
        return UserMapper.toUserResponseDto(savedUser);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidRequestException("Invalid user ID provided");
        }
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return UserMapper.toUserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toUserResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        if (id == null || id <= 0) {
            throw new InvalidRequestException("Invalid user ID provided");
        }
        User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        User updatedUser = userRepository.save(user);
        return UserMapper.toUserResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
