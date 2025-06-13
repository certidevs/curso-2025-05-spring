package com.example.services;

import com.example.entities.Beer;

import java.util.List;
import java.util.Optional;

public interface BeerService {

    // CRUD
    List<Beer> findAll();
    Optional<Beer> findById(Long id);

    // Lógica de negocio
}
