package com.example.mscustomers.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shipping_addresses")
@Builder
public class ShippingAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String country;
    private String city;
    private String street;
    private int homeNo;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private CustomerEntity customerEntity;

    private String addressPurpose;
}