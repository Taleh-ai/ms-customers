package com.example.mscustomers.mapper;

import com.example.mscustomers.dto.request.UserRequestDto;
import com.example.mscustomers.dto.response.UserResponseDto;
import com.example.mscustomers.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public class UserMapper {

    public UserEntity fromDto(UserRequestDto userRequestDto){
        UserEntity entity = new UserEntity();
        entity.setGender(userRequestDto.getGender());
        entity.setEmail(userRequestDto.getEmail());
        entity.setFullName(userRequestDto.getFullName());
        entity.setPhoneNumber(userRequestDto.getPhoneNumber());
        entity.setDateOfBirth(userRequestDto.getDateOfBirth());
        entity.setPassword(userRequestDto.getPassword());
        return entity;
    }
    public UserResponseDto toDto(UserEntity userEntity){
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(userEntity.getId());
        responseDto.setGender(userEntity.getGender());
        responseDto.setEmail(userEntity.getEmail());
        responseDto.setFullName(userEntity.getFullName());
        responseDto.setPhoneNumber(userEntity.getPhoneNumber());
        responseDto.setDateOfBirth(userEntity.getDateOfBirth());
        return responseDto;
    }
}
