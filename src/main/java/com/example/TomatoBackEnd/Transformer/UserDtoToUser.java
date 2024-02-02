package com.example.TomatoBackEnd.Transformer;

import com.example.TomatoBackEnd.DTO.RequestDto.UserRequestDto;
import com.example.TomatoBackEnd.Module.User;

public class UserDtoToUser {

    public static User userRequestToUser(UserRequestDto userRequestDto){
        User user=new User();
        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setRoles(userRequestDto.getRoles());
        user.setPassword(userRequestDto.getPassword());

        return user;

    }
}
