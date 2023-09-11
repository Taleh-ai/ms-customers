package com.example.mscustomers.service;

import com.example.mscustomers.dto.request.OrderRequestDto;
import com.example.mscustomers.dto.response.OrderResponseDto;
import com.example.mscustomers.exception.ResourceNotFoundException;

import java.util.List;

public interface OrderForDealerService {
    public void addOrder(OrderRequestDto orderRequestDto);
    public void cancelOrder(Long id);
    public OrderResponseDto getOrderById(Long id) throws ResourceNotFoundException;
    public List<OrderResponseDto> getAllOrders();
}
