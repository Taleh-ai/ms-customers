package com.example.mscustomers.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomerEntity userEntity;
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_quantity")
    int productQuantity;
    @Column(name = "total_price")
    int totalPrice;
}
