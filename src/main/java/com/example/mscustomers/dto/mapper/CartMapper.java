package com.example.mscustomers.dto.mapper;

import com.example.mscustomers.dto.request.CartRequestDto;
import com.example.mscustomers.dto.request.ShippingAdressRequestDto;
import com.example.mscustomers.dto.response.CartResponseDto;
import com.example.mscustomers.dto.response.ShippingAdressResponseDto;
import com.example.mscustomers.entity.CartEntity;
import com.example.mscustomers.entity.ShippingAdressEntity;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Component
@RequiredArgsConstructor
public class CartMapper {

    public CartEntity fromDto(CartRequestDto dto){
        CartEntity entity = new CartEntity();
        entity.setProductId(dto.getProductId());
        entity.setProductQuantity(dto.getProductQuantity());
        return entity;
    }

    public CartResponseDto toDto(CartEntity entity){
        CartResponseDto responseDto = new CartResponseDto();
        responseDto.setId(entity.getCartId());
        responseDto.setProductQuantity(entity.getProductQuantity());
        responseDto.setTotalPrice(entity.getTotalPrice());
        return responseDto;
    }

    public List<CartResponseDto> toDtoList(List<CartEntity> cartEntityList){
        CartMapper cartMapper = new CartMapper();
        return cartEntityList.stream().map(cartMapper::toDto).collect(Collectors.toList());
    }
}
