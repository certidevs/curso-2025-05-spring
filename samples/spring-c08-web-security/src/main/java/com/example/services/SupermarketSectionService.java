package com.example.services;

import com.example.entities.SupermarketSection;

import java.util.List;
import java.util.Optional;

public interface SupermarketSectionService {
    List<SupermarketSection> findAll();
    Optional<SupermarketSection> findById(Long id);
    List<SupermarketSection> findAllBySupermarketId(Long id);
    SupermarketSection save(SupermarketSection section);
    void deleteById(Long id);
    void deleteAllById(List<Long> ids);
    void saveAll(List<SupermarketSection> sections);
}
