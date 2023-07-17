package com.example.mscustomers.dto.mapper;

import com.example.mscustomers.dto.request.ShippingAdressRequestDto;
import com.example.mscustomers.dto.response.ShippingAdressResponseDto;
import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.entity.ShippingAdressEntity;
import com.example.mscustomers.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
@RequiredArgsConstructor
public class ShippingAdressMapper {

    private final CustomerRepository repository;
    public ShippingAdressEntity fromDto(ShippingAdressRequestDto dto){
        ShippingAdressEntity entity = new ShippingAdressEntity();
        entity.setCity(dto.getCity());
        entity.setAdressPurpose(dto.getAdressPurpose());
        entity.setCountry(dto.getCountry());
        entity.setStreet(dto.getStreet());
        entity.setHomeNo(dto.getHomeNo());
        entity.setCustomerEntity(repository.getById(dto.getCustomerId()));
        return entity;
    }

    public ShippingAdressResponseDto toDto(ShippingAdressEntity entity){
        ShippingAdressResponseDto dto = new ShippingAdressResponseDto();
        dto.setAddressId(entity.getAddressId());
        dto.setCity(entity.getCity());
        dto.setAdressPurpose(entity.getAdressPurpose());
        dto.setCountry(entity.getCountry());
        dto.setStreet(dto.getStreet());
        dto.setCustomerId(entity.getCustomerEntity().getId());
        dto.setHomeNo(dto.getHomeNo());
        return dto;
    }
}
