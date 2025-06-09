package com.certidevs.controllers;

import com.certidevs.dto.ProductoStats;
import com.certidevs.repositories.CategoriaRepository;
import com.certidevs.services.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class StatsController {

    private final ProductoService productoService;
    private final CategoriaRepository categoriaRepository;

    @GetMapping("/estadisticas")
    public String stats(Model model, @RequestParam(required = false) Long categoriaId) {
        ProductoStats stats;

        if (categoriaId != null) {
            stats = productoService.calculateStatsByCategoryId(categoriaId);
            model.addAttribute("categoriaId", categoriaId);
        } else {
            stats = productoService.calculateGeneralStats();
        }

        model.addAttribute("stats", stats);
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "stats";
    }
}