package com.example.mscustomers.controller;

import com.example.mscustomers.dto.request.ShippingAdressRequestDto;
import com.example.mscustomers.dto.response.ShippingAdressResponseDto;
import com.example.mscustomers.exception.handler.SuccessDetails;
import com.example.mscustomers.service.impl.ShippingAdressServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/shipping")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class ShippingAdressController {
    private final ShippingAdressServiceImpl shippingAdressService;

    @PostMapping
    public ResponseEntity<SuccessDetails<String>> addAdress(@RequestBody ShippingAdressRequestDto shippingAdressRequestDto){
        shippingAdressService.addAdress(shippingAdressRequestDto);
        return ResponseEntity.ok(new SuccessDetails<>("Shipping address added Successfully!", HttpStatus.OK.value(),true));
    }
    @PutMapping
    public ResponseEntity<SuccessDetails<String>> updateAdress(@PathVariable Long id,@RequestBody ShippingAdressRequestDto shippingAdressRequestDto){
        shippingAdressService.updateAdress(id,shippingAdressRequestDto);
        return ResponseEntity.ok(new SuccessDetails<>("Shipping address updated Successfully!", HttpStatus.OK.value(),true));
    }
    @GetMapping
    public ResponseEntity<SuccessDetails<List<ShippingAdressResponseDto>>> getUserAdresses(){
        return ResponseEntity.ok(new SuccessDetails<>(shippingAdressService.getUserAdresses(), HttpStatus.OK.value(),true));

    }

    @GetMapping ("{id}")
    public  ResponseEntity<SuccessDetails<ShippingAdressResponseDto>>  getUserAdress(@PathVariable Long id){
        return ResponseEntity.ok(new SuccessDetails<>(shippingAdressService.getUserAdress(id), HttpStatus.OK.value(),true));
    }
}
