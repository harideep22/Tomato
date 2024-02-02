package com.example.TomatoBackEnd.Controller;

import com.example.TomatoBackEnd.DTO.RequestDto.AuthRequestDto;
import com.example.TomatoBackEnd.DTO.RequestDto.UserRequestDto;
import com.example.TomatoBackEnd.DTO.ResponseDto.UserResponseDto;
import com.example.TomatoBackEnd.Module.User;
import com.example.TomatoBackEnd.Service.JwtService;
import com.example.TomatoBackEnd.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/add")
    public void addUser(@RequestBody UserRequestDto userRequestDto){
        userService.addUser(userRequestDto);
    }

    @GetMapping("/get/{username}")
    public UserResponseDto getUser(@PathVariable ("username") String username){

        return userService.getUser(username);
    }

    @GetMapping("/gett/{id}")
    public User getUserById(@PathVariable ("id") int id){
        return userService.getUserId(id);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequestDto authRequestDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequestDto.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
