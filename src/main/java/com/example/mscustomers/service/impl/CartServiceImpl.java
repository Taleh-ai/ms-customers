package com.example.mscustomers.service.impl;

import com.example.mscustomers.client.ProductServiceClient;
import com.example.mscustomers.dto.response.ProductResponseDto;
import com.example.mscustomers.exception.handler.SuccessDetails;
import com.example.mscustomers.mapper.CartMapper;
import com.example.mscustomers.dto.request.CartRequestDto;
import com.example.mscustomers.dto.response.CartResponseDto;
import com.example.mscustomers.entity.CartEntity;
import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.exception.ResourceNotFoundException;
import com.example.mscustomers.repository.CartRepository;
import com.example.mscustomers.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ProductServiceClient productServiceClient;

    @Override
    public void createCart(CartRequestDto cartRequestDto) throws ResourceNotFoundException {
        ResponseEntity<SuccessDetails<ProductResponseDto>> productResponseDto = productServiceClient.getProductById(cartRequestDto.getProductId());

        if (productResponseDto.getStatusCode().is2xxSuccessful()) {
            ProductResponseDto productDto = productResponseDto.getBody().getData();
            if (!"No stock".equals(productDto.getStockSituation())) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                CustomerEntity customerEntity = (CustomerEntity) userDetails;
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
        CustomerEntity customerEntity = (CustomerEntity) userDetails;
        List<CartEntity> cartEntities = cartRepository.getCartEntitiesByCustomerEntity(customerEntity);
        List<CartResponseDto> cartResponseDtoList = cartMapper.toDtoList(cartEntities);

        cartResponseDtoList.forEach(cartResponseDto -> {
            ResponseEntity<SuccessDetails<ProductResponseDto>> productDtoResponse = productServiceClient.getProductById(cartResponseDto.getProductId());

            if (productDtoResponse.getStatusCode().is2xxSuccessful()) {
                ProductResponseDto productDto = productDtoResponse.getBody().getData();
                double totalPrice = productDto.getPrice() * cartResponseDto.getProductQuantity();
                cartResponseDto.setTotalPrice(totalPrice);
            } else {
                // Handle the case where the Feign client call failed
                // You can log an error message or handle it as needed
            }
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
