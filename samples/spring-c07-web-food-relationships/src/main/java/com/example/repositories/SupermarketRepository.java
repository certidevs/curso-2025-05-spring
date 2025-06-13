package com.example.repositories;

import com.example.entities.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SupermarketRepository extends JpaRepository<Supermarket, Long> {

    // Consulta Jakarta Persistence Query Language (JPQL) personalizada para recuperar entidades address asociadas
    @Query("select supermarket from Supermarket supermarket left join fetch supermarket.addresses where supermarket.id = :id")
    Optional<Supermarket> findByIdWithAddresses(Long id);
}