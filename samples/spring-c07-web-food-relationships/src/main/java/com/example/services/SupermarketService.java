package com.example.services;

import com.example.entities.Supermarket;

import java.util.List;
import java.util.Optional;

public interface SupermarketService {
    List<Supermarket> findAll();
    Optional<Supermarket> findById(Long id);
    Optional<Supermarket> findByIdWithAddresses(Long id);
    Supermarket save(Supermarket supermarket);
    void deleteById(Long id);
}
