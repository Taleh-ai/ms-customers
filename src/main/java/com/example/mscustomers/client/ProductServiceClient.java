package com.example.mscustomers.client;

import com.example.mscustomers.dto.response.ProductResponseDto;

import com.example.mscustomers.exception.handler.SuccessDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "msdealer", url = "http://localhost:8081/v1/product-feign")
public interface ProductServiceClient {

    @GetMapping("/{id}")
    ResponseEntity<SuccessDetails<ProductResponseDto>> getProductById(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<SuccessDetails<List<ProductResponseDto>>> getAllProducts();

    @PutMapping("/stock/{id}")
    ResponseEntity<SuccessDetails<String>> updateProductStock(@PathVariable("id") Long id,
                                                              @RequestParam("quantity") int quantity);

    @GetMapping("/price/{id}")
    ResponseEntity<SuccessDetails<Double>> getProductPriceById(@PathVariable("id") Long id);
}