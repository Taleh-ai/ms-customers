package com.example.mscustomers.service;

import com.example.mscustomers.dto.request.UserRequestDto;
import com.example.mscustomers.dto.response.UserResponseDto;
import com.example.mscustomers.exception.ResourceNotFoundException;

public interface UserService {

    public UserResponseDto getUser(String email);

    public void deletUser(String email);
    public void updateUser(UserRequestDto updatedUser) throws ResourceNotFoundException;


}
