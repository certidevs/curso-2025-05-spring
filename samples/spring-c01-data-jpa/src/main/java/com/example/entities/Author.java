package com.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String fullName;

    @Column(unique = true) // obliga a que el campo tenga un valor único y distinto para cada Author
    private String nif;

    // @Column(nullable = true) // indica que el campo es opcional, es decir, puede ser NULL
    @Column(unique = true, nullable = false) // indica que el campo es obligatorio, es decir, no puede ser NULL
    private String email;

    private LocalDate birthDate;

    private Boolean active;

    private Double salary;

    @OneToOne // Un autor tiene una dirección, una dirección solo puede pertenecer a un mismo autor
    @JoinColumn(unique = true)
    private Address address;

    // mappedBy indica que ya existe una columna en la tabla book por tanto se guarda allí la relación, no hay que hacer nada aquí
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(Long id, String fullName, String nif, String email, LocalDate birthDate, Boolean active, Double salary, Address address) {
        this.id = id;
        this.fullName = fullName;
        this.nif = nif;
        this.email = email;
        this.birthDate = birthDate;
        this.active = active;
        this.salary = salary;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", nif='" + nif + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", active=" + active +
                ", salary=" + salary +
                '}';
    }
}
