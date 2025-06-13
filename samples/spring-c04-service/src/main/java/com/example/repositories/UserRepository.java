package com.example.repositories;

import com.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Buscar por nombre de usuario
    Optional<User> findByUsername(String username);

    // Buscar por email
    Optional<User> findByEmail(String email);

    // Comprobar si existe por email y password
    boolean existsByEmailAndPassword(String email, String password);

    // Buscar todos con Active a true
    List<User> findAllByActiveTrue();

    // Buscar todos con authority de escritura
    List<User> findAllByAuthoritiesContains(String authority);
}






