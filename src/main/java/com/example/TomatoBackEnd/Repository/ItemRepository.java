package com.example.TomatoBackEnd.Repository;

import com.example.TomatoBackEnd.Module.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
