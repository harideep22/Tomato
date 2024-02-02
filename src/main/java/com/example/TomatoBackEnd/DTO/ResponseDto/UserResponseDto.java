package com.example.TomatoBackEnd.DTO.ResponseDto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {

    String username;
    String email;
}
