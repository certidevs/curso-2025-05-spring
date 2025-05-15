package com.certidevs.controller;

import com.certidevs.entities.Producto;
import com.certidevs.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

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
