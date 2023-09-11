package com.example.mscustomers.entity;


import com.example.mscustomers.dto.enumeration.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    private int quantity;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_date")
    @CreationTimestamp
    private LocalDate orderDate;

    @Column(name = "delivered_date")
    private LocalDate deliveredDate;

    @Column(name = "cancel_date")
    private LocalDate cancelDate;

    @Column(name = "shipping_date")
    private LocalDate shippingDate;

    @Column(name = "product_id")
    private Long productId;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private ShippingAddressEntity shippingAddress;
}
