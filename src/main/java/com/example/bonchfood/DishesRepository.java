package com.example.bonchfood;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DishesRepository extends JpaRepository<Dishes, Integer> {
}
