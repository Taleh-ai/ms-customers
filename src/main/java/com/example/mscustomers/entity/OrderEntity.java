package com.example.mscustomers.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity userEntity;

    // List of Product entities

    private double totalPrice;
    private LocalDate orderDate;
    private String status;

    // Constructors, getters, and setters
}
