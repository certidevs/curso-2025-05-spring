package com.certidevs.repositories;

import com.certidevs.entities.Categoria;
import com.certidevs.entities.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Esta clase tiene varios test
 * Tiene un metodo setUp que se ejecuta siempre al comienzo de cada test
 */
@DataJpaTest
class ProductoRepository2Test {

    // Inyección de dependencias - inyectamos el objeto categoriaRepository para poder usarlo
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProductoRepository productoRepository;

    Categoria categoria1;
    Producto producto1;

    // Se ejecuta siempre antes de cada test
    // Ideal para crear datos demo que usar en los diferentes test
    @BeforeEach
    void setUp() {
        System.out.println("Ejecutando setup para borrar y re-crear los datos");
        productoRepository.deleteAll();
        categoriaRepository.deleteAll();

        categoria1 = new Categoria("ropa", "Artículos textiles");
        producto1 = new Producto("p1", 19.99, 1, true, categoria1);

        categoriaRepository.save(categoria1);
        productoRepository.save(producto1);
    }
    @Test
    void deleteAll() {
        productoRepository.deleteAll();
        categoriaRepository.deleteAll();
    }
    @Test
    @DisplayName("Buscar todos los productos asociados a una categoría")
    void buscarProductosPorCategoria() {

        List<Producto> products1 = productoRepository.findByCategoria_Nombre("ropa");
        List<Producto> products2 = productoRepository.findByCategoria_Id(categoria1.getId());

        assertTrue(products1.size() == 1);
        assertEquals(1, products2.size());

        List<Producto> products3 = productoRepository.findByCategoria_Id(999L); // No existe
        assertEquals(0, products3.size());
    }
    @Test
    @DisplayName("Buscar todos los productos asociados a una categoría")
    void buscarProductosPorCategoria2() {

        List<Producto> products1 = productoRepository.findByCategoria_Nombre("ropa");
        List<Producto> products2 = productoRepository.findByCategoria_Id(categoria1.getId());

        assertTrue(products1.size() == 1);
        assertEquals(1, products2.size());

        List<Producto> products3 = productoRepository.findByCategoria_Id(999L); // No existe
        assertEquals(0, products3.size());
    }


}