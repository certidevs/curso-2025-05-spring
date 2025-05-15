package com.certidevs.repositories;

import com.certidevs.entities.Categoria;
import com.certidevs.entities.Producto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing unitario - JUnit - métodos java (Desarrollador)
 * Testing integración - Spring - (Desarrollador)
 * Testing funcional - UI HTML - Selenium - Cypressjs - (Desarrollador Tester QA CI)
 */
@DataJpaTest // esta anotación indica que debe usar Spring y inicializar los repositorios
class ProductoRepositoryTest {

    // Inyección de dependencias - inyectamos el objeto categoriaRepository para poder usarlo
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProductoRepository productoRepository;

    @Test
    @DisplayName("Crear objeto Producto con Categoria - sin guardar en DB")
    void crearProductosTest() {

        Categoria ropa = new Categoria("ropa", "Artículos textiles");
        Producto p1 = new Producto("p1", 19.99, 1, true, ropa);

        System.out.println(ropa);
        System.out.println(p1);

        assertNotNull(ropa);
        assertNotNull(p1);
    }

    @Test
    void guardarCategoriaTest() {
        Categoria ropa = new Categoria("ropa", "Artículos textiles");
        categoriaRepository.save(ropa);

        assertNotNull(ropa.getId());
        System.out.println(ropa.getId());
        assertEquals(1L, ropa.getId());
    }

    @Test
    void guardarProductoConCategoriaTest() {

        Categoria ropa = new Categoria("cat2", "cat2");
        Producto p1 = new Producto("p1", 19.99, 1, true, ropa);

        productoRepository.save(p1);

        assertNotNull(p1);
        assertNotNull(p1.getId());
        assertNotNull(ropa);
        assertNotNull(ropa.getId());
    }


}