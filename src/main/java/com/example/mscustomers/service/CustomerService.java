package com.example.mscustomers.service;

import com.example.mscustomers.dto.response.CustomerResponseDto;

public interface CustomerService {
    public CustomerResponseDto getCustomerInfo(String  email);
    public void deleteUser();
    public void updatePassword();

    public void updateCustomerInfo();
}
