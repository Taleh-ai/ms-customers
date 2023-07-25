package com.example.mscustomers.service.impl;

import com.example.mscustomers.dto.mapper.CustomerMapper;
import com.example.mscustomers.dto.request.CustomerRequestDto;
import com.example.mscustomers.dto.response.CustomerResponseDto;
import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.repository.CustomerRepository;
import com.example.mscustomers.securityconfig.JwtRequestFilter;
import com.example.mscustomers.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public CustomerResponseDto getCustomerInfo(String  email) {

        CustomerEntity entity = repository.findCustomerEntitiesByEmail(email);
        return  mapper.toDto(entity);
    }

    @Override
    public void deleteUser(Long id ) {
    repository.deleteById(id);
    }

    @Override
    public void updateCustomerInfo(Long id , CustomerRequestDto customerRequestDto) {
        CustomerEntity customerEntity = repository.getById(id);

        customerEntity.setEmail(customerRequestDto.getEmail());
        customerEntity.setGender(customerRequestDto.getGender());
        customerEntity.setFirstName(customerRequestDto.getFirstName());
        customerEntity.setLastName(customerRequestDto.getLastName());
        customerEntity.setPassword(passwordEncoder.encode(customerRequestDto.getPassword()));
        customerEntity.setPhoneNumber(customerRequestDto.getPhone());
        repository.save(customerEntity);
    }


}
