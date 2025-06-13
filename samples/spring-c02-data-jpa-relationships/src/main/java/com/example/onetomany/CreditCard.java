package com.example.onetomany;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate expiration;
    private String ccv;

    public CreditCard() {
    }

    public CreditCard(String name, LocalDate expiration, String ccv) {
        this.name = name;
        this.expiration = expiration;
        this.ccv = ccv;
    }

    public Long getId() {
        return id;
    }

    public CreditCard setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreditCard setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public CreditCard setExpiration(LocalDate expiration) {
        this.expiration = expiration;
        return this;
    }

    public String getCcv() {
        return ccv;
    }

    public CreditCard setCcv(String ccv) {
        this.ccv = ccv;
        return this;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expiration=" + expiration +
                ", ccv='" + ccv + '\'' +
                '}';
    }
}
