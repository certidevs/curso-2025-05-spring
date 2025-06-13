package com.example.repositories;

import com.example.entities.SupermarketSection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

/*
 1. Crear paquete com.example.repositories en src/test/java
 2. Crear clase de test SupermarketSectionRepositoryTest
 3. Crear crear directorio resources en src/test
 4. Crear application.properties en src/test/resources
 5. Crear directorio com/example/repositories en src/test/resources
 6. Crear archivo (New > File) sections.sql en src/test/resources/com/example/repositories

 7. Agregar anotaciones: @DataJpaTest y @Autowired
 */

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class SupermarketSectionRepositoryTest {

    @Autowired
    private SupermarketSectionRepository sectionRepo;


    @Sql("sections.sql")
    @Test
    void findAllBySupermarketIdTest() {

        List<SupermarketSection> sections = sectionRepo.findAllBySupermarketId(1L);

        assertNotNull(sections);
        assertEquals(2, sections.size());

        var section1 = sections.get(0);
        var section2 = sections.get(1);

        assertEquals("pescadería", section1.getName());
        assertEquals("carnicería", section2.getName());
    }
}
