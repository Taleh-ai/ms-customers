package com.example.mscustomers.service;

import com.example.mscustomers.dto.request.ShippingAdressRequestDto;
import com.example.mscustomers.dto.response.ShippingAdressResponseDto;

import java.util.List;

public interface ShippingAdressService {
    public List<ShippingAdressResponseDto> getUserAdresses();
    public ShippingAdressResponseDto getUserAdress(Long id);
    public void updateAdress(Long id, ShippingAdressRequestDto shippingAdressRequestDto);
    public void addAdress( ShippingAdressRequestDto shippingAdressRequestDto);

}
