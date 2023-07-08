package com.example.mscustomers.service.impl;

import com.example.mscustomers.mapper.UserMapper;
import com.example.mscustomers.dto.request.UserRequestDto;
import com.example.mscustomers.dto.response.UserResponseDto;
import com.example.mscustomers.entity.UserEntity;
import com.example.mscustomers.exception.ResourceNotFoundException;
import com.example.mscustomers.repository.UserRepository;
import com.example.mscustomers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponseDto getUser(String email){
        UserEntity entity =  repository.findByEmail(email);
        return  mapper.toDto(entity);
    }
    @Override
    public void deletUser(String email){
        repository.deleteByEmail(email);
    }
    @Override
    public void updateUser(UserRequestDto updatedUser) throws ResourceNotFoundException {
        if(repository.findByEmail(updatedUser.getEmail()).getEmail().isEmpty()){
        throw  new ResourceNotFoundException("Specified User not found!");
        }else{

        }
    }
}
