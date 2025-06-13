package com.example;

import com.example.entities.Food;
import com.example.repositories.FoodRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		var foodRepo = context.getBean(FoodRepository.class);
		foodRepo.saveAll(List.of(
				new Food(null, "Alcachofa", "verdura", "gris", "Alcachofa de la llanura", 4.99, true, 4, LocalDate.of(2023, 2, 28)),
				new Food(null, "Pizza", "harinas", "rojo", "Pizza margarita", 12.99, true, 16, LocalDate.of(2023, 2, 28)),
				new Food(null, "Zumo", "fruta", "naranja", "Zumo naranja somalí", 3.99, true, 5, LocalDate.of(2023, 2, 28)),
				new Food(null, "Chuleta", "verdura", "naranja", "Alcachofa de la llanura", 4.99, true, 4, LocalDate.of(2023, 2, 28)),
				new Food(null, "Zanahoria", "verdura", "naranja", "Zanahoria triguera", 7.99, true, 4, LocalDate.of(2023, 2, 28)),
				new Food(null, "Brocoli","verdura", "verde", "Brocolin", 8.99, false, 0, LocalDate.of(2023, 2, 28))
		));
	}

}
