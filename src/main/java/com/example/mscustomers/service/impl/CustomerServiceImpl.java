package com.example.mscustomers.service.impl;

import com.example.mscustomers.dto.mapper.CustomerMapper;
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
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    @Override
    public CustomerResponseDto getCustomerInfo(String  email) {


        CustomerEntity entity = repository.findCustomerEntitiesByEmail(email);
        log.info(entity.getEmail());
        return  mapper.toDto(entity);
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void updatePassword() {

    }

    @Override
    public void updateCustomerInfo() {

    }
}
