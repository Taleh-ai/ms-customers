package com.example.mscustomers.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserCredentialsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    String email;
    String password;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private CustomerEntity customer;
}
