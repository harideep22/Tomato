package com.example.TomatoBackEnd.Module;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foods")
@Data
public class Foods {

    int restaurantID;
    float price;
    String menuItemName;

    @Id
    int itemID;
    String description;
    String restaurantName;
    boolean availability;
    String photoUrl;
    String categoryName;

    @OneToMany(mappedBy = "foods",cascade = CascadeType.ALL)
    List<Item> items=new ArrayList<>();

}
