package com.example.mscustomers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class ProductsEntity {
    @Id
    Long id;
    String name;
    String model;
    String manufacturer;
    String color;

    BigDecimal count;
    Long price;

}
