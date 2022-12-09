package com.example.bonchfood;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<Dishes, Integer> {
}
