package com.example.mscustomers.service.impl;

import com.example.mscustomers.dto.mapper.CartMapper;
import com.example.mscustomers.dto.request.CartRequestDto;
import com.example.mscustomers.dto.response.CartResponseDto;
import com.example.mscustomers.entity.CartEntity;
import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.exception.ResourceNotFoundException;
import com.example.mscustomers.repository.CartRepository;
import com.example.mscustomers.repository.CustomerRepository;
import com.example.mscustomers.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import lombok.Builder;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    private final CartMapper cartMapper;
    @Override
    public void createCart(CartRequestDto cartRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            CustomerEntity customerEntity = (CustomerEntity) userDetails;
                CartEntity cartEntity = CartEntity.builder()
                .productId(cartRequestDto.getProductId())
                .totalPrice(cartRequestDto.getProductQuantity())
                .customerEntity(customerEntity)
                .productQuantity(cartRequestDto.getProductQuantity())
                .build();
                cartRepository.save(cartEntity);
    }



    @Override
    public List<CartResponseDto> viewAllCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        CustomerEntity customerEntity = (CustomerEntity) userDetails;
       return cartMapper.toDtoList(cartRepository.getCartEntitiesByCustomerEntity(customerEntity));
    }

    @Override
    public void deleteCart(Long id) throws ResourceNotFoundException {
        if(cartRepository.existsById(id)){
            cartRepository.deleteById(id);
        }else {
            throw  new ResourceNotFoundException("Can't find item");
        }

    }

    @Override
    public void updateCart(Long id, int productCount) throws ResourceNotFoundException {
        if(cartRepository.existsById(id)){
            CartEntity cartEntity = cartRepository.getById(id);
            cartEntity.setProductQuantity(productCount);
            cartEntity.setTotalPrice(productCount);
        }else {
            throw  new ResourceNotFoundException("Can't find item");
        }
    }
}
