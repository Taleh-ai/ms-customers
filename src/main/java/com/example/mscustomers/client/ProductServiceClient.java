package com.example.mscustomers.client;

import com.example.mscustomers.dto.response.ProductResponseDto;

import com.example.mscustomers.exception.handler.SuccessDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "msdealer", url = "http://localhost:8081")
public interface ProductServiceClient {

    @GetMapping("/v1/product-feign/{id}")
    ResponseEntity<SuccessDetails<ProductResponseDto>> getProductById(@PathVariable("id") Long id);

    @GetMapping("/v1/product-feign")
    ResponseEntity<SuccessDetails<List<ProductResponseDto>>> getAllProducts();

    @PutMapping("/v1/product-feign/{id}/stock")
    ResponseEntity<SuccessDetails<String>> updateProductStock(@PathVariable("id") Long id,
                                                              @RequestParam("quantity") int quantity);

    @GetMapping("/v1/product-feign/{id}/price")
    ResponseEntity<SuccessDetails<Double>> getProductPriceById(@PathVariable("id") Long id);
}