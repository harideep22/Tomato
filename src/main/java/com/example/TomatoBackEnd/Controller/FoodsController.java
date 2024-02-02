package com.example.TomatoBackEnd.Controller;

import com.example.TomatoBackEnd.DTO.ResponseDto.FoodResponseDto;
import com.example.TomatoBackEnd.Module.Foods;
import com.example.TomatoBackEnd.Service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodsController {
    @Autowired
    FoodsService foodsService;

    @GetMapping("/get/{itemID}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public FoodResponseDto getFood(@PathVariable  int itemID){
        return foodsService.getFood(itemID);
    }

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<FoodResponseDto> getFoods(){
        return foodsService.getFoods();
    }


}
