package com.example.TomatoBackEnd.Controller;

import com.example.TomatoBackEnd.DTO.RequestDto.OrderRequestDto;
import com.example.TomatoBackEnd.DTO.ResponseDto.OrderResponseDto;
import com.example.TomatoBackEnd.Service.OrderedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderedController {

    @Autowired
    OrderedService orderedService;

    @PostMapping("/add")
    public void addOrder(@RequestBody OrderRequestDto orderRequestDto){
        orderedService.addOrder(orderRequestDto);
    }

    @PostMapping("/cart/{username}")
    public void placeCartOrder(@PathVariable ("username") String username) throws Exception {
        orderedService.placeCartOrder(username);

        orderedService.resetCart(username);
    }

    @GetMapping("/get/{username}")
    public List<OrderResponseDto> getOrders(@PathVariable ("username") String username){
        return orderedService.getOrders(username);
    }

}
