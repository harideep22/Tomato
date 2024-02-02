package com.example.TomatoBackEnd.Repository;

import com.example.TomatoBackEnd.Module.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered,Integer> {


}
