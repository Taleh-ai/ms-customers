package com.example.mscustomers.repository;

import com.example.mscustomers.entity.CustomerEntity;
import com.example.mscustomers.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface OrderRepository extends JpaRepository<OrderEntity, Long> {
 List<OrderEntity> getOrderEntitiesByCustomerEntity(CustomerEntity customerEntity);
}
