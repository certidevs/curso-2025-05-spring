package com.example.controllers;

import com.example.entities.Supermarket;
import com.example.services.AddressService;
import com.example.services.FoodService;
import com.example.services.SupermarketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class SupermarketController {

    private final FoodService foodService;
    private final SupermarketService supermarketService;
    private final AddressService addressService;

    @GetMapping("supermarkets")
    public String findAll(Model model) {
        List<Supermarket> supermarkets = supermarketService.findAll();
        model.addAttribute("supermarkets", supermarkets);
        return "market/supermarket-list";
    }

    @GetMapping("supermarkets/{id}")
    public String findById(Model model, @PathVariable Long id) {
        // 1. Opción óptima: crear consulta personalizada para traer las asociaciones únicamente cuando sea necesario
//        Optional<Supermarket> supermarketOpt = supermarketService.findByIdWithAddresses(id);

        // 2. Opción fácil pero menos óptima: Spring se encarga de traer la asociación si detecta que la necesitamos en el HTML
        Optional<Supermarket> supermarketOpt = supermarketService.findById(id);
        if (supermarketOpt.isPresent()) {
            model.addAttribute("supermarket", supermarketOpt.get());
            model.addAttribute("foods", foodService.findAllBySupermarketId(id));
            model.addAttribute("foodStats", foodService.calculateStatsBySupermarketId(id));
        } else {
            model.addAttribute("error", "Not found");
        }
        return "market/supermarket-detail";
    }

    @GetMapping("supermarkets/create")
    public String createForm(Model model) {
        model.addAttribute("supermarket", new Supermarket()); // objeto vacío para rellenar desde el formulario
        model.addAttribute("addresses", addressService.findAll());
        return "market/supermarket-form";
    }

    @GetMapping("supermarkets/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Supermarket> supermarketOpt = supermarketService.findById(id);
        if (supermarketOpt.isPresent()) {
            model.addAttribute("supermarket", supermarketOpt.get());
            model.addAttribute("addresses", addressService.findAll());
        } else {
            model.addAttribute("error", "Food not found");
        }

        return "market/supermarket-form";
    }

    @PostMapping("supermarkets")
    public String saveForm(@ModelAttribute Supermarket supermarket) {
        supermarketService.save(supermarket);
        return "redirect:/supermarkets";
    }

    @GetMapping("supermarkets/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        supermarketService.deleteById(id);
        return "redirect:/supermarkets";
    }

}
