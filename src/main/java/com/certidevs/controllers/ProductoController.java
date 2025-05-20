package com.certidevs.controllers;

import com.certidevs.entities.Producto;
import com.certidevs.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ProductoController {

    private ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // anotación que mapea las peticiones GET a la URL "/productos"
    @GetMapping("/productos") // http://localhost:8080/productos
    public String findAll(Model model) {
        // crear una lista con todos los productos
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);

        return "producto-list";
    }

}
