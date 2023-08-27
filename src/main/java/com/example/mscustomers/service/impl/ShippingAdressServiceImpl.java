package com.example.mscustomers.service.impl;

import com.example.mscustomers.dto.mapper.ShippingAdressMapper;
import com.example.mscustomers.dto.request.ShippingAdressRequestDto;
import com.example.mscustomers.dto.response.ShippingAdressResponseDto;
import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.entity.ShippingAdressEntity;
import com.example.mscustomers.repository.ShippinAdressRepository;
import com.example.mscustomers.service.JwtUserDetailsService;
import com.example.mscustomers.service.ShippingAdressService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.dom4j.dom.DOMNodeHelper.getAttributes;

@Service
@RequiredArgsConstructor
public class ShippingAdressServiceImpl implements ShippingAdressService {
    private final ShippinAdressRepository shippinAdressRepository;
    private final ShippingAdressMapper shippingAdressMapper;
    @Override
    public List<ShippingAdressResponseDto> getUserAdresses() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            CustomerEntity customerEntity = (CustomerEntity) userDetails;
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
            CustomerEntity customer = (CustomerEntity) userDetails;
            return shippingAdressMapper.toDto((ShippingAdressEntity) shippinAdressRepository.findAllByCustomerEntity(customer).stream().filter(n->n.getAddressId() ==id));

        }else{
            return null;
        }
    }

    @Override
    public void updateAdress(Long id, ShippingAdressRequestDto shippingAdressRequestDto) {
      ShippingAdressEntity entity =   shippinAdressRepository.getById(id);
      entity.setAdressPurpose(shippingAdressRequestDto.getAdressPurpose());
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
            CustomerEntity customer = (CustomerEntity) userDetails;
            ShippingAdressEntity shippingAdressEntity = shippingAdressMapper.fromDto(shippingAdressRequestDto);
            shippingAdressEntity.setCustomerEntity(customer);
            shippinAdressRepository.save(shippingAdressEntity);
        }
    }
}
