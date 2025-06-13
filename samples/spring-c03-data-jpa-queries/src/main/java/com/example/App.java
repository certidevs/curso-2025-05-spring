package com.example;

import com.example.entities.Address;
import com.example.entities.User;
import com.example.entities.UserType;
import com.example.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/*
Filtrar datos de base de datos

Recuperar objetos filtrando por los valores de sus atributos
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
@SpringBootApplication
public class App {

    static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(App.class, args);

        crearDatosDemo();
        filtrarPorNombre();
        filtrarPorHoraEntrada();
        filtrarPorTipoUsuario();
        filtrarPorSalario();
        filtrarPorEmail();
        // Filtro por atributo de una asociación (avanzado)
        filtrarPorDireccion();

    }

    private static void filtrarPorDireccion() {
        UserRepository userRepo = context.getBean(UserRepository.class);

        List<User> users1 = userRepo.findAllByAddressCity("Madrid");
        for (User user : users1)
            System.out.println(user);


        List<User> users2 = userRepo.findAllByAddressStreetAndAddressCity("calle 2", "Madrid");
        for (User user : users2)
            System.out.println(user);
    }

    private static void filtrarPorEmail() {

        UserRepository userRepo = context.getBean(UserRepository.class);

        System.out.println("================== FIND ALL BY EMAIL: javier2@email.com ==================");
        User userJavier2 = userRepo.findByEmail("javier2@email.com");
        System.out.println(userJavier2);

        System.out.println("================== existsByEmail ==================");
        System.out.println("Existe: " + userRepo.existsByEmail("javier2@email.com"));

    }

    private static void filtrarPorSalario() {
        UserRepository userRepo = context.getBean(UserRepository.class);


        System.out.println("================== findBySalaryGreaterThanEqual: 1500 ==================");
        List<User> users1500 = userRepo.findBySalaryGreaterThanEqual(1500.0);
        for (User user : users1500)
            System.out.println(user);


        System.out.println("================== findBySalaryBetween: 1400.0, 1600.0 ==================");
        List<User> userSalaryBetween = userRepo.findBySalaryBetween(1400.0, 1600.0);
        for (User user : userSalaryBetween)
            System.out.println(user);

        System.out.println("================== findBySalaryLessThanEqual: ==================");
        userRepo.findBySalaryLessThanEqual(1300.0).forEach(System.out::println);
    }

    private static void filtrarPorTipoUsuario() {
        UserRepository userRepo = context.getBean(UserRepository.class);

        System.out.println("================== FIND ALL BY USERTYPE: BASIC ==================");
        List<User> basics = userRepo.findAllByUserType(UserType.BASIC);
        for (User user : basics)
            System.out.println(user);


        System.out.println("================== FIND ALL BY USERTYPE: ENTERPRISE ==================");
        List<User> enterprise = userRepo.findAllByUserType(UserType.ENTERPRISE);
        for (User user : enterprise)
            System.out.println(user);
    }

    private static void filtrarPorHoraEntrada() {
        UserRepository userRepo = context.getBean(UserRepository.class);

        System.out.println("================== FIND ALL BY ENTRY HOUR: 10:00 ==================");
        List<User> usersEntry10h = userRepo.findAllByEntryHour(LocalTime.of(10, 0));
        for (User user : usersEntry10h)
            System.out.println(user);

        System.out.println("================== findAllByEntryHourBefore: ==================");
        List<User> usersBefore1015 = userRepo.findAllByEntryHourBefore(LocalTime.of(10, 15));
        for (User user : usersBefore1015)
            System.out.println(user);

        System.out.println("================== findAllByEntryHourAfter: ==================");
        List<User> usersAfter1015 = userRepo.findAllByEntryHourAfter(LocalTime.of(10, 15));
        for (User user : usersAfter1015)
            System.out.println(user);
    }

    private static void filtrarPorNombre() {
        UserRepository userRepo = context.getBean(UserRepository.class);

        System.out.println("================== FIND ALL BY NAME: JAVIER ==================");
        List<User> javieres = userRepo.findAllByName("Javier");
        for (User user : javieres)
            System.out.println(user);


        System.out.println("================== FIND ALL BY NAME: MIGUEL ==================");
        List<User> migueles = userRepo.findAllByName("Miguel");
        for (User user : migueles)
            System.out.println(user);

        System.out.println("================== findAllByNameAndSurname: ==================");
        userRepo.findAllByNameAndSurname("Javier", "García").forEach(System.out::println);
    }

    private static void crearDatosDemo() {
        UserRepository userRepo = context.getBean(UserRepository.class);

        User user1 = new User();
        user1
                .setName("Javier")
                .setSurname("García")
                .setEmail("javier1@email.com")
                .setUserType(UserType.ENTERPRISE)
                .setAddress(new Address("calle 1", "3345", "Madrid"))
                .setEntryHour(LocalTime.of(10, 0))
                .setSalary(1000.0)
                .setBirthDate(LocalDate.of(2000, 1, 1))
                .setActive(true);

        User user2 = new User();
        user2.setName("Javier")
                .setSurname("García")
                .setEmail("javier2@email.com")
                .setUserType(UserType.BASIC)
                .setAddress(new Address("calle 2", "3345", "Barcelona"))
                .setEntryHour(LocalTime.of(10, 20))
                .setSalary(1500.0)
                .setBirthDate(LocalDate.of(2000, 1, 1))
                .setActive(true);

        User user3 = new User();
        user3.setName("Miguel")
                .setSurname("García")
                .setEmail("miguel@email.com")
                .setUserType(UserType.PREMIUM)
                .setAddress(new Address("calle 2", "3345", "Madrid"))
                .setEntryHour(LocalTime.of(11, 0))
                .setSalary(1700.0)
                .setBirthDate(LocalDate.of(2000, 1, 1))
                .setActive(true);

        userRepo.saveAll(List.of(user1, user2, user3));
    }

}
