package com.example.controllers;

import com.example.entities.Supermarket;
import com.example.entities.SupermarketSection;
import com.example.services.SupermarketSectionService;
import com.example.services.SupermarketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class SupermarketSectionController {

    private final SupermarketSectionService sectionService;
    private final SupermarketService marketService;

    @GetMapping("supermarket-sections/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<SupermarketSection> sectionOpt = sectionService.findById(id);
        if (sectionOpt.isPresent()) {
            model.addAttribute("section", sectionOpt.get());
        } else {
            model.addAttribute("error", "Not found");
        }
        return "section/supermarket-section-detail";
    }

    @GetMapping("supermarket-sections/create/{id}")
    public String createForm(Model model, @PathVariable Long id) {
        SupermarketSection section = new SupermarketSection();

        Optional<Supermarket> marketOpt = marketService.findById(id);
        if (marketOpt.isPresent())
            section.setSupermarket(marketOpt.get());

        model.addAttribute("section", section);
        model.addAttribute("supermarkets", marketService.findAll());
        return "section/supermarket-section-form";
    }

    @GetMapping("supermarket-sections/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<SupermarketSection> sectionOpt = sectionService.findById(id);
        if (sectionOpt.isPresent()) {
            model.addAttribute("section", sectionOpt.get());
            model.addAttribute("supermarkets", marketService.findAll());
        } else {
            model.addAttribute("error", "Not found");
        }

        return "section/supermarket-section-form";
    }

    @PostMapping("supermarket-sections")
    public String saveForm(@ModelAttribute SupermarketSection section) {
        sectionService.save(section);
        return "redirect:/supermarket-sections/" + section.getId();
    }
}
