package com.example.TomatoBackEnd.DTO.ResponseDto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodResponseDto {

    int restaurantID;
    float price;
    String menuItemName;
    int itemID;
    String description;
    String restaurantName;
    boolean availability;
    String photoUrl;
    String categoryName;
}
