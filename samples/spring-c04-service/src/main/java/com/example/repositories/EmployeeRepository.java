package com.example.repositories;

import com.example.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByNif(String nif);
    List<Employee> findAllByActiveTrue();
    List<Employee> findAllByRegisterDateIsNotNull();
}