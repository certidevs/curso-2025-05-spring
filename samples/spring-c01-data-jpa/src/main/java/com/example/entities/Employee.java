package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nif;


    // constructores

    public Employee() {
    }

    public Employee(Long id, String name, String nif) {
        this.id = id;
        this.name = name;
        this.nif = nif;
    }


    // getter y setter

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getNif() {return nif;}
    public void setNif(String nif) {this.nif = nif;}


    // toString


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nif='" + nif + '\'' +
                '}';
    }
}
