package com.example.controllers;

import com.example.entities.Beer;
import com.example.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class BeerController {

    private final BeerService beerService;



    @GetMapping("/beers") // http://localhost:8080/beers
    public String findAll(Model model) {
        List<Beer> beers = beerService.findAll();
        model.addAttribute("beers", beers);
        model.addAttribute("message", "Hola mundo");
        return "beer-list";
    }

    @GetMapping("/beers/{id}") // http://localhost:8080/beers/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Beer> beerOpt = beerService.findById(id);

        if(beerOpt.isPresent()) {
            model.addAttribute("beer", beerOpt.get());
        } else {
            model.addAttribute("error", "404 Beer Not Found");
        }

        return "beer-detail";
    }

}
