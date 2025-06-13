package com.example.services.impl;

import com.example.entities.SupermarketSection;
import com.example.repositories.SupermarketRepository;
import com.example.services.FoodService;
import com.example.services.SupermarketSectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SupermarketServiceImplTest {

    // sut - System Under Test
    SupermarketServiceImpl supermarketService;
    // dependencias (mocks)
    SupermarketRepository supermarketRepo;
    SupermarketSectionService sectionService;
    FoodService foodService;

    @BeforeEach
    void setUp() {
        supermarketRepo = mock(SupermarketRepository.class);
        sectionService = mock(SupermarketSectionService.class);
        foodService = mock(FoodService.class);

        supermarketService = new SupermarketServiceImpl(supermarketRepo, sectionService, foodService);
    }


    @Test
    @DisplayName("Calcular metros cuadrados de supermercado sumando los m2 de cada sección")
    void calculateM2ByIdTest() {

        // configurar mocks
        var section1 = new SupermarketSection(1L, "Carnicería", true, 30, null);
        var section2 = new SupermarketSection(2L, "Pescadería", true, 30, null);
        var section3 = new SupermarketSection(3L, "Bollería", true, 40, null);
        var section4 = new SupermarketSection(3L, "Bollería", true, null, null);
        List<SupermarketSection> sections = new ArrayList<>(List.of(section1, section2, section3, section4));
        when(
                sectionService.findAllBySupermarketId(1L)
        ).thenReturn(sections);

        // ejecuta método a testear
        double m2 = supermarketService.calculateM2ById(1L);

        // comprobaciones
        assertEquals(100d, m2);
        verify(sectionService).findAllBySupermarketId(1L);
    }
}