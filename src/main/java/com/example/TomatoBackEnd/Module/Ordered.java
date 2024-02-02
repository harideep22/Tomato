package com.example.TomatoBackEnd.Module;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ordered")
@Data
public class Ordered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String orderNo;

    int totalPrice;

    @ManyToOne
    @JoinColumn
    User user;

    @CreationTimestamp
    Date orderDate;

    @OneToMany(mappedBy = "ordered", cascade = CascadeType.ALL)
    List<Item> itemList=new ArrayList<>();
}
