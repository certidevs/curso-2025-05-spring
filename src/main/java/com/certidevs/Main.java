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


    }
}
