package com.example.mscustomers.entity;

import jakarta.persistence.*;

@Entity
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define the relationship between OrderItem and Order entities
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cartEntity;

    // Define the relationship between OrderItem and Product entities
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductsEntity product;


}
