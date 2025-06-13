package com.example.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private String color;
    @Column(length = 500)
    private String description;
    private Double price;
    private Boolean available;
    private Integer quantity;
    private LocalDate expireDate;
    @ManyToOne
    private Supermarket supermarket;
}








