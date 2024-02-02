package com.example.TomatoBackEnd.DTO.RequestDto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequestDto {

    String username;
    int foodId;
    int quantity;

}
