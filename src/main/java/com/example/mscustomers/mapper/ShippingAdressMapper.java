package com.example.mscustomers.mapper;

import com.example.mscustomers.dto.request.ShippingAdressRequestDto;
import com.example.mscustomers.dto.response.ShippingAdressResponseDto;
import com.example.mscustomers.entity.ShippingAddressEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Component

public class ShippingAdressMapper {



    public ShippingAddressEntity fromDto(ShippingAdressRequestDto dto){
        ShippingAddressEntity entity = new ShippingAddressEntity();
        entity.setCity(dto.getCity());
        entity.setAddressPurpose(dto.getAdressPurpose());
        entity.setCountry(dto.getCountry());
        entity.setStreet(dto.getStreet());
        entity.setHomeNo(dto.getHomeNo());
        return entity;
    }

    public ShippingAdressResponseDto toDto(ShippingAddressEntity entity){
        ShippingAdressResponseDto dto = new ShippingAdressResponseDto();
        dto.setAddressId(entity.getAddressId());
        dto.setCity(entity.getCity());
        dto.setAdressPurpose(entity.getAddressPurpose());
        dto.setCountry(entity.getCountry());
        dto.setStreet(dto.getStreet());
        dto.setCustomerId(entity.getCustomerEntity().getId());
        dto.setHomeNo(dto.getHomeNo());
        return dto;
    }

    public List<ShippingAdressResponseDto> toDtoList(List<ShippingAddressEntity> shippingAddressEntityList){
        ShippingAdressMapper shippingAdressMapper = new ShippingAdressMapper();
       return shippingAddressEntityList.stream().map(n->shippingAdressMapper.toDto(n)).collect(Collectors.toList());
    }
}
