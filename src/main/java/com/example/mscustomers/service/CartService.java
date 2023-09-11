package com.example.mscustomers.service;

import com.example.mscustomers.dto.request.CartRequestDto;
import com.example.mscustomers.dto.response.CartResponseDto;
import com.example.mscustomers.exception.ResourceNotFoundException;

import java.util.List;

public interface CartService {
    public void createCart(CartRequestDto cartRequestDto) throws ResourceNotFoundException;
    public List<CartResponseDto> viewAllCart();

    public void deleteCart(Long id) throws ResourceNotFoundException;

    public void updateCart(Long id,int productCount) throws ResourceNotFoundException;
}
