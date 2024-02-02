package com.example.TomatoBackEnd.Transformer;

import com.example.TomatoBackEnd.DTO.ResponseDto.OrderResponseDto;
import com.example.TomatoBackEnd.Module.Foods;
import com.example.TomatoBackEnd.Module.Item;
import com.example.TomatoBackEnd.Module.Ordered;

import java.util.ArrayList;
import java.util.List;

public class OrderedToResponse {

    public static List<OrderResponseDto> OrderedResponseTransformer(List<Ordered> orderedList){
        List<OrderResponseDto> orderResponseDtoList=new ArrayList<>();



        for (Ordered ordered: orderedList){

            List<Item> itemList=ordered.getItemList();

            for (Item item:itemList){

                int quantity=item.getRequiredQuantity();
                Foods foods=item.getFoods();



                OrderResponseDto orderResponseDto=new OrderResponseDto();

                orderResponseDto.setItemID(foods.getItemID());
                orderResponseDto.setDescription(foods.getDescription());
                orderResponseDto.setPrice(foods.getPrice());
                orderResponseDto.setPhotoUrl(foods.getPhotoUrl());
                orderResponseDto.setMenuItemName(foods.getMenuItemName());
                orderResponseDto.setCategoryName(foods.getCategoryName());
                orderResponseDto.setRestaurantID(foods.getRestaurantID());
                orderResponseDto.setRestaurantName(foods.getRestaurantName());
                orderResponseDto.setQuantity(quantity);

                orderResponseDto.setTotalPrice((int) (orderResponseDto.getTotalPrice()+(orderResponseDto.getQuantity())*orderResponseDto.getPrice()));

                orderResponseDtoList.add(orderResponseDto);
            }

        }

        return orderResponseDtoList;
    }

    public static OrderResponseDto itemToOrderedResponse(Item item){
        int quantity=item.getRequiredQuantity();
        Foods foods=item.getFoods();

        OrderResponseDto orderResponseDto=new OrderResponseDto();

        orderResponseDto.setItemID(foods.getItemID());
        orderResponseDto.setDescription(foods.getDescription());
        orderResponseDto.setPrice(foods.getPrice());
        orderResponseDto.setPhotoUrl(foods.getPhotoUrl());
        orderResponseDto.setMenuItemName(foods.getMenuItemName());
        orderResponseDto.setCategoryName(foods.getCategoryName());
        orderResponseDto.setRestaurantID(foods.getRestaurantID());
        orderResponseDto.setRestaurantName(foods.getRestaurantName());
        orderResponseDto.setQuantity(quantity);

        return orderResponseDto;
    }
}
