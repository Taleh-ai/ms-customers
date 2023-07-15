package com.example.mscustomers.entity;


import com.example.mscustomers.dto.enumeration.OrderStatus;

import javax.persistence.*;
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
    @Column(name = "total_price")
    private double totalPrice;
    
    @Column(name = "order_date")
    private LocalDate orderDate;
    @Column(name = "delivered_date")
    private LocalDate deliveredDate;
    @Column(name = "cancel_date")
    private LocalDate cancelDate;
    @Column(name = "shipping_date")
    private LocalDate shippingDate;
    private String description;
    @Column(name = "product_id")
    private Long productId;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus status;
}
