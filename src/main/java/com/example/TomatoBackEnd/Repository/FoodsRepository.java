package com.example.TomatoBackEnd.Repository;

import com.example.TomatoBackEnd.Module.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodsRepository extends JpaRepository<Foods,Integer> {
}
