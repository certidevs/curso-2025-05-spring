package com.certidevs.repositories;

import com.certidevs.entities.Categoria;
import com.certidevs.entities.Producto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

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

    // CRUD - Create Read Update Delete
    @Test
    @DisplayName("La operación Create de CRUD de categoría y producto")
    void guardarProductoConCategoriaTest() {

        Categoria ropa = new Categoria("cat2", "cat2");
        categoriaRepository.save(ropa); // se genera un id

        Producto p1 = new Producto("p1", 19.99, 1, true, ropa);
        productoRepository.save(p1);

        assertNotNull(p1);
        assertNotNull(p1.getId()); // verifica que se ha generado un id al guardar
        assertNotNull(ropa);
        assertNotNull(ropa.getId()); // verifica que se ha generado un id guardar
    }

    @Test
    void buscarProductosTest() {

        // 1. GUARDAR PRODUCTO
        Producto p1 = new Producto("p1", 19.99, 1, true, null);
        productoRepository.save(p1);
        Long productId = p1.getId(); // id generado en base de datos


        // 2. BUSCAR PRODUCTO
        // Optional es un envoltorio que envuelve objeto que podría ser null
        Optional<Producto> productoOptional = productoRepository.findById(productId);

        boolean existeProducto = productoOptional.isPresent();
        assertTrue(existeProducto);

        Producto productoGuardado = productoOptional.get();
        System.out.println(productoGuardado);
        assertEquals(p1.getId(), productoGuardado.getId());
    }

    @Test
    @DisplayName("Buscar producto que no existe, da un Optional vacío")
    void buscarProductoNoExiste() {

        Optional<Producto> productOpt = productoRepository.findById(999L);

        assertFalse(productOpt.isPresent());
        assertTrue(productOpt.isEmpty());

        // Como el producto es null si intentamos acceder da error, es normal:
        // String productNombre = productOpt.get().getNombre(); // Lanza una excepción java.util.NoSuchElementException: No value present
        // System.out.println(productNombre);

        // Forma segura:
        if (productOpt.isPresent()) {
            Producto producto = productOpt.get();
            System.out.println(producto.getNombre());
        }
    }
}