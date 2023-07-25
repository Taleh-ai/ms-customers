package com.example.mscustomers.controller;

import com.example.mscustomers.dto.request.ShippingAdressRequestDto;
import com.example.mscustomers.dto.response.ShippingAdressResponseDto;
import com.example.mscustomers.service.impl.ShippingAdressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/")
@RequiredArgsConstructor
public class ShippingAdressController {
    private final ShippingAdressServiceImpl shippingAdressService;

    @PostMapping("shipping")
    public void addAdress(@RequestBody ShippingAdressRequestDto shippingAdressRequestDto){
        shippingAdressService.addAdress(shippingAdressRequestDto);
    }
    @PutMapping ("shipping")
    public void updateAdress(@PathVariable Long id,@RequestBody ShippingAdressRequestDto shippingAdressRequestDto){
        shippingAdressService.updateAdress(id,shippingAdressRequestDto);
    }
    @GetMapping ("shipping")
    public List<ShippingAdressResponseDto> getUserAdresses(){
      return   shippingAdressService.getUserAdresses();
    }

    @GetMapping ("shipping{id}")
    public ShippingAdressResponseDto getUserAdresses(@PathVariable Long id){
        return   shippingAdressService.getUserAdress(id);
    }
}
