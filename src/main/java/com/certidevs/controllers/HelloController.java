package com.certidevs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// clase controlador MVC, maneja peticiones HTTP
@Controller
public class HelloController {

    @GetMapping("hola") // http://localhost:8080/hola
    public String saludar() {
        return "hello"; // nombre archivo html (hello.html)
    }

    @GetMapping("info")
    public String informacion(Model model) {
        // añadir datos al modelo
        model.addAttribute("desarrollador", "M. del Olmo");
        model.addAttribute("fecha", "19/05/2025");
        model.addAttribute("version", "1.0");

        return "info"; // nombre archivo html
    }

}
