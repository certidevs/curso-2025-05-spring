package com.certidevs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        // inicializar spring
		ApplicationContext spring = SpringApplication.run(Main.class, args);

        // ejecutar pruebas (comentar para deshabilitar)
        // TestOperaciones testOperaciones = spring.getBean(TestOperaciones.class);
        // testOperaciones.ejecutarPruebas();
    }
}
