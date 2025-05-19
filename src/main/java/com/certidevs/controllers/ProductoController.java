package com.certidevs.controllers;

import com.certidevs.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ProductoController {

//    @Autowired
//    private ProductoRepository productoRepository;

    private ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

//    public String listProductos() {
//        List<Producto> productos = productoRepository.findAll();
//        return null;
//    }
}
