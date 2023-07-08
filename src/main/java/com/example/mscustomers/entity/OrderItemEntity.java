package com.example.mscustomers.entity;

import jakarta.persistence.*;

@Entity
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define the relationship between OrderItem and Order entities
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    // Define the relationship between OrderItem and Product entities
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductsEntity product;

    // Constructors, getters, and setters
}