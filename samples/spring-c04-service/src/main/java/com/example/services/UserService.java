package com.example.services;

import com.example.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // CRUD
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByEmailAndPassword(String email, String password);
    List<User> findAll();
    List<User> findAllByActiveTrue();
    List<User> findAllByAuthoritiesContains(String authority);
    User save(User user);
    User update(User user);
    void deleteById(Long id);


    // LÓGICA DE NEGOCIO
    boolean changePassword(Long userId, String currentPassword, String newPassword);
    User signUp(User user);
    boolean disableAccountByLastLogin();
    boolean hasWriteAuthority(Long userId);

    // Necesario servidor SMTP para enviar correos:
    //boolean resetPassword();
    //boolean confirmEmail();
}
