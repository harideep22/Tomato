package com.example.TomatoBackEnd.Service;

import com.example.TomatoBackEnd.DTO.RequestDto.CartRequestDto;
import com.example.TomatoBackEnd.DTO.ResponseDto.CartResponseDto;
import com.example.TomatoBackEnd.Module.Cart;
import com.example.TomatoBackEnd.Module.Foods;
import com.example.TomatoBackEnd.Module.Item;
import com.example.TomatoBackEnd.Module.User;
import com.example.TomatoBackEnd.Repository.CartRepository;
import com.example.TomatoBackEnd.Repository.FoodsRepository;
import com.example.TomatoBackEnd.Repository.ItemRepository;
import com.example.TomatoBackEnd.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class CartService {
    @Autowired
    FoodsRepository foodsRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    public void addToCart(CartRequestDto cartRequestDto){
        Foods foods=foodsRepository.findById(cartRequestDto.getFoodsId()).get();
        Item item=new Item();

        item.setFoods(foods);
        item.setRequiredQuantity(cartRequestDto.getQuantity());
        foods.getItems().add(item);

        Item savedItem=itemRepository.save(item);
        User user=userRepository.findByUsername(cartRequestDto.getUsername()).get();
        Cart cart=user.getCart();


        int newTotal= (int) (cart.getTotalValue()+savedItem.getRequiredQuantity()*savedItem.getFoods().getPrice());
        cart.setTotalValue(newTotal);

        savedItem.setCart(cart);
        cartRepository.save(cart);
    }

    public List<CartResponseDto> showCart(String username){
        User user=userRepository.findByUsername(username).get();

        Cart cart=user.getCart();
        List<Item> cartItemList=cart.getItemList();

        HashMap<Integer,Integer> hm=new HashMap<>();
        for(Item item:cartItemList){
            int productId=item.getFoods().getItemID();
            int quantity=item.getRequiredQuantity();

            if(hm.containsKey(productId)){
                int tempQ=hm.get(productId);
                hm.put(productId,quantity+tempQ);
            }
            else{
                hm.put(productId,quantity);
            }
        }
        Set<Integer> keySet=hm.keySet();
        List<CartResponseDto> cartResponseDtoList=new ArrayList<>();
        for(int set:keySet){
            int productId=set;
            int quantity=hm.get(set);

            CartResponseDto cartResponseDto=new CartResponseDto();
            cartResponseDto.setProductId(productId);
            cartResponseDto.setQuantity(quantity);
            Foods foods=foodsRepository.findById(productId).get();
            cartResponseDto.setPhotoUrl(foods.getPhotoUrl());
            cartResponseDto.setCategoryName(foods.getCategoryName());

            cartResponseDtoList.add(cartResponseDto);
        }

        return cartResponseDtoList;
    }


}
