package com.example;

import com.example.entities.Address;
import com.example.entities.Author;
import com.example.entities.Book;
import com.example.entities.Category;
import com.example.repositories.AddressRepository;
import com.example.repositories.AuthorRepository;
import com.example.repositories.BookRepository;
import com.example.repositories.CategoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootApplication
public class App {

    static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(App.class, args);

        // Operaciones CRUD
        createAndSaveBooks();
        findAllBooks();
        updateBook();
        deleteBook();
        findOneBook();
        existOneBook();
        countBooks();

        // ASOCIACIONES entre Entidades
        oneToOne();
        manyToOne();
        oneToMany();
        manyToMany();

    }


    /**
     * Asociación muchos a muchos (avanzado) @ManyToMany
     * Un libro puede tener muchas categorías
     * Una categoría puede estar en más de un libro
     * Se crea una tabla intermedia automáticamente llamada book_categories
     */
    private static void manyToMany() {
        CategoryRepository categoryRepo = context.getBean(CategoryRepository.class);
        BookRepository bookRepo = context.getBean(BookRepository.class);

        Category category1 = new Category("novela", 12);
        Category category2 = new Category("terror", 18);
        Category category3 = new Category("scifi", 7);
        Category category4 = new Category("bio", 7);
        categoryRepo.saveAll(List.of(category1, category2, category3, category4));

        Book book9 = new Book("book9", 29.99, 450, null);
        book9.getCategories().add(category1);
        book9.getCategories().add(category3);
        bookRepo.save(book9);

        Book book10 = new Book("book10", 29.99, 450, null);
        book10.getCategories().add(category3);
        book10.getCategories().add(category4);
        bookRepo.save(book10);

        Book book11 = new Book("book11", 29.99, 450, null);
        book11.getCategories().add(category1);
        book11.getCategories().add(category2);
        book11.getCategories().add(category3);
        bookRepo.save(book11);

    }

    private static void oneToMany() {
        AuthorRepository authorRepo = context.getBean(AuthorRepository.class);

        // Ya está mapeada gracias al ejemplo anterior de ManyToOne, solo hemos necesario un @OneToMany con mappedBy

        try {
            Author author3FromDB = authorRepo.findById(3L).orElseThrow();
            System.out.println(author3FromDB.getBooks()); // desde el AUTHOR se pueden recuperar los BOOKs
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }


    /**
     * Asociación Muchos a uno @ManyToOne
     * Many books to One Author
     * Muchos libros pertenecen a un mismo autor
     * Un libro no puede pertenecer a dos autores
     */
    private static void manyToOne() {
        AuthorRepository authorRepo = context.getBean(AuthorRepository.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        Author author3 = new Author(null, "author3", "333A", "a3@email.com", LocalDate.now(), true, 3000.99, null);
        Author author4 = new Author(null, "author4", "444A", "a4@email.com", LocalDate.now(), true, 3000.99, null);
        authorRepo.save(author3);
        authorRepo.save(author4);

        Book book4 = new Book("book4", 29.99, 450, author3);
        Book book5 = new Book("book5", 29.99, 450, author3);
        Book book6 = new Book("book6", 29.99, 450, author3);
        Book book7 = new Book("book7", 29.99, 450, author4);
        Book book8 = new Book("book8", 29.99, 450, author4);

        bookRepository.saveAll(List.of(book4, book5, book6, book7, book8));
    }

    /**
     * Asociación de uno a uno @OneToOne
     * Un autor tiene una dirección y una dirección solo puede pertenecer a un mismo autor
     */
    private static void oneToOne() {
        AddressRepository addressRepo = context.getBean(AddressRepository.class);
        AuthorRepository authorRepo = context.getBean(AuthorRepository.class);

        Address address1 = new Address(null, "street1", "madrid", "spain");
        Address address2 = new Address(null, "street2", "madrid", "spain");
        addressRepo.save(address1);
        addressRepo.save(address2);

        // cada author tiene un address distinto, no se pueden repetir
        Author author1 = new Author(null, "author1", "111A", "a1@email.com", LocalDate.now(), true, 3000.0, address1);
        Author author2 = new Author(null, "author2", "222A", "a2@email.com", LocalDate.now(), true, 3000.0, address2);
        authorRepo.save(author1);
        authorRepo.save(author2);
    }



    /**
     * Cuenta cuantos libros hay en base de datos
     * No recupera los libros, solo nos dice el número de libros que hay
     */
    private static void countBooks() {
        BookRepository bookRepository = context.getBean(BookRepository.class);

        long numBooks = bookRepository.count();
        System.out.println("Número de resultados book: " + numBooks);
    }


    /**
     * Comprueba si existe un libro utilizando su ID
     */
    private static void existOneBook() {
        BookRepository bookRepository = context.getBean(BookRepository.class);

        System.out.println("El libro 1 existe: " + bookRepository.existsById(1L));
        System.out.println("El libro 2 existe: " + bookRepository.existsById(2L));
        System.out.println("El libro 3 existe: " + bookRepository.existsById(3L));

    }


    /**
     * Encuentra un libro utilizando su clave primaria Long id
     * El método findById devuelve un Optional en vez de un Book, por tanto
     * hay que extraer el book del Optional con el método get()
     */
    private static void findOneBook() {
        BookRepository bookRepository = context.getBean(BookRepository.class);

        Optional<Book> bookOptional = bookRepository.findById(1L);

        if (bookOptional.isPresent()) { // comprueba si el optional tiene un book dentro
            Book book = bookOptional.get(); // extrae el book del optional
            System.out.println(book.getTitle());

        } else {
            System.out.println("No existe el libro");
        }

    }

    private static void deleteBook() {
        BookRepository bookRepository = context.getBean(BookRepository.class);
        bookRepository.deleteById(1L);
        // bookRepository.delete(book1);
    }

    private static void updateBook() {
        BookRepository bookRepository = context.getBean(BookRepository.class);
        List<Book> books = bookRepository.findAll();

        // actualizar precio de todos los libros
        for (Book book : books)
            book.setPrice(book.getPrice() + book.getPrice() * 0.21);

        bookRepository.saveAll(books);
    }


    /**
     * Ejemplo de recuperar todos los libros de la base de datos
     */
    private static void findAllBooks() {
        BookRepository bookRepository = context.getBean(BookRepository.class);
        System.out.println("==================== FIND ALL BOOKS ====================");
        List<Book> books = bookRepository.findAll();
        for (Book book : books)
            System.out.println(book);

    }


    /**
     * Ejemplo de crear objetos Book y guardarlos en base de datos
     */
    private static void createAndSaveBooks() {
        BookRepository bookRepository = context.getBean(BookRepository.class);

        System.out.println("==================== SAVE BOOK ====================");
        Book book1 = new Book("book1", 9.99, 150, null);
        Book book2 = new Book("book2", 19.99, 366, null);
        Book book3 = new Book("book3", 29.99, 450, null);
        bookRepository.save(book1); // 1
        bookRepository.save(book2); // 2
        bookRepository.save(book3); // 3
    }

}
