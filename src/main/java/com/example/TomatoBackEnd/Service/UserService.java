package com.example.TomatoBackEnd.Service;

import com.example.TomatoBackEnd.DTO.RequestDto.UserRequestDto;
import com.example.TomatoBackEnd.DTO.ResponseDto.UserResponseDto;
import com.example.TomatoBackEnd.Module.Cart;
import com.example.TomatoBackEnd.Module.User;
import com.example.TomatoBackEnd.Repository.UserRepository;
import com.example.TomatoBackEnd.Transformer.UserDtoToUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(UserRequestDto userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

        User user= UserDtoToUser.userRequestToUser(userInfo);
        Cart cart=new Cart();
        cart.setUser(user);
        cart.setTotalValue(0);

        user.setCart(cart);

        userRepository.save(user);;

    }

    public UserResponseDto getUser(String username){
        User user=userRepository.findByUsername(username).get();
        UserResponseDto userResponseDto=new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setUsername(user.getUsername());
        return userResponseDto;
    }

    public User getUserId(int id){
        return userRepository.findById(id).get();
    }
}
