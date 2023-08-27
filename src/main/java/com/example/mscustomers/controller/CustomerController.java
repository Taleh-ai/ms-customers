package com.example.mscustomers.controller;

import com.example.mscustomers.dto.request.CustomerRequestDto;
import com.example.mscustomers.dto.response.CustomerResponseDto;
import com.example.mscustomers.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class CustomerController {
    private final CustomerService service;

    @GetMapping("customer/{email}")
    public CustomerResponseDto getcustomer(@PathVariable("email")  String  email){
       return  service.getCustomerInfo(email);
    }

    @DeleteMapping("customer")
    public void deleteCustomer(Long id){
          service.deleteUser(id);
    }

    @PutMapping("customer/{email}")
    public void updateUser(@PathVariable("email") Long id,@RequestBody CustomerRequestDto customerRequestDto){
        service.updateCustomerInfo(id,customerRequestDto);
    }
}
