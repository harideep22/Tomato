package com.example.TomatoBackEnd.Service;

import com.example.TomatoBackEnd.DTO.RequestDto.OrderRequestDto;
import com.example.TomatoBackEnd.DTO.ResponseDto.OrderResponseDto;
import com.example.TomatoBackEnd.Module.*;
import com.example.TomatoBackEnd.Repository.*;
import com.example.TomatoBackEnd.Transformer.OrderedToResponse;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderedService {
    @Autowired
    OrderedRepository orderedRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FoodsRepository foodsRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ItemRepository itemRepository;

    public void addOrder(OrderRequestDto orderRequestDto){
        Ordered ordered=new Ordered();
        User user=userRepository.findByUsername(orderRequestDto.getUsername()).get();
        ordered.setUser(user);
        user.getOrderedList().add(ordered);

        ordered.setOrderNo(String.valueOf(UUID.randomUUID()));

        Item item=new Item();

        item.setOrdered(ordered);
        item.setRequiredQuantity(orderRequestDto.getQuantity());

        Foods foods=foodsRepository.findById(orderRequestDto.getFoodId()).get();
        item.setFoods(foods);

        foods.getItems().add(item);
        List<Item> itemList=ordered.getItemList();
        itemList.add(item);

        ordered.setItemList(itemList);

        int value= (int) (orderRequestDto.getQuantity()*foods.getPrice());
        ordered.setTotalPrice(value);

        orderedRepository.save(ordered);
    }

    public void placeCartOrder(String username) throws Exception {
        User user=userRepository.findByUsername(username).get();

        Cart cart=user.getCart();

        if(cart.getItemList().size()==0){
            throw new Exception("Cart is Empty");
        }


        Ordered order=new Ordered();
        order.setOrderNo(String.valueOf(UUID.randomUUID()));
        order.setUser(user);
        List<Item> orderedItems=new ArrayList<>();

        for(Item item: cart.getItemList()){


            item.setOrdered(order);

            List<Item> itemList=order.getItemList();
            itemList.add(item);

            order.setItemList(itemList);

            int value= (int) (item.getRequiredQuantity()*item.getFoods().getPrice());
            order.setTotalPrice(value);

            orderedRepository.save(order);
        }

    }

    public void resetCart(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        Cart cart = user.getCart();
        // Remove items from the cart and update the associations
        for (Item item : cart.getItemList()) {
            item.setCart(null); // Break the association with the current cart
            itemRepository.save(item); // Save the item to update the association
        }

        // Clear the user's cart items
        cart.getItemList().clear();

        // Reset the total value
        cart.setTotalValue(0);

        // Save the cart to update the changes
        cartRepository.save(cart);
    }


    public List<OrderResponseDto> getOrders(String username){

        List<OrderResponseDto> orderResponseDtoList=new ArrayList<>();
        User user=userRepository.findByUsername(username).get();
        List<Ordered> orderedList=user.getOrderedList();


        return OrderedToResponse.OrderedResponseTransformer(orderedList);
    }



}
