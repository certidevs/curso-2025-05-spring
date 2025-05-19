package com.certidevs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// clase controlador MVC, maneja peticiones HTTP
@Controller
public class HelloController {

    @GetMapping("hola")
    public String saludar() {
        return "hello"; // nombre archivo html (hello.html)
    }

}
