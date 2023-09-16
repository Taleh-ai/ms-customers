package com.example.mscustomers.service.impl;

import com.example.mscustomers.client.ProductServiceClient;
import com.example.mscustomers.dto.enumeration.OrderStatus;
import com.example.mscustomers.dto.request.OrderRequestDto;
import com.example.mscustomers.dto.response.OrderResponseDto;
import com.example.mscustomers.entity.CartEntity;
import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.entity.OrderEntity;
import com.example.mscustomers.exception.MethodArgumentNotValidException;
import com.example.mscustomers.exception.OrderCancellationException;
import com.example.mscustomers.exception.ResourceNotFoundException;
import com.example.mscustomers.mapper.OrderMapper;
import com.example.mscustomers.repository.CartRepository;
import com.example.mscustomers.repository.CustomerRepository;
import com.example.mscustomers.repository.OrderRepository;
import com.example.mscustomers.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final OrderMapper orderMapper;
    private final ProductServiceClient productServiceClient;
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public void addOrder(OrderRequestDto orderRequestDto) {
    List<CartEntity> cartEntityList = cartRepository.getCartEntitiesByCartIdIn(orderRequestDto.getCardId());
        List<OrderEntity> orderEntity = orderMapper.fromDtoList(orderRequestDto);
        orderRepository.saveAll(orderEntity);
        cartRepository.deleteCartEntitiesByCartIdIn(orderRequestDto.getCardId());
        orderEntity.stream().map(n->productServiceClient.updateProductStock(n.getProductId(),n.getQuantity())).collect(Collectors.toList());
    }

    @Override
    public void cancelOrder(Long id) {
      OrderEntity orderEntity =  orderRepository.getById(id);
      if(orderEntity.getStatus().getDisplayName() == "Pending" || orderEntity.getStatus().getDisplayName() == "Processing"){
          orderEntity.setStatus(OrderStatus.CANCELLED);
          orderEntity.setCancelDate(LocalDate.now());
          orderRepository.save(orderEntity);
      }else {
          throw new OrderCancellationException("You can't cancel order in " + orderEntity.getStatus().getDisplayName());
      }
    }

    @Override
    public OrderResponseDto getOrderById(Long id) throws ResourceNotFoundException {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + id));
        return orderMapper.toDto(orderEntity);
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        CustomerEntity customerEntity = customerRepository.findCustomerEntityByEmail( userDetails.getUsername());
        List<OrderEntity> orderEntities = orderRepository.getOrderEntitiesByCustomerEntity(customerEntity);
        return orderEntities.stream().map(n->orderMapper.toDto(n)).collect(Collectors.toList());
    }

    @Override
    public void updateOrder(Long id, OrderStatus orderStatus) throws MethodArgumentNotValidException {
      OrderEntity orderEntity =   orderRepository.getById(id);
      switch (orderStatus){
          case SHIPPED:
              orderEntity.setShippingDate(LocalDate.now());
              orderEntity.setStatus(orderStatus);
          case DELIVERED:
              orderEntity.setDeliveredDate(LocalDate.now());
              orderEntity.setStatus(orderStatus);
          case PROCESSING:
              orderEntity.setStatus(orderStatus);
          case CANCELLED:throw new MethodArgumentNotValidException("You can't cancel in this controller");
      }
      orderRepository.save(orderEntity);
    }
}