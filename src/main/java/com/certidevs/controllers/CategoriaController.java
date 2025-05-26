package com.certidevs.controllers;

import com.certidevs.entities.Categoria;
import com.certidevs.repositories.CategoriaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/categorias") // http://localhost:8080/categorias
    public String findAll(Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);

        return "categoria-list";
    }

    @GetMapping("/categorias/{id}") // http://localhost:8080/categorias/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);

        if (categoriaOpt.isPresent()) {
            model.addAttribute("categoria", categoriaOpt.get());
        } else {
            model.addAttribute("error", "404 Categoría Not Found");
        }

        return "categoria-detail";
    }

}
