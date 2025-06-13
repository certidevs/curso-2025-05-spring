package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entities.Food;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByCategory(String category);
    List<Food> findAllByColor(String color);
    List<Food> findAllByCategoryAndColor(String category, String color);

    // findAllByMarketName(String name)
    // findAllByManufacturerName(String name)
}
