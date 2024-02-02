package com.example.TomatoBackEnd.Module;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    @JoinColumn
    User user;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    List<Item> itemList=new ArrayList<>();

    int totalValue;
}
