package com.example.services;

import com.example.entities.User;
import com.example.exception.EntityDeleteException;
import com.example.exception.EntitySavingException;
import com.example.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// CON LOMBOK
@Slf4j // Agrega el campo log
@AllArgsConstructor // Agrega constructor con todos los parámetros
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    @Override
    public Optional<User> findById(Long id) {
        log.info("findById {}", id);
        if (id == null || id <= 0)
            return Optional.empty();

        return userRepo.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        log.info("findByUsername {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        log.info("findByEmail {}", email);
        return userRepo.findByEmail(email);
    }

    @Override
    public boolean existsByEmailAndPassword(String email, String password) {
        log.info("findByEmail email {} and password {}", email, password);
        return userRepo.existsByEmailAndPassword(email, password);
    }

    @Override
    public List<User> findAll() {
        log.info("findAll");
        return userRepo.findAll();
    }

    @Override
    public List<User> findAllByActiveTrue() {
        log.info("findAllByActiveTrue");
        return userRepo.findAllByActiveTrue();
    }

    @Override
    public List<User> findAllByAuthoritiesContains(String authority) {
//        if(authority == null || authority.length() == 0)
        if(!StringUtils.hasLength(authority))
            return new ArrayList<>();

        return userRepo.findAllByAuthoritiesContains(authority);
    }

    @Override
    public User save(User user) {
        if(user == null)
            throw new IllegalArgumentException("Usuario no puede ser null");

        if(user.getId() != null)
            update(user);

        try {
            return userRepo.save(user);
        } catch (Exception e) {
            log.error("Error guardando usuario", e);
        }

        throw new EntitySavingException("Error guardando usuario");
    }

    @Override
    public User update(User user) {
        if(user == null)
            throw new IllegalArgumentException("Usuario no puede ser null");

        if(user.getId() == null)
            throw new IllegalArgumentException("Usuario ID no puede ser null");

        if(!userRepo.existsById(user.getId()))
            throw new EntityNotFoundException("Usuario no existe");

        User userFromDB = userRepo.findById(user.getId()).get();
        // solo cambiamos los atributos deseados
        userFromDB.setUsername(user.getUsername());
        userFromDB.setLastLogin(user.getLastLogin());
        userFromDB.setActive(user.getActive());

        try {
            return userRepo.save(userFromDB);
        } catch (Exception e) {
            log.error("Error guardando usuario", e);
        }

        throw new EntitySavingException("Error guardando usuario");

    }

    @Override
    public void deleteById(Long id) {
        log.info("deleteById {}", id);

        try {
            userRepo.deleteById(id);
        } catch (Exception e) {
            log.error("Error al borrar", e);
        }
        throw new EntityDeleteException("Error borrando usuario");
    }

    @Override
    public boolean changePassword(Long userId, String currentPassword, String newPassword) {
        if(userId == null || userId <= 0 ||
            !StringUtils.hasLength(currentPassword) || !StringUtils.hasLength(newPassword))
            throw new IllegalArgumentException("Parámetros incorrectos");

        if(!userRepo.existsById(userId))
            throw new EntityNotFoundException("Usuario no existe");

        User userFromDB = userRepo.findById(userId).get();
        if(!userFromDB.getPassword().equals(currentPassword))
            return false;

        userFromDB.setPassword(newPassword);
        userRepo.save(userFromDB);
        return true;
    }

    @Override
    public User signUp(User user) {
        return null;
    }

    @Override
    public boolean disableAccountByLastLogin() {
        return false;
    }

    @Override
    public boolean hasWriteAuthority(Long userId) {
        return false;
    }
}
