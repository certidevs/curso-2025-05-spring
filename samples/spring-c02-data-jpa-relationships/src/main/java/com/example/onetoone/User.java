package com.example.onetoone;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
// @Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private LocalTime entryHour;

    @OneToOne
    @JoinColumn(unique = true)
    private Address address;


    public User() {
    }

    public User(Long id, String name, String email, UserType userType, LocalTime entryHour, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.entryHour = entryHour;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalTime getEntryHour() {
        return entryHour;
    }

    public void setEntryHour(LocalTime entryHour) {
        this.entryHour = entryHour;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                ", entryHour=" + entryHour +
                '}';
    }
}
