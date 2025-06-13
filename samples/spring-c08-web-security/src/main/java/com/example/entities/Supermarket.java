package com.example.entities;

import com.example.entities.enums.SupermarketCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "supermarket")
public class Supermarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer initYear;
    private SupermarketCategory category;
//    @OneToMany(mappedBy = "supermarket")
//    private List<Food> foods = new ArrayList<>();
    @ManyToMany
    @ToString.Exclude
    private Set<Address> addresses = new HashSet<>(); // Por defecto son LAZY, es decir no se recuperan de base de datos

    @OneToMany(mappedBy = "supermarket")
    @ToString.Exclude
    private Set<SupermarketSection> sections = new HashSet<>();
}