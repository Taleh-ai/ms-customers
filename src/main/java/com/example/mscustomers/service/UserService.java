package com.example.mscustomers.service;

import com.example.mscustomers.dto.mapper.UserMapper;
import com.example.mscustomers.dto.request.UserRequestDto;
import com.example.mscustomers.dto.response.UserResponseDto;
import com.example.mscustomers.entity.UserEntity;
import com.example.mscustomers.exception.ResourceNotFoundException;
import com.example.mscustomers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface UserService {

    public UserResponseDto getUser(String email);

    public void deletUser(String email);
    public void updateUser(UserRequestDto updatedUser) throws ResourceNotFoundException;


}
