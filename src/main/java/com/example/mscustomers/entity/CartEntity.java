package com.example.mscustomers.entity;


import javax.persistence.*;

@Entity
public class CartEntity {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private CustomerEntity userEntity;
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_quantity")
    int productQuantity;
    @Column(name = "total_price")
    int totalPrice;
}
