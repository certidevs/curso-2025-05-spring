package com.example.services;

import com.example.dto.EmployeeStats;
import com.example.entities.Employee;

import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

public interface EmployeeService {

    // CRUD
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Optional<Employee> findByNif(String nif);
    List<Employee> findAllActive();
    Employee save(Employee employee);
    void deleteById(Long id);

    // LÓGICA DE NEGOCIO

    // aumenta el salario a un empleado
    void raiseSalary(Long employeeId, double quantity);

    // aumenta el bonus a un empleado
    void raiseBonus(Long employeeId, double quantity);

    // aumenta el bonus a todos los empleados en base a los años trabajado
    void raiseAllBonusByWorkedYears(double quantity);

    // calcular estadísticas de empleados
    EmployeeStats calculateStats();
}
