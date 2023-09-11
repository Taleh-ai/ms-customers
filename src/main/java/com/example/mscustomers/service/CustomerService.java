package com.example.mscustomers.service;

import com.example.mscustomers.dto.request.CustomerRequestDto;
import com.example.mscustomers.dto.response.CustomerResponseDto;

public interface CustomerService {
    public CustomerResponseDto getCustomerInfo();
    public void deleteUser();
    public void updateCustomerInfo( CustomerRequestDto customerRequestDto);


}
