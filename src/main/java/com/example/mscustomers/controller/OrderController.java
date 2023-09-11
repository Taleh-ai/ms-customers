package com.example.mscustomers.controller;

import com.example.mscustomers.dto.request.CartRequestDto;
import com.example.mscustomers.dto.request.OrderRequestDto;
import com.example.mscustomers.dto.response.CartResponseDto;
import com.example.mscustomers.dto.response.OrderResponseDto;
import com.example.mscustomers.exception.ResourceNotFoundException;
import com.example.mscustomers.exception.handler.SuccessDetails;
import com.example.mscustomers.service.impl.OrderServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/orders")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class OrderController {
    private final OrderServiceImpl orderService;

    @PutMapping("{id}")
    public ResponseEntity<SuccessDetails<String>> cancelOrder(@PathVariable(name = "id") Long id ) throws ResourceNotFoundException {
        orderService.cancelOrder(id);
        return ResponseEntity.ok(new SuccessDetails<>("Order canceled Successfully!", HttpStatus.OK.value(),true));
    }

    @PostMapping
    public ResponseEntity<SuccessDetails<String>> addOrder( @RequestBody OrderRequestDto orderRequestDto) throws ResourceNotFoundException {
        orderService.addOrder(orderRequestDto);
        return ResponseEntity.ok(new SuccessDetails<>("Order added  Successfully!", HttpStatus.OK.value(),true));
    }

    @GetMapping
    public ResponseEntity<SuccessDetails<List<OrderResponseDto>>> getAllOrders(){
        return ResponseEntity.ok(new SuccessDetails<>(orderService.getAllOrders(), HttpStatus.OK.value(),true));
    }

    @GetMapping("{id}")
    public ResponseEntity<SuccessDetails<OrderResponseDto>> getOrder(@PathVariable(name = "id") Long id ) throws ResourceNotFoundException {
        return ResponseEntity.ok(new SuccessDetails<>(orderService.getOrderById(id), HttpStatus.OK.value(),true));
    }
}
