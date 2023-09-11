package com.example.mscustomers.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

    private List<Long> cardId;
    @NotEmpty(message = "Shipping address should not be empty!")
    private Long shippingAddressId;
}
