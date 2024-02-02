package com.example.TomatoBackEnd.Controller;

import com.example.TomatoBackEnd.DTO.RequestDto.CartRequestDto;
import com.example.TomatoBackEnd.DTO.ResponseDto.CartResponseDto;
import com.example.TomatoBackEnd.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @PostMapping("/add")
    public void addToCart(@RequestBody CartRequestDto cartRequestDto){
        cartService.addToCart(cartRequestDto);
    }

    @GetMapping("/getAll/{username}")
    public List<CartResponseDto> showCart(@PathVariable ("username") String username){
        return cartService.showCart(username);
    }

}
