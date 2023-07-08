package com.example.mscustomers.controller;

import com.example.mscustomers.dto.response.UserResponseDto;
import com.example.mscustomers.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("v1")
public class UserController {
    private final UserServiceImpl service;
    @GetMapping("user/{email}")
    public UserResponseDto getUser(@PathVariable("email") String email){
      return  service.getUser(email);
    }

    @DeleteMapping("user/{email}")
    public void deleteUser(@PathVariable("email") String email){
        service.deletUser(email);
    }
}
