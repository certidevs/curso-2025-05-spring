package com.example.services;

import com.example.dto.FoodStats;
import com.example.entities.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {

    // crud
    List<Food> findAll();
    Optional<Food> findById(Long id);
    List<Food> findAllByCategory(String category);
    List<Food> findAllByColor(String color);
    List<Food> findAllByCategoryAndColor(String category, String color);
    List<Food> findAllBySupermarketId(Long id);
    Food save(Food food);
    void deleteById(Long id);
    void deleteAllById(List<Long> ids);
    void saveAll(List<Food> foods);

    // lógica de negocio
    FoodStats calculateStatsBySupermarketId(Long id);
}
