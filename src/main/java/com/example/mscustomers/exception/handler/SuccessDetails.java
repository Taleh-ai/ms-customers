package com.example.mscustomers.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class SuccessDetails<T> {
   private T data;

   private int statusCode;

   boolean isSuccess;

}
