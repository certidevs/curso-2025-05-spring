package com.certidevs.repositories;

import com.certidevs.entities.Categoria;
import com.certidevs.entities.Producto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
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

        // CUIDADO: si se ejecuta otro test puede hacer que este ID sea diferente y no sea 1L
        // assertEquals(1L, ropa.getId());
        assertTrue(ropa.getId() >= 1);

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

    @Test
    void borrarProducto() {

        Producto p1 = new Producto("p1", 19.99, 1, true, null);
        productoRepository.save(p1);
        Long productId = p1.getId();

        assertTrue(productoRepository.existsById(productId));

        productoRepository.deleteById(productId);

        assertFalse(productoRepository.existsById(productId));
    }

    @Test
    @DisplayName("Desactivar un producto equivale a hacer un UPDATE porque lo modificamos")
    void desactivarProducto() {
        Producto p1 = new Producto("p1", 19.99, 1, true, null);
        productoRepository.save(p1);

        Optional<Producto> productOpt = productoRepository.findById(p1.getId());
        if (productOpt.isPresent()) {
            Producto producto = productOpt.get();
            System.out.println(producto.getNombre());
            producto.setDisponible(false); // desactivar producto
            productoRepository.save(producto);
            assertFalse(producto.getDisponible());
        }
    }

    @Test
    @DisplayName("Buscar todos los productos asociados a una categoría")
    void buscarProductosPorCategoria() {

        Categoria ropa = new Categoria("cat2", "cat2");
        categoriaRepository.save(ropa); // se genera un id

        Producto p1 = new Producto("p1", 19.99, 1, true, ropa);
        productoRepository.save(p1);
        Producto p2 = new Producto("p2", 19.99, 1, true, ropa);
        productoRepository.save(p2);

        List<Producto> products1 = productoRepository.findByCategoria_Nombre("cat2");
        List<Producto> products2 = productoRepository.findByCategoria_Id(1L);

        assertTrue(products1.size() == 2);
        assertEquals(2, products2.size());

        List<Producto> products3 = productoRepository.findByCategoria_Id(999L); // No existe
        assertEquals(0, products3.size());
    }


    @Test
    void buscarProductos1() {
        List<Producto> products = productoRepository.findAll();
        System.out.println(products);
    }

    @Test
    void buscarProductos2() {
        List<Producto> products = productoRepository.findAll();
        products.forEach(System.out::println);
    }

    @Test
    void buscarProductos3() {
        List<Producto> products = productoRepository.findAll();
        for (Producto product : products) {
            System.out.println(product);
        }
    }
    @Test
    void buscarProductos4() {
        List<Producto> products = productoRepository.findAll();
        for (Producto product : products) {
            if(product.getDisponible()) {
                System.out.println(product);
            }
        }
    }
    @Test
    void buscarProductos5() {
        List<Producto> productsDisponibles = productoRepository.findAllByDisponibleTrue();
        for (Producto product : productsDisponibles) {
            System.out.println(product);
        }
    }

//    @Test
//    void buscarProductos3() {
//        List<Producto> products = productoRepository.findAll();
//        Model model = ...
//        model.addAttribute("productos", products);
//        return "listado-productos";
//    }


}