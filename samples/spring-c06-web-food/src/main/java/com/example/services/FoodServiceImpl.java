package com.example.services;

import com.example.entities.Food;
import com.example.repositories.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Food> findById(Long id) {
        return foodRepository.findById(id);
    }

    @Override
    public List<Food> findAllByCategory(String category) {
        return foodRepository.findAllByCategory(category);
    }

    @Override
    public List<Food> findAllByColor(String color) {
        return foodRepository.findAllByColor(color);
    }

    @Override
    public List<Food> findAllByCategoryAndColor(String category, String color) {
        return foodRepository.findAllByCategoryAndColor(category, color);
    }

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public void deleteById(Long id) {
        foodRepository.deleteById(id);
    }
}
