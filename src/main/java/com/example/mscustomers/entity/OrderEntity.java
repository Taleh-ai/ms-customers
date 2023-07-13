package com.example.mscustomers.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="customer_id")
    private CustomerEntity userEntity;
    private int quantity;
    private double totalPrice;
    private LocalDate orderDate;
    private LocalDate deliveredDate;
    private LocalDate cancelDate;
    private LocalDate shippingDate;
    private String description;
    private Long productId;
    private String status;
}
