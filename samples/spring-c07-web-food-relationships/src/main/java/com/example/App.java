package com.example;

import com.example.entities.*;
import com.example.entities.enums.SupermarketCategory;
import com.example.repositories.AddressRepository;
import com.example.repositories.FoodRepository;
import com.example.repositories.SupermarketRepository;
import com.example.repositories.SupermarketSectionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);

		// ADDRESS
		var addressRepo = context.getBean(AddressRepository.class);
		var address1 = new Address(null, "calle1", "Madrid", "Spain");
		var address2 = new Address(null, "calle2", "Madrid", "Spain");
		var address3 = new Address(null, "calle1", "Barcelona", "Spain");
		var address4 = new Address(null, "calle2", "Barcelona", "Spain");
		var address5 = new Address(null, "calle3", "León", "Spain");
		var address6 = new Address(null, "calle3", "León", "Spain");
		addressRepo.saveAll(List.of(address1, address2, address3, address4, address5, address6));

		// SUPERMARKET
		var marketRepo = context.getBean(SupermarketRepository.class);
		var market1 = new Supermarket(null, "alimerka", 2000, SupermarketCategory.LOCAL, new HashSet<>(Set.of(address1, address2)), null);
		var market2 = new Supermarket(null, "mercadona", 1990, SupermarketCategory.LOCAL, new HashSet<>(Set.of(address2, address3)), null);
		var market3 = new Supermarket(null, "lupa", 1980, SupermarketCategory.MULTINATIONAL, new HashSet<>(Set.of(address2, address3)), null);
		var market4 = new Supermarket(null, "leclerc", 2001, SupermarketCategory.MULTINATIONAL, new HashSet<>(Set.of(address3, address4)), null);
		var market5 = new Supermarket(null, "dia", 2001, SupermarketCategory.B2B, new HashSet<>(Set.of(address5, address6)), null);
		marketRepo.saveAll(List.of(market1, market2, market3, market4, market5));

		// SECTIONS
		var sectionRepository = context.getBean(SupermarketSectionRepository.class);
		var section1 = new SupermarketSection(null, "Carnicería", true, 20, market1);
		var section2 = new SupermarketSection(null, "Pescadería", true, 20, market1);
		var section3 = new SupermarketSection(null, "Bollería", false, 10, market1);
		var section4 = new SupermarketSection(null, "Heladería", false, 10, market2);
		var section5 = new SupermarketSection(null, "Bebidas", true, 10, market2);
		sectionRepository.saveAll(List.of(section1, section2, section3, section4, section5));

		// FOOD
		var foodRepo = context.getBean(FoodRepository.class);
		foodRepo.saveAll(List.of(
				new Food(null, "Alcachofa", "verdura", "gris", "Alcachofa de la llanura", 4.99, true, 4, LocalDate.of(2023, 2, 28), market1),
				new Food(null, "Pizza", "harinas", "rojo", "Pizza margarita", 12.99, true, 16, LocalDate.of(2023, 2, 28), market1),
				new Food(null, "Zumo", "fruta", "naranja", "Zumo naranja somalí", 3.99, true, 5, LocalDate.of(2023, 2, 28), market2),
				new Food(null, "Chuleta", "verdura", "naranja", "Alcachofa de la llanura", 4.99, true, 4, LocalDate.of(2023, 2, 28), market2),
				new Food(null, "Zanahoria", "verdura", "naranja", "Zanahoria triguera", 7.99, true, 4, LocalDate.of(2023, 2, 28), market3),
				new Food(null, "Brocoli","verdura", "verde", "Brocolin", 8.99, false, 0, LocalDate.of(2023, 2, 28), market4)
		));
	}

}
