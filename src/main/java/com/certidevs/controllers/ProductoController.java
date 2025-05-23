package com.certidevs.controllers;

import com.certidevs.entities.Producto;
import com.certidevs.repositories.CategoriaRepository;
import com.certidevs.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Controller
public class ProductoController {

    private ProductoRepository productoRepository;
    private CategoriaRepository categoriaRepository;

    public ProductoController(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    // anotación que mapea las peticiones GET a la URL "/productos"
    @GetMapping("/productos") // http://localhost:8080/productos
    public String findAll(Model model) {
        // crear una lista con todos los productos
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);

        return "producto-list";
    }

    @GetMapping("/productos/{id}") // http://localhost:8080/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Producto> productoOpt = productoRepository.findById(id);

        if (productoOpt.isPresent()) {
           model.addAttribute("producto", productoOpt.get());
        } else {
            model.addAttribute("error", "404 Producto Not Found");
        }

        return "producto-detail";
    }

    // mostrar formulario para crear nuevo producto
    @GetMapping("/productos/nuevo")
    public String createForm(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "producto-form";
    }

}
