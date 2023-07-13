package com.example.mscustomers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAdressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String country;
    private String city;
    private String street;
    private int homeNo;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomerEntity userEntity;
    private String adressPurpose;
}
