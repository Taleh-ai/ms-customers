package com.example.mscustomers.dto.response;

import com.example.mscustomers.dto.enumeration.OrderStatus;
import com.example.mscustomers.entity.ShippingAddressEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class OrderResponseDto {
    private Long id;
    private Long customerId;
    private String fullName;
    private int quantity;
    private double totalPrice;
    private LocalDate orderDate;
    private LocalDate deliveredDate;
    private LocalDate cancelDate;
    private LocalDate shippingDate;
    private ProductResponseDto productResponseDto;
    private OrderStatus orderStatus;
    private ShippingAdressResponseDto shippingAdressResponseDto;
}
