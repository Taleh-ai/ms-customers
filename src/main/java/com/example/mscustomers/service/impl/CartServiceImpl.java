package com.example.mscustomers.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.example.mscustomers.dto.request.CartRequestDto;
import com.example.mscustomers.dto.response.CartResponseDto;
import com.example.mscustomers.dto.response.ProductResponseDto;
import com.example.mscustomers.entity.CartEntity;
import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.exception.ResourceNotFoundException;
import com.example.mscustomers.mapper.CartMapper;
import com.example.mscustomers.repository.CartRepository;
import com.example.mscustomers.repository.CustomerRepository;
import com.example.mscustomers.exception.handler.SuccessDetails;
import com.example.mscustomers.service.CartService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final CustomerRepository customerRepository;
    private final ProductServiceImpl productService;

    @Override
    public void createCart(CartRequestDto cartRequestDto) throws ResourceNotFoundException {
        ProductResponseDto productResponseDto = productService.getProductById(cartRequestDto.getProductId());

        if (Objects.isNull(productResponseDto)) {
            if (!"No stock".equals(productResponseDto.getStockSituation())) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                CustomerEntity customerEntity = customerRepository.findCustomerEntityByEmail(userDetails.getUsername());
                CartEntity cartEntity = cartMapper.fromDto(cartRequestDto);
                cartEntity.setCustomerEntity(customerEntity);
                cartRepository.save(cartEntity);
            } else {
                throw new ResourceNotFoundException("Not enough stock");
            }
        } else {
            throw new ResourceNotFoundException("Product service is unavailable");
        }
    }

    @Override
    public List<CartResponseDto> viewAllCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        CustomerEntity customerEntity = customerRepository.findCustomerEntityByEmail(userDetails.getUsername());
        logger.info(customerEntity.getEmail());
        List<CartEntity> cartEntities = cartRepository.getCartEntitiesByCustomerEntity(customerEntity);
        List<CartResponseDto> cartResponseDtoList = cartMapper.toDtoList(cartEntities);

        cartResponseDtoList.forEach(cartResponseDto -> {
            logger.info(cartResponseDto.getProductId().toString());
            ProductResponseDto productResponseDto = productService.getProductById(cartResponseDto.getProductId());
            logger.info(productResponseDto.toString());
            double productprice = productResponseDto.getAmount();
            logger.info(String.valueOf(productprice));

                double totalPrice =  productprice * cartResponseDto.getProductQuantity();
                cartResponseDto.setTotalPrice(totalPrice);

        });

        return cartResponseDtoList;
    }

    @Override
    public void deleteCart(Long id) throws ResourceNotFoundException {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Cart item not found");
        }
    }

    @Override
    public void updateCart(Long id, int productCount) throws ResourceNotFoundException {
        Optional<CartEntity> optionalCartEntity = cartRepository.findById(id);
        if (optionalCartEntity.isPresent()) {
            CartEntity cartEntity = optionalCartEntity.get();
            cartEntity.setProductQuantity(productCount);
            cartRepository.save(cartEntity);
        } else {
            throw new ResourceNotFoundException("Cart item not found");
        }
    }
}
