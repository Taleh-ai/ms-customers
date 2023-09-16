package com.example.mscustomers.controller;

import com.example.mscustomers.dto.request.CustomerRequestDto;
import com.example.mscustomers.dto.response.CustomerResponseDto;
import com.example.mscustomers.exception.handler.SuccessDetails;
import com.example.mscustomers.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/customer")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    public ResponseEntity<SuccessDetails<CustomerResponseDto>> getcustomer(){
        return ResponseEntity.ok(new SuccessDetails<>(service.getCustomerInfo(), HttpStatus.OK.value(),true));
    }

    @DeleteMapping
    public ResponseEntity<SuccessDetails<String>> deleteCustomer(){
          service.deleteUser();
        return ResponseEntity.ok(new SuccessDetails<>("Customer deleted Successfully!", HttpStatus.OK.value(),true));
    }

    @PutMapping
    public ResponseEntity<SuccessDetails<String>> updateUser(@RequestBody CustomerRequestDto customerRequestDto){
        service.updateCustomerInfo(customerRequestDto);
        return ResponseEntity.ok(new SuccessDetails<>("Customer infos updated Successfully!", HttpStatus.OK.value(),true));
    }
}
