package com.example.mscustomers.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
  public class CustomerResponseDto {
    private Long CustomerId;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
}
