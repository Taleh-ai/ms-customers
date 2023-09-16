package com.example.mscustomers.controller;

import com.example.mscustomers.client.ProductServiceClient;
import com.example.mscustomers.dto.response.ProductResponseDto;
import com.example.mscustomers.exception.handler.SuccessDetails;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("v1/product")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class ProductController {
private final ProductServiceClient productServiceClient;
    @GetMapping("{id}")
    ResponseEntity<SuccessDetails<ProductResponseDto>> getProductById(@PathVariable("id") Long id){
      return   productServiceClient.getProductById(id);
    }

    @GetMapping
    ResponseEntity<SuccessDetails<List<ProductResponseDto>>> getAllProducts(){
      return   productServiceClient.getAllProducts();
    }
}
