package com.example.TomatoBackEnd.DTO.ResponseDto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartResponseDto {

    int productId;
    String photoUrl;
    String categoryName;
    int quantity;
}
