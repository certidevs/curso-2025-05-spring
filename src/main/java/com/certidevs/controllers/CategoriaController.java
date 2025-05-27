package com.certidevs.controllers;

import com.certidevs.entities.Categoria;
import com.certidevs.repositories.CategoriaRepository;
import com.certidevs.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoriaController {

    private CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    public CategoriaController(CategoriaRepository categoriaRepository,
                               ProductoRepository productoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
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

    @GetMapping("/categorias/nueva")
    public String createForm(Model model) {
        model.addAttribute("categoria", new Categoria());

        return "categoria-form";
    }

    @GetMapping("categorias/{id}/editar")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);

        if (categoriaOpt.isPresent()) {
            model.addAttribute("categoria", categoriaOpt.get());
        } else {
            model.addAttribute("error", "404 Categoría Not Found");
        }

        return "categoria-form";
    }

    @PostMapping("/categorias")
    public String saveForm(@ModelAttribute Categoria categoria) {
        categoriaRepository.save(categoria);

        return "redirect:/categorias";
    }

    @PostMapping("categorias/{id}/eliminar")
    public String delete(@PathVariable Long id) {
        if (productoRepository.countByCategoria_Id(id) > 0) {
            return "redirect:/categorias?error=true";
        }
        categoriaRepository.deleteById(id);

        return "redirect:/categorias";
    }

}
