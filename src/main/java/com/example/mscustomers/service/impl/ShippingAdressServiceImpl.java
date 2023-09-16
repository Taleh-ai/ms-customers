package com.example.mscustomers.service.impl;

import com.example.mscustomers.mapper.ShippingAdressMapper;
import com.example.mscustomers.dto.request.ShippingAdressRequestDto;
import com.example.mscustomers.dto.response.ShippingAdressResponseDto;
import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.entity.ShippingAddressEntity;
import com.example.mscustomers.repository.CustomerRepository;
import com.example.mscustomers.repository.ShippinAdressRepository;
import com.example.mscustomers.service.ShippingAdressService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingAdressServiceImpl implements ShippingAdressService {
    private final ShippinAdressRepository shippinAdressRepository;
    private final ShippingAdressMapper shippingAdressMapper;
    private final CustomerRepository customerRepository;

    @Override
    public List<ShippingAdressResponseDto> getUserAdresses() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            CustomerEntity customerEntity = customerRepository.findCustomerEntityByEmail( userDetails.getUsername());
            return shippingAdressMapper.toDtoList(shippinAdressRepository.findAllByCustomerEntity(customerEntity) );
        }else{
            return null;
        }
    }

    @Override
    public ShippingAdressResponseDto getUserAdress(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            CustomerEntity customerEntity = customerRepository.findCustomerEntityByEmail( userDetails.getUsername());
            return shippingAdressMapper.toDto((ShippingAddressEntity) shippinAdressRepository.findAllByCustomerEntity(customerEntity).stream().filter(n->n.getAddressId() ==id));

        }else{
            return null;
        }
    }

    @Override
    public void updateAdress(Long id, ShippingAdressRequestDto shippingAdressRequestDto) {
      ShippingAddressEntity entity =   shippinAdressRepository.getById(id);
      entity.setAddressPurpose(shippingAdressRequestDto.getAdressPurpose());
      entity.setCity(shippingAdressRequestDto.getCity());
      entity.setStreet(shippingAdressRequestDto.getStreet());
      entity.setCountry(shippingAdressRequestDto.getCountry());
      entity.setHomeNo(shippingAdressRequestDto.getHomeNo());
        shippinAdressRepository.save(entity);
    }

    @Override
    public void addAdress(ShippingAdressRequestDto shippingAdressRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            CustomerEntity customerEntity = customerRepository.findCustomerEntityByEmail( userDetails.getUsername());
            ShippingAddressEntity shippingAddressEntity = shippingAdressMapper.fromDto(shippingAdressRequestDto);
            shippingAddressEntity.setCustomerEntity(customerEntity);
            shippinAdressRepository.save(shippingAddressEntity);
        }
    }
}
