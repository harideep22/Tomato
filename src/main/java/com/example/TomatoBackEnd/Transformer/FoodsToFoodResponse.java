package com.example.TomatoBackEnd.Transformer;

import com.example.TomatoBackEnd.DTO.ResponseDto.FoodResponseDto;
import com.example.TomatoBackEnd.Module.Foods;

public class FoodsToFoodResponse {

    public static FoodResponseDto foodToResponse(Foods foods){

        FoodResponseDto foodResponseDto=new FoodResponseDto();

        foodResponseDto.setAvailability(true);
        foodResponseDto.setDescription(foods.getDescription());
        foodResponseDto.setPrice(foods.getPrice());
        foodResponseDto.setItemID(foods.getItemID());
        foodResponseDto.setCategoryName(foods.getCategoryName());
        foodResponseDto.setPhotoUrl(foods.getPhotoUrl());
        foodResponseDto.setRestaurantID(foods.getRestaurantID());
        foodResponseDto.setMenuItemName(foods.getMenuItemName());
        foodResponseDto.setRestaurantName(foods.getRestaurantName());

        return foodResponseDto;
    }

}
