package com.certidevs;


import com.certidevs.entities.Categoria;
import com.certidevs.entities.Producto;
import com.certidevs.entities.Proveedor;
import com.certidevs.repositories.CategoriaRepository;
import com.certidevs.repositories.ProductoRepository;
import com.certidevs.repositories.ProveedorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        // inicializar spring
		ApplicationContext spring = SpringApplication.run(Main.class, args);

        // obtener repositorios (lo crea spring)
        ProductoRepository productoRepository = spring.getBean(ProductoRepository.class);
        CategoriaRepository categoriaRepository = spring.getBean(CategoriaRepository.class);
        ProveedorRepository proveedorRepository = spring.getBean(ProveedorRepository.class);

        // crear categorías
        Categoria frutas = new Categoria("Frutas", "Productos frescos");
        Categoria lacteos = new Categoria("Lácteos", "Productos derivados de la leche");
        Categoria cereales = new Categoria("Cereales", "Alimentos a base de granos y cereales");
        Categoria carne = new Categoria("Carne", null);

        // guardar categorías
        categoriaRepository.saveAll(List.of(frutas, lacteos, cereales, carne));

        // crear productos
        Producto manzana = new Producto("Manzana", 1.50, 100, true, frutas);
        Producto yogur = new Producto("Yogur", 2.00, 50, true, lacteos);
        Producto avena = new Producto("Avena", 3.50, 30, true, cereales);
        Producto queso = new Producto("Queso", 7.50, 1, true, null);
        Producto aguacate = new Producto("Aguacate", 5.00, 0, false, frutas);
        Producto platano = new Producto("Plátano", 2.00, 5, false, frutas);

        // guardar productos
        productoRepository.save(manzana);
        productoRepository.save(yogur);
        productoRepository.save(avena);
        productoRepository.save(queso);
        productoRepository.save(aguacate);
        productoRepository.save(platano);

        // guardar productos de golpe
        // productoRepository.saveAll(List.of(manzana, yogur, avena, queso, aguacate));

        // crear proveedores
        Proveedor proveedor1 = Proveedor.builder()
                        .nombre("Proveedor 1")
                        .email("proveedor1@mail.com")
                        .telefono("111111111")
                        .activo(true)
                        .productos(List.of(manzana, yogur))
                        .build();

        Proveedor proveedor2 = Proveedor.builder()
                        .nombre("Proveedor 2")
                        .telefono("222222222")
                        .email("proveedor2@mail.com")
                        .activo(true)
                        .productos(List.of(avena, queso))
                        .build();

        Proveedor proveedor3 = Proveedor.builder()
                .nombre("Proveedor 3")
                .email("proveedor3@mail.com")
                .telefono("333333333")
                .activo(true)
                .productos(List.of(manzana, aguacate))
                .build();

        Proveedor proveedor4 = Proveedor.builder()
                .nombre("Proveedor 4")
                .telefono("444444444")
                .email("proveedor4@mail.com")
                .activo(false)
                .productos(List.of(yogur, avena, queso))
                .build();

        // guardar proveedores
        proveedorRepository.saveAll(List.of(proveedor1, proveedor2, proveedor3, proveedor4));

        System.out.println("Productos guardados: " + productoRepository.findAll());

        System.out.println("Número total de productos: " + productoRepository.count());

        // probar métodos y consultas

        // probar Producto findByNombreIgnoreCase(String nombre)
        String nombreBuscado = "manzana"; // en minúscula
        Producto productoEncontrado = productoRepository.findByNombreIgnoreCase(nombreBuscado);
        if (productoEncontrado != null) {
            System.out.println("Producto encontrado por nombre '" + nombreBuscado +
                    "': " + productoEncontrado);
        } else {
            System.out.println("No se encontró ningún producto con el nombre: " + nombreBuscado);
        }

        // probar List<Producto> findByPrecioLessThan(Double precio)
        Double precioMaximo = 3.00;
        List<Producto> productosBaratos = productoRepository.findByPrecioLessThan(precioMaximo);
        System.out.println("Productos con precio menor que " + precioMaximo + ":");
        for (Producto producto : productosBaratos) {
            System.out.println("\t " + producto.getNombre() + ": " + producto.getPrecio() + " euros");
        }

        // probar boolean existsByNombreIgnoreCase(String nombre)
        String nombreExistente = "YOGUR";
        boolean existeProducto = productoRepository.existsByNombreIgnoreCase(nombreExistente);
        System.out.println("¿Existe un producto llamado '" + nombreExistente + "'? " + existeProducto);
        String nombreNoExistente = "pera";
        boolean noExisteProducto = productoRepository.existsByNombreIgnoreCase(nombreNoExistente);
        System.out.println("¿Existe un producto llamado '" + nombreNoExistente + "'? " +
                (noExisteProducto ? "Sí" : "No"));

        // probar long countByStock(Integer stock)
        Integer stockBuscado = 100;
        long cantidadProductos = productoRepository.countByStock(stockBuscado);
        System.out.println("Cantidad de productos con stock de " + stockBuscado +
                ": " + cantidadProductos);

        // List<Producto> findByPrecioBetween(Double precioStart, Double precioEnd)
        Double rangoPrecioMinimo = 1.00;
        Double rangoPrecioMaximo = 4.00;
        List<Producto> productosEnRango = productoRepository.findByPrecioBetween(rangoPrecioMinimo, rangoPrecioMaximo);

        System.out.println("Productos con precio entre " + rangoPrecioMinimo + " euros y " +
                rangoPrecioMaximo + " euros:");
        if (productosEnRango.isEmpty()) {
            System.out.println("No se han encontrado productos en este rango de precio.");
        } else {
            for (Producto producto : productosEnRango) {
                System.out.println(producto.getNombre() + ": " + producto.getPrecio() + " euros");
            }
        }

        System.out.println("Total de productos en el rango: " + productosEnRango.size());

        // probar List<Producto> findByCategoria_Nombre(String nombre)
        String categoriaBuscada = "Frutas";
        List<Producto> productosEnCategoria = productoRepository.findByCategoria_Nombre(categoriaBuscada);
        System.out.println("Productos en la categoría " + categoriaBuscada + ":");
        if (productosEnCategoria.isEmpty()) {
            System.out.println("No se han encontrado productos en la categoría " + categoriaBuscada);
        } else {
            for (Producto producto : productosEnCategoria) {
                System.out.println("- " + producto.getNombre() + " (" + producto.getCategoria().getNombre() + ")" + ": " + producto.getPrecio() + " euros");
            }
        }

    }
}
