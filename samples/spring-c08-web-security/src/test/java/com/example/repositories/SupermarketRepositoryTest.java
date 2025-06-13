package com.example.repositories;

import com.example.entities.Supermarket;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class SupermarketRepositoryTest {

    @Autowired
    private SupermarketRepository supermarketRepo;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Sql("supermarkets.sql")
    @Test
    void findAllTest() {
        Optional<Supermarket> marketOpt = supermarketRepo.findById(1L);
        assertTrue(marketOpt.isPresent());

        System.out.println("=======");

        // Lanza una segunda consulta. Si la sesión estuviera cerrada entonces lanzaría una excepción LazyInitializationException
        Supermarket market = marketOpt.get();
        assertEquals(2, market.getAddresses().size());
    }

    @Sql("supermarkets.sql")
    @Test
    void findByIdWithAddressesTest() {
        Optional<Supermarket> marketOpt = supermarketRepo.findByIdWithAddresses(1L);
        assertTrue(marketOpt.isPresent());

        System.out.println("=======");

        // No lanza una segunda consulta porque ya recuperó los Addresses en la primera consulta
        Supermarket market = marketOpt.get();
        assertEquals(2, market.getAddresses().size());
    }


}
