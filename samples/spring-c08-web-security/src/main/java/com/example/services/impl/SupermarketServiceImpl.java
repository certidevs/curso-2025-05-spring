package com.example.services.impl;

import com.example.entities.Food;
import com.example.entities.Supermarket;
import com.example.entities.SupermarketSection;
import com.example.repositories.SupermarketRepository;
import com.example.services.FoodService;
import com.example.services.SupermarketSectionService;
import com.example.services.SupermarketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SupermarketServiceImpl implements SupermarketService {

    private final SupermarketRepository supermarketRepository;
    private final SupermarketSectionService sectionService;
    private final FoodService foodService;

    @Override
    public List<Supermarket> findAll() {
        return supermarketRepository.findAll();
    }

    @Override
    public Optional<Supermarket> findById(Long id) {
        return supermarketRepository.findById(id);
    }

    @Override
    public Optional<Supermarket> findByIdWithAddresses(Long id) {
        return supermarketRepository.findByIdWithAddresses(id);
    }

    @Override
    public List<Supermarket> findAllByAddressesId(Long id) {
        return supermarketRepository.findAllByAddressesId(id);
    }

    @Override
    public Supermarket save(Supermarket supermarket) {
        return supermarketRepository.save(supermarket);
    }

    @Override
    public List<Supermarket> saveAll(List<Supermarket> supermarkets) {
        return supermarketRepository.saveAll(supermarkets);
    }

    @Override
    public void deleteById(Long id) {
        // Opción 1: desasociar supermarket de foods (no se borran)
        List<Food> foods = foodService.findAllBySupermarketId(id);
        for (Food food : foods) {
            food.setSupermarket(null);
        }
        foodService.saveAll(foods);
        List<SupermarketSection> sections = sectionService.findAllBySupermarketId(id);
        for (var section : sections) {
            section.setSupermarket(null);
        }
        sectionService.saveAll(sections);
        // Opción 2: borrar los foods asociados
//        List<Food> foods = foodService.findAllBySupermarketId(id);
//        List<Long> ids = new ArrayList<>();
//        for (Food food: foods)
//            ids.add(food.getId());
//
//        foodService.deleteAllById(ids);

        // borrar supermarket
        supermarketRepository.deleteById(id);
    }

    @Override
    public double calculateM2ById(Long id) {
        List<SupermarketSection> sections = sectionService.findAllBySupermarketId(id);
        double m2 = 0d;
        for (SupermarketSection section : sections) {
            // if(section.getM2() != null)
                m2 += section.getM2();
        }
        return m2;
    }
}
