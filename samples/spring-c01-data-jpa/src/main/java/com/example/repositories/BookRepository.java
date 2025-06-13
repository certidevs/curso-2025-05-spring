package com.example.repositories;

import com.example.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

// Proporciona Métodos CRUD: Create, Retrieve/Read, Update, Delete
public interface BookRepository extends JpaRepository<Book, Long> {
}
