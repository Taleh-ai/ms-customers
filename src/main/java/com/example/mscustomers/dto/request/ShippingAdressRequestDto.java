package com.example.mscustomers.dto.request;

import lombok.Data;

@Data
public class ShippingAdressRequestDto {
    private Long addressId;
    private String country;
    private String city;
    private String street;
    private int homeNo;
    private String adressPurpose;
}
