package com.example.mscustomers.controller;

import com.example.mscustomers.dto.response.CustomerResponseDto;
import com.example.mscustomers.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class CustomerController {
    private final CustomerService service;

    @GetMapping("customer")

    public CustomerResponseDto getcustomer(String  email){
       return  service.getCustomerInfo(email);
    }
}
