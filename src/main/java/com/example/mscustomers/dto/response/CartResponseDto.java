package com.example.mscustomers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
   private Long id;
   private int productQuantity;
   private double totalPrice;
   private Long productId;
}
