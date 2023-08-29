package com.example.mscustomers.controller;

import com.example.mscustomers.dto.request.CartRequestDto;
import com.example.mscustomers.dto.response.CartResponseDto;
import com.example.mscustomers.exception.ResourceNotFoundException;
import com.example.mscustomers.exception.handler.SuccessDetails;
import com.example.mscustomers.service.impl.CartServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/cart")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class CartController {
private final CartServiceImpl cartService;
    @PutMapping("{id}")
    public ResponseEntity<SuccessDetails<String>> updateCart(@PathVariable(name = "id") Long id, @RequestParam int productCount) throws ResourceNotFoundException {
        cartService.updateCart(id,productCount);
        return ResponseEntity.ok(new SuccessDetails<>("Cart updated Successfully!", HttpStatus.OK.value(),true));
    }

    @PostMapping
    public ResponseEntity<SuccessDetails<String>> addCart( @RequestBody CartRequestDto cartRequestDto){
        cartService.createCart(cartRequestDto);
        return ResponseEntity.ok(new SuccessDetails<>("Product added to Cart updated Successfully!", HttpStatus.OK.value(),true));
    }

    @GetMapping
    public ResponseEntity<SuccessDetails<List<CartResponseDto>>> viewCart(){
        return ResponseEntity.ok(new SuccessDetails<>(cartService.viewAllCart(), HttpStatus.OK.value(),true));
    }

}
