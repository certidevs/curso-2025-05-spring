package com.example.repositories;

import com.example.entities.Food;
import com.example.entities.FoodInfo;
import com.example.repositories.FoodRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
Crear directorio com/example/repositories e introducir aquivos SQL
Asegurarse de que com/example/repositories son carpetas separadas una dentro de otra
 */
@DataJpaTest
public class FoodRepositoryTest {

    // System Under Test - SUT
    @Autowired
    private FoodRepository foodRepo;


    @Sql("foods.sql")
    @DisplayName("Buscar todos con 3 elementos")
    @Test
    void findAllTest() {
        // ejecutar el comportamiento a testear
        List<Food> foods = foodRepo.findAll();

        // comprobaciones
        assertNotNull(foods);
        // assertEquals(3, foods.size());
        assertTrue(foods.size() >= 3);

        // Comprobar nombre
        Food zanahoria = foods.get(0); // 0 es el índice del ArrayList

        assertEquals("zanahoria", zanahoria.getName()); // Comprueba que el nombre del primer Food es 'zanahoria'
        assertEquals(4.99, zanahoria.getPrice());
        assertEquals(Food.class, zanahoria.getClass()); // En caso de tener una jerarquía de herencias

        for (Food food : foods)
            assertEquals(4.99, food.getPrice());

    }

    @Sql("foods.sql")
    @DisplayName("Buscar un Food por id y comprobar que SI existe")
    @Test
    void findByIdTrueTest() {
        Long id = foodRepo.findAll().get(0).getId();
        assertTrue(foodRepo.findById(id).isPresent());
    }

    @Sql("foods.sql")
    @DisplayName("Buscar un Food por id y comprobar que NO existe")
    @Test
    void findByIdFalseTest() {
        assertFalse(foodRepo.findById(999L).isPresent());
    }

    @Sql("foods.sql")
    @DisplayName("Buscar todos por Categoría")
    @Test
    void findAllByCategoryTest() {
        assertEquals(1, foodRepo.findAllByCategory("verdura").size());
        assertEquals(2, foodRepo.findAllByCategory("fruta").size());
    }

    @Sql("foods.sql")
    @DisplayName("Buscar todos por Color")
    @Test
    void findAllByColorTest() {
        assertEquals(2, foodRepo.findAllByColor("Naranja").size());
        assertEquals(1, foodRepo.findAllByColor("Amarillo").size());
    }

    @Sql("foods-with-supermarkets.sql")
    @DisplayName("Buscar todos por Supermercado")
    @Test
    void findAllBySupermarketIdTest() {
        assertEquals(2, foodRepo.findAllBySupermarketId(1L).size());
        assertEquals(2, foodRepo.findAllBySupermarketId(2L).size());
        assertEquals(2, foodRepo.findAllBySupermarketId(3L).size());
    }

    @Test
    @DisplayName("Crear un nuevo Food en base de datos correctamente")
    void saveTest() {
        long sizeBefore = foodRepo.count(); // 0

        Food food = new Food(null, "Alcachofa", "verdura", "gris", "Alcachofa de la llanura", 4.99, true, 4, LocalDate.of(2023, 2, 28), null, null);
        food = foodRepo.save(food);

        long sizeAfter = foodRepo.count(); // 1
        assertEquals(sizeBefore + 1, sizeAfter);
        assertTrue(food.getId() >= 1);
    }

    @Sql("foods.sql")
    @Test
    @DisplayName("Actualizar un Food existente correctamente")
    void updateTest() {
        long sizeBefore = foodRepo.count();

        Long id = foodRepo.findAll().get(0).getId();
        Food food = new Food(id, "Alcachofa", "verdura", "gris", "Alcachofa de la llanura", 4.99, true, 4, LocalDate.of(2023, 2, 28), null, null);
        foodRepo.save(food);

        long sizeAfter = foodRepo.count();
        assertEquals(sizeBefore, sizeAfter);

        Food foodFromDB = foodRepo.findById(id).get();
        assertEquals("Alcachofa", foodFromDB.getName());

    }


    @Test
    @DisplayName("Guardar Food con cascada asociación OneToOne con FoodInfo")
    void saveWithFoodInfoTest() {
        long sizeBefore = foodRepo.count(); // 0

        FoodInfo foodInfo = new FoodInfo(null, 100, 20f, 40f, 40f);
        Food food = new Food(null, "Alcachofa", "verdura", "gris", "Alcachofa de la llanura", 4.99, true, 4, LocalDate.of(2023, 2, 28), null, foodInfo);
        food = foodRepo.save(food); // Operación cascada, se guarda FoodInfo automáticamente y también Food

        long sizeAfter = foodRepo.count(); // 1
        assertEquals(sizeBefore + 1, sizeAfter);
        assertTrue(food.getId() >= 1);
        assertTrue(food.getNutritionInfo().getId() >= 1);
    }

    @Sql("foods.sql")
    @Test
    @DisplayName("Borrar un Food existente correctamente")
    void deleteByIdTest() {
        long sizeBefore = foodRepo.count(); // 3

        Long id = foodRepo.findAll().get(0).getId();
        foodRepo.deleteById(id);

        long sizeAfter = foodRepo.count();

        assertEquals(sizeBefore - 1, sizeAfter); // 2
        assertTrue(foodRepo.findById(id).isEmpty());
        assertFalse(foodRepo.existsById(id));

    }

    @Sql("foods.sql")
    @Test
    @DisplayName("Borrar un Food que no existe y comprobar la excepción")
    void deleteByIdIgnoreTest() {
        long sizeBefore = foodRepo.count(); // 3

        // Opción 1 : con lambda
        // assertThrows(EmptyResultDataAccessException.class, () -> foodRepo.deleteById(99L));
        // long sizeAfter = foodRepo.count(); // 3
        // assertEquals(sizeBefore, sizeAfter);


        // Opción 2: con try catch
        try {
            foodRepo.deleteById(99L);
        } catch (EmptyResultDataAccessException e ) {
            long sizeAfter = foodRepo.count(); // 3
            assertEquals(sizeBefore, sizeAfter);
            return;
        }
        Assertions.fail("No se ha ejecutado la excepción esperada: EmptyResultDataAccessException");
    }

}
