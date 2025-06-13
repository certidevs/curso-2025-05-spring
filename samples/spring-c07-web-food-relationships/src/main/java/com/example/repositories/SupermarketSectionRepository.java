package com.example.repositories;

import com.example.entities.SupermarketSection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupermarketSectionRepository extends JpaRepository<SupermarketSection, Long> {
    List<SupermarketSection> findAllBySupermarketId(Long id);
}