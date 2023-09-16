package com.example.mscustomers.service;

import com.example.mscustomers.dto.enumeration.OrderStatus;
import com.example.mscustomers.dto.request.OrderRequestDto;
import com.example.mscustomers.dto.response.OrderResponseDto;
import com.example.mscustomers.exception.MethodArgumentNotValidException;
import com.example.mscustomers.exception.ResourceNotFoundException;

import java.util.List;

public interface OrderService {
    public void addOrder(OrderRequestDto orderRequestDto);
    public void cancelOrder(Long id);
    public OrderResponseDto getOrderById(Long id) throws ResourceNotFoundException;
    public List<OrderResponseDto> getAllOrders();

    public void updateOrder(Long id, OrderStatus orderStatus) throws MethodArgumentNotValidException;
}
