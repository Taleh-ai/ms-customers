package com.example.mscustomers.service.impl;

import com.example.mscustomers.mapper.CustomerMapper;
import com.example.mscustomers.dto.request.CustomerRequestDto;
import com.example.mscustomers.dto.response.CustomerResponseDto;
import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.repository.CustomerRepository;
import com.example.mscustomers.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public CustomerResponseDto getCustomerInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            CustomerEntity customerEntity = (CustomerEntity) userDetails;
            return  mapper.toDto(customerEntity);
        }
        return null;
    }

    @Override
    public void deleteUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            CustomerEntity customerEntity = (CustomerEntity) userDetails;
            repository.deleteById(customerEntity.getId());
        }
    }

    @Override
    public void updateCustomerInfo(CustomerRequestDto customerRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            CustomerEntity customerEntity = (CustomerEntity) userDetails;
        customerEntity.setEmail(customerRequestDto.getEmail());
        customerEntity.setGender(customerRequestDto.getGender());
        customerEntity.setFirstName(customerRequestDto.getFirstName());
        customerEntity.setLastName(customerRequestDto.getLastName());
        customerEntity.setPassword(passwordEncoder.encode(customerRequestDto.getPassword()));
        customerEntity.setPhoneNumber(customerRequestDto.getPhone());
        repository.save(customerEntity);
    }
}
}
