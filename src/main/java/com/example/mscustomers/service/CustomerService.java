package com.example.mscustomers.service;

import com.example.mscustomers.dto.request.CustomerRequestDto;
import com.example.mscustomers.dto.response.CustomerResponseDto;

public interface CustomerService {
    public CustomerResponseDto getCustomerInfo(String  email);
    public void deleteUser(Long id );
    public void updateCustomerInfo(Long id , CustomerRequestDto customerRequestDto);


}
