package com.example.repositories;

import com.example.entities.User;
import com.example.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);

    List<User> findAllByUserType(UserType type);

    User findByEmail(String email);
    // comprobar si existe un usuario por su email, puede servir para saber si un email ya está ocupado en un registro de un nuevo usuario
    boolean existsByEmail(String email);
    // Optional<User> findByEmail(String email);

    List<User> findAllByEntryHour(LocalTime entryHour);
    List<User> findAllByEntryHourBefore(LocalTime entryHour);
    List<User> findAllByEntryHourAfter(LocalTime entryHour);

    List<User> findBySalaryGreaterThanEqual(Double salary);
    List<User> findBySalaryLessThanEqual(Double salary);
    List<User> findBySalaryBetween(Double salaryStart, Double salaryEnd);

    List<User> findAllByBirthDateAfter(LocalDate birthDate);
    List<User> findAllByBirthDateBefore(LocalDate birthDate);
    List<User> findAllByBirthDateBetween(LocalDate dateStart, LocalDate dateEnd);

     List<User> findAllByActiveTrue();
    List<User> findAllByActiveFalse();

    // puede haber varios usuarios con mismo nombre y apellido
    List<User> findAllByNameAndSurname(String name, String surname);

    List<User> findAllByAddressCity(String city);
    List<User> findAllByAddressStreetAndAddressCity(String street, String city);



}
