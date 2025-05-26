package com.certidevs.controllers;

import com.certidevs.repositories.CategoriaRepository;
import org.springframework.stereotype.Controller;

@Controller
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

}
