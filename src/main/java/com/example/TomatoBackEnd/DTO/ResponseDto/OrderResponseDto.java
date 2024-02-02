package com.example.TomatoBackEnd.DTO.ResponseDto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponseDto {

    int restaurantID;
    float price;
    String menuItemName;
    int itemID;
    String description;
    String restaurantName;
    String photoUrl;
    String categoryName;
    int quantity;
    int totalPrice;
}
