package com.example.TomatoBackEnd.Service;

import com.example.TomatoBackEnd.DTO.ResponseDto.FoodResponseDto;
import com.example.TomatoBackEnd.Transformer.FoodsToFoodResponse;
import com.example.TomatoBackEnd.Module.Foods;
import com.example.TomatoBackEnd.Repository.FoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodsService {

    @Autowired
    FoodsRepository foodsRepository;

    public FoodResponseDto getFood(int itemID){

        Foods foods=foodsRepository.findById(itemID).get();
        FoodResponseDto foodResponseDto=new FoodResponseDto();

        return FoodsToFoodResponse.foodToResponse(foods);


    }

    public List<FoodResponseDto> getFoods(){

        List<Foods> foodsList=foodsRepository.findAll();

        List<FoodResponseDto> foodResponseDtoList=new ArrayList<>();
        for(Foods foods:foodsList){
            FoodResponseDto foodResponseDto=FoodsToFoodResponse.foodToResponse(foods);
            foodResponseDtoList.add(foodResponseDto);
        }

        return foodResponseDtoList;

    }
}
