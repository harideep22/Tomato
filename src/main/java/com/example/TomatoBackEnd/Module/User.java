package com.example.TomatoBackEnd.Module;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.query.Order;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private String roles;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Ordered> orderedList=new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Cart cart;



}
