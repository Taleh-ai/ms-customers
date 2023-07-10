package com.example.mscustomers.entity;

import jakarta.persistence.*;

@Entity
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private CustomerEntity userEntity;

    int orderQuantity;
}