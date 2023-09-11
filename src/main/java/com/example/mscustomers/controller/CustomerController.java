package com.example.mscustomers.controller;

import com.example.mscustomers.dto.request.CustomerRequestDto;
import com.example.mscustomers.dto.response.CustomerResponseDto;
import com.example.mscustomers.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/customer")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    public CustomerResponseDto getcustomer(){
       return  service.getCustomerInfo();
    }

    @DeleteMapping
    public void deleteCustomer(){
          service.deleteUser();
    }

    @PutMapping
    public void updateUser(@RequestBody CustomerRequestDto customerRequestDto){
        service.updateCustomerInfo(customerRequestDto);
    }
}
