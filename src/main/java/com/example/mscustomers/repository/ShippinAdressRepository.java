package com.example.mscustomers.repository;

import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.entity.ShippingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippinAdressRepository extends JpaRepository<ShippingAddressEntity,Long> {
    List<ShippingAddressEntity> findAllByCustomerEntity(CustomerEntity customer);
}
