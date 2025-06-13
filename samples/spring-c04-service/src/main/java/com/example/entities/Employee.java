package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

/*
Lombok: https://projectlombok.org/features/

 */
@ToString
@Getter
@Setter
@NoArgsConstructor // constructor sin parámetros
@AllArgsConstructor // constructor con todos los parámetros
@Builder // patrón builder para crear objetos
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nif;
    private Double salary;
    private Double bonus;
    private LocalDate registerDate;
    private Boolean active;
}
