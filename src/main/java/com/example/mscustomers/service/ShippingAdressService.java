package com.example.mscustomers.service;

import com.example.mscustomers.dto.response.ShippingAdressResponseDto;

public interface ShippingAdressService {
    public ShippingAdressResponseDto getUserAdresses();
    public ShippingAdressResponseDto getUserAdress();
    public void updateAdress();
    public void addAdress();

}
