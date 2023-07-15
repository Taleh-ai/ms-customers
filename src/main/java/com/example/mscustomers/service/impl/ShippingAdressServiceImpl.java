//package com.example.mscustomers.service.impl;
//
//import com.example.mscustomers.dto.response.ShippingAdressResponseDto;
//import com.example.mscustomers.entity.CustomerEntity;
//import com.example.mscustomers.service.JwtUserDetailsService;
//import com.example.mscustomers.service.ShippingAdressService;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ShippingAdressServiceImpl implements ShippingAdressService {
//    @Override
//    public ShippingAdressResponseDto getUserAdresses() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication != null && authentication.isAuthenticated()) {
//            String username = authentication.getName();
//
//
//        }
//    }
//
//    @Override
//    public ShippingAdressResponseDto getUserAdress() {
//        return null;
//    }
//
//    @Override
//    public void updateAdress() {
//
//    }
//
//    @Override
//    public void addAdress() {
//
//    }
//}
