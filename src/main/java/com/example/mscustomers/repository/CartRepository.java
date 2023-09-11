package com.example.mscustomers.repository;

import com.example.mscustomers.entity.CartEntity;
import com.example.mscustomers.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository  extends JpaRepository<CartEntity,Long> {

    List<CartEntity> getCartEntitiesByCustomerEntity(CustomerEntity customerEntity);
    List<CartEntity> getCartEntitiesByCartIdIn(List<Long> id);

    void deleteCartEntitiesByCartIdIn(List<Long> ids);
}
