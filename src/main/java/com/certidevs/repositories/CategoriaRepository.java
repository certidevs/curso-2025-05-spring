package com.certidevs.repositories;

import com.certidevs.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}