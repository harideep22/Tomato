package com.example.TomatoBackEnd.Repository;

import com.example.TomatoBackEnd.Module.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
}
