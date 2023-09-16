package com.example.mscustomers.service.impl;

import com.example.mscustomers.client.ProductServiceClient;
import com.example.mscustomers.dto.response.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp {

    private final ProductServiceClient productServiceClient;


    public List<ProductResponseDto> getAllProducts() {
     return productServiceClient.getAllProducts().getBody().getData();
    }


    public ProductResponseDto getProductById(Long id) {
        return productServiceClient.getProductById(id).getBody().getData();
    }

}
