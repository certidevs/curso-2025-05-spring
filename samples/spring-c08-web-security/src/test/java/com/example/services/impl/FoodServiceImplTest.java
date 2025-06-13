package com.example.services.impl;

import com.example.dto.FoodStats;
import com.example.entities.Food;
import com.example.repositories.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FoodServiceImplTest {

    // sut
    FoodServiceImpl foodService;
    // dependencias
    FoodRepository foodRepository;

    @BeforeEach
    void setUp() {
        foodRepository = mock(FoodRepository.class);
        foodService = new FoodServiceImpl(foodRepository);
    }

    @Test
    @DisplayName("Calcular estadísticas de Foods de un supermercado concreto por su id")
    void calculateStatsBySupermarketId() {

        // 1. configurar mocks
        Food f1 = Food.builder().price(1.32).available(true).quantity(2).expireDate(LocalDate.now().plusDays(7)).build();
        Food f2 = Food.builder().price(2.0).available(true).quantity(5).expireDate(LocalDate.now().plusDays(7)).build();
        Food f3 = Food.builder().price(3.0).available(true).quantity(1).expireDate(LocalDate.now().minusDays(2)).build(); // caducado
        Food f4 = Food.builder().price(2.99).available(false).quantity(4).expireDate(LocalDate.now().plusDays(7)).build(); // no disponible
        Food f5 = Food.builder().price(78.99).available(true).quantity(9).expireDate(LocalDate.now().plusDays(7)).build();
        Food f6 = Food.builder().price(44.99).available(true).quantity(3).expireDate(LocalDate.now().plusDays(7)).build();
        List<Food> foods = new ArrayList<>(List.of(f1, f2, f3, f4, f5, f6));
        when(foodRepository.findAllBySupermarketId(1L)).thenReturn(foods);

        // ejecutar método a testear
        FoodStats stats = foodService.calculateStatsBySupermarketId(1L);

        // comprobaciones
        assertEquals(1.32, stats.minPrice());
        assertEquals(78.99, stats.maxPrice());
        assertEquals(45.19, stats.meanPrice());
        assertEquals(19, stats.count());
        verify(foodRepository).findAllBySupermarketId(1L);
    }

    @Test
    @DisplayName("Calcular estadísticas de Foods (Sin foods) de un supermercado concreto por su id")
    void calculateStatsNullBySupermarketId() {

        // 1. configurar mocks
        when(foodRepository.findAllBySupermarketId(1L)).thenReturn(List.of());

        // ejecutar método a testear
        FoodStats stats = foodService.calculateStatsBySupermarketId(1L);

        // comprobaciones
        assertEquals(0.0, stats.minPrice());
        assertEquals(0.0, stats.maxPrice());
        assertEquals(0.0, stats.meanPrice());
        assertEquals(0, stats.count());
        verify(foodRepository).findAllBySupermarketId(1L);
    }
}