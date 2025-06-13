package com.example.services;

import com.example.entities.Supermarket;

import java.util.List;
import java.util.Optional;

public interface SupermarketService {
    List<Supermarket> findAll();
    Optional<Supermarket> findById(Long id);
    Optional<Supermarket> findByIdWithAddresses(Long id);
    List<Supermarket> findAllByAddressesId(Long id);
    Supermarket save(Supermarket supermarket);
    List<Supermarket> saveAll(List<Supermarket> supermarkets);
    void deleteById(Long id);

    // lógica de negocio
    double calculateM2ById(Long id);
}
