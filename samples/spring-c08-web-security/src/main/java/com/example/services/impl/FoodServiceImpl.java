package com.example.services.impl;

import com.example.dto.FoodStats;
import com.example.entities.Food;
import com.example.repositories.FoodRepository;
import com.example.services.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<Food> findAllBySupermarketId(Long id) {
        return foodRepository.findAllBySupermarketId(id);
    }

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public void deleteById(Long id) {
        foodRepository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        foodRepository.deleteAllById(ids);
    }

    @Override
    public void saveAll(List<Food> foods) {
        foodRepository.saveAll(foods);
    }

    @Override
    public FoodStats calculateStatsBySupermarketId(Long id) {
        List<Food> foods = foodRepository.findAllBySupermarketId(id);

        double maxPrice = 0d;
        for (Food food : foods)
            if (isValidFood(food) && food.getPrice() > maxPrice)
                maxPrice = food.getPrice();

        double minPrice = maxPrice;
        for (Food food : foods)
            if (isValidFood(food) && food.getPrice() < minPrice)
                minPrice = food.getPrice();

        int countFood = 0;
        double sumPrice = 0d;
        for (Food food : foods) {
            if (isValidFood(food)) {
                countFood += food.getQuantity();
                sumPrice += food.getPrice() * food.getQuantity();
            }
        }

        double meanPrice = 0d;

        if (sumPrice > 0 && countFood > 0) {
            meanPrice = sumPrice / countFood;
            meanPrice = Math.round(meanPrice * 100.0) / 100.0;
        }
        return new FoodStats(minPrice, maxPrice, meanPrice, countFood);
    }

    private boolean isValidFood(Food food) {
        return food.getAvailable() // sí disponible
                && food.getExpireDate().isAfter(LocalDate.now()) // no está caducado
                && food.getPrice() != null;
    }
}
