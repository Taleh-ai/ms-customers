package com.example.mscustomers.repository;

import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.entity.ShippingAdressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippinAdressRepository extends JpaRepository<ShippingAdressEntity,Long> {
    List<ShippingAdressEntity> findAllByCustomerEntity(CustomerEntity customer);
}
