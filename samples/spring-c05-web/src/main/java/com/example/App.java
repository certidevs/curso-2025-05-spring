package com.example;

import com.example.entities.Beer;
import com.example.repositories.BeerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        BeerRepository beerRepo = context.getBean(BeerRepository.class);

        Beer beer1 = new Beer(null, "Unfiltered", "También los monjes premostratenses de Strahov elaboran cerveza desde la época medieval.", "yellow", 5.5, 3.5);
        Beer beer2 = new Beer(null, "Pilsner Urquel", "También los monjes premostratenses de Strahov elaboran cerveza desde la época medieval.", "yellow", 5.5, 3.5);
        Beer beer3 = new Beer(null, "Staropramen", "También los monjes premostratenses de Strahov elaboran cerveza desde la época medieval.", "yellow", 5.5, 3.5);
        Beer beer4 = new Beer(null, "Starobrno", "También los monjes premostratenses de Strahov elaboran cerveza desde la época medieval.", "yellow", 5.5, 3.5);
        Beer beer5 = new Beer(null, "Unfiltered", "También los monjes premostratenses de Strahov elaboran cerveza desde la época medieval.", "yellow", 5.5, 3.5);
        Beer beer6 = new Beer(null, "Pilsner Urquel", "También los monjes premostratenses de Strahov elaboran cerveza desde la época medieval.", "yellow", 5.5, 3.5);
        Beer beer7 = new Beer(null, "Staropramen", "También los monjes premostratenses de Strahov elaboran cerveza desde la época medieval.", "yellow", 5.5, 3.5);
        Beer beer8 = new Beer(null, "Starobrno", "También los monjes premostratenses de Strahov elaboran cerveza desde la época medieval.", "yellow", 5.5, 3.5);
        Beer beer9 = new Beer(null, "Starobrno", "También los monjes premostratenses de Strahov elaboran cerveza desde la época medieval.", "yellow", 5.5, 3.5);
        Beer beer10 = new Beer(null, "Starobrno", "También los monjes premostratenses de Strahov elaboran cerveza desde la época medieval.", "yellow", 5.5, 3.5);

        beerRepo.saveAll(List.of(beer1, beer2, beer3, beer4, beer5, beer6, beer7, beer8, beer9, beer10));
    }

}
