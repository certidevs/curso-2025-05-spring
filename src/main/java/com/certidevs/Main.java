package com.certidevs;


import com.certidevs.entities.Producto;
import com.certidevs.repositories.ProductoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        // inicializar spring
		ApplicationContext spring = SpringApplication.run(Main.class, args);

        // obtener repositorio (lo crea spring)
        ProductoRepository productoRepository = spring.getBean(ProductoRepository.class);

        // crear productos
        Producto manzana = new Producto("Manzana", 1.50, 100, true);
        Producto yogur = new Producto("Yogur", 2.00, 50, true);
        Producto avena = new Producto("Avena", 3.50, 30, true);
        Producto queso = new Producto("Queso", 7.50, 20, true);
        Producto aguacate = new Producto("Aguacate", 5.00, 0, false);

        // guardar productos
        productoRepository.save(manzana);
        productoRepository.save(yogur);
        productoRepository.save(avena);
        productoRepository.save(queso);
        productoRepository.save(aguacate);

        // guardar productos de golpe
        // productoRepository.saveAll(List.of(manzana, yogur, avena, queso, aguacate));

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
            System.out.println("\t " + producto.getNombre() + ": " + producto.getPrecio() + "euros");
        }





    }
}
