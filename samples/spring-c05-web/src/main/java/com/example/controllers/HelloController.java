package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
Clase controlador, recibe peticiones HTTP
 */
@Controller
public class HelloController {

    @GetMapping("hola")
    public String metodo1() {
        return "hello";
    }

    @GetMapping("pagina2")
    public String metodo2(){
        return "pagina2";
    }

}
