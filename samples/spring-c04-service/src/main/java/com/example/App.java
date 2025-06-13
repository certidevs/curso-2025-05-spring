package com.example;

import com.example.dto.EmployeeStats;
import com.example.entities.Employee;
import com.example.repositories.EmployeeRepository;
import com.example.services.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

/**
 * Probar los métodos de EmployeeService
 */
@SpringBootApplication
public class App {

    static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(App.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        createDemoData();


        // 1. findAll
        for (Employee employee : employeeService.findAll())
            System.out.println(employee);

        // 2. findById
        Employee emp1 = employeeService.findById(1L).orElseThrow();
        System.out.println(emp1);

        // 3. findByNif
        Employee emp2 = employeeService.findByNif("777444333G").orElseThrow();
        System.out.println(emp2);

        // 4. findAllActive
        for (Employee employee : employeeService.findAllActive())
            System.out.println(employee);

        // 5. save
        Employee emp3 = new Employee(null, "56456", 2323.0, 0.0, null, true);
        emp3 = employeeService.save(emp3);
        System.out.println(emp3);

        // 6. deleteById
        employeeService.deleteById(1L);

        // 7. raiseSalary
        employeeService.raiseSalary(2L, 500.0);

        // 8. raiseBonus
        employeeService.raiseBonus(2L, 100.0);

        // 9. raiseAllBonusByWorkedYears
        employeeService.raiseAllBonusByWorkedYears(100.0);

        // 10. calculateStats()
        EmployeeStats stats = employeeService.calculateStats();
        System.out.println(stats);
    }




    private static void createDemoData() {
        EmployeeRepository employeeRepo = context.getBean(EmployeeRepository.class);

        // Constructor con todos los parámetros @AllArgsConstructor
        Employee emp1 = new Employee(null, "777444333G", 1000.0, 0.0, LocalDate.of(2015,1,1), true);

        // Constructor sin parámetros @NoArgsConstructor
        Employee emp2 = new Employee();
        emp2.setNif("666444333T");
        emp2.setSalary(1000.0);
        emp2.setBonus(0.0);
        emp2.setRegisterDate(LocalDate.of(2020,1,1));
        emp2.setActive(true);

        // Patrón builder @Builder
        Employee emp3 = Employee.builder().nif("6666R")
                .salary(1000.0)
                .bonus(0.0)
                .registerDate(LocalDate.of(2018,1,1))
                .build(); // obligatorio introducir método build() al final para construir el objeto

        Employee emp4 = new Employee(null, "555T", 1000.0, 0.0, null, true);

        employeeRepo.saveAll(List.of(emp1, emp2, emp3, emp4));
    }

}
