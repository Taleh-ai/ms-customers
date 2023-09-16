package com.example.mscustomers.mapper;

import com.example.mscustomers.client.ProductServiceClient;
import com.example.mscustomers.dto.enumeration.OrderStatus;
import com.example.mscustomers.dto.request.OrderRequestDto;
import com.example.mscustomers.dto.response.OrderResponseDto;
import com.example.mscustomers.entity.CartEntity;
import com.example.mscustomers.entity.OrderEntity;
import com.example.mscustomers.repository.CartRepository;
import com.example.mscustomers.repository.OrderRepository;
import com.example.mscustomers.repository.ShippinAdressRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final ShippinAdressRepository shippinAdressRepository;
    private final ProductServiceClient productServiceClient;
    private final ShippingAdressMapper shippingAdressMapper;
    public List<OrderEntity> fromDtoList(OrderRequestDto orderRequestDto){
        List<CartEntity> cartEntityList = cartRepository.getCartEntitiesByCartIdIn(orderRequestDto.getCardId());
        List<OrderEntity> orderEntityList = cartEntityList.stream().map(n-> OrderEntity.builder()
                .productId(n.getProductId())
                .customerEntity(n.getCustomerEntity())
                .quantity(n.getProductQuantity())
                .shippingAddress(shippinAdressRepository.getById(orderRequestDto.getShippingAddressId()))
                .totalPrice(n.getProductQuantity()*productServiceClient.getProductPriceById(n.getProductId()).getBody().getData().doubleValue())
                .status(OrderStatus.PENDING)
                .build()).collect(Collectors.toList());
       return orderEntityList;
    }

    public OrderResponseDto toDto(OrderEntity orderEntity){
        OrderResponseDto orderResponseDto =    OrderResponseDto.builder()
                .id(orderEntity.getId())
                .cancelDate(orderEntity.getCancelDate())
                .orderDate(orderEntity.getOrderDate())
                .orderStatus(orderEntity.getStatus())
                .productResponseDto(productServiceClient.getProductById(orderEntity.getProductId()).getBody().getData())
                .customerId(orderEntity.getCustomerEntity().getId())
                .deliveredDate(orderEntity.getDeliveredDate())
                .fullName(orderEntity.getCustomerEntity().getFirstName() + " " +orderEntity.getCustomerEntity().getLastName())
                .shippingDate(orderEntity.getShippingDate())
                .shippingAdressResponseDto(shippingAdressMapper.toDto(orderEntity.getShippingAddress()))
                .quantity(orderEntity.getQuantity())
                .totalPrice(orderEntity.getTotalPrice())
                .build();

    return  orderResponseDto;
    }

}
