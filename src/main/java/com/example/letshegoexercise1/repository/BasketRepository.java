package com.example.letshegoexercise1.repository;

import com.example.letshegoexercise1.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {
    Basket findBasketByID(Integer id);
}

