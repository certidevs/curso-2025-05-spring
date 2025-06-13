package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer minAllowedAge;

    public Category() {
    }

    public Category(String name, Integer minAllowedAge) {
        this.name = name;
        this.minAllowedAge = minAllowedAge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinAllowedAge() {
        return minAllowedAge;
    }

    public void setMinAllowedAge(Integer minAllowedAge) {
        this.minAllowedAge = minAllowedAge;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minAllowedAge=" + minAllowedAge +
                '}';
    }
}
