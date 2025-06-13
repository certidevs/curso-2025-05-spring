package com.example.controllers;

import com.example.entities.Food;
import com.example.services.FoodService;
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
public class FoodController {

    private final FoodService foodService;

    @GetMapping("foods") // GET http://localhost:8080/foods
    public String findAll(Model model) {
        List<Food> foods = foodService.findAll();
        model.addAttribute("foods", foods);
        return "food-list";
    }

    @GetMapping("foods/{id}") // http://localhost:8080/foods/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Food> foodOpt = foodService.findById(id);
        if (foodOpt.isPresent())
            model.addAttribute("food", foodOpt.get());
        else
            model.addAttribute("error", "Food not found");

        return "food-detail";
    }

    @GetMapping("foods/color/{color}") // http://localhost:8080/foods/color/verde
    public String findByColor(Model model, @PathVariable String color){
        model.addAttribute("foods", foodService.findAllByColor(color));
        return "food-list";
    }

    @GetMapping("foods/category/{category}") // http://localhost:8080/foods/category/verdura
    public String findByCategory(Model model, @PathVariable String category){
        model.addAttribute("foods", foodService.findAllByCategory(category));
        return "food-list";
    }

    @GetMapping("foods/category/{category}/color/{color}") // http://localhost:8080/foods/category/verdura/color/naranja
    public String findByCategoryAndColor(Model model,
                                         @PathVariable String category,
                                         @PathVariable String color) {
        model.addAttribute("foods", foodService.findAllByCategoryAndColor(category, color));
        return "food-list";
    }

    @GetMapping("foods/create")
    public String createForm(Model model) {
        model.addAttribute("food", new Food()); // objeto vacío para rellenar desde el formulario
        return "food-form";
    }

    @GetMapping("foods/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Food> foodOpt = foodService.findById(id);
        if (foodOpt.isPresent())
            model.addAttribute("food", foodOpt.get());
        else
            model.addAttribute("error", "Food not found");

        return "food-form";
    }

    @PostMapping("foods") // POST http://localhost:8080/foods
    public String saveForm(@ModelAttribute Food food) {
        foodService.save(food);
        return "redirect:/foods"; // Redirección a GET /foods
    }

    @GetMapping("foods/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        foodService.deleteById(id);
        return "redirect:/foods";
    }

}
