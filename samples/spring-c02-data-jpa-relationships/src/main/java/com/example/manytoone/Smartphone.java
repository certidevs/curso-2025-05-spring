package com.example.manytoone;

import jakarta.persistence.*;

@Entity
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String brand;
    private Integer ram;

    @ManyToOne
    private Person person;

    public Smartphone() {
    }

    public Smartphone(String number, String brand, Integer ram, Person person) {
        this.number = number;
        this.brand = brand;
        this.ram = ram;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public Smartphone setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Smartphone setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Smartphone setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Integer getRam() {
        return ram;
    }

    public Smartphone setRam(Integer ram) {
        this.ram = ram;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Smartphone setPerson(Person person) {
        this.person = person;
        return this;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", brand='" + brand + '\'' +
                ", ram=" + ram +
                '}';
    }
}
