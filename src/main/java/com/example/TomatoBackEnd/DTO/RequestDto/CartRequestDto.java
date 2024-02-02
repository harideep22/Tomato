package com.example.TomatoBackEnd.DTO.RequestDto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartRequestDto {

    String username;
    int quantity;
    int foodsId;

}
