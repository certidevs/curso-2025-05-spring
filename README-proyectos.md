
Tecnologías:
* Spring Boot
* HTML, Bootstrap CSS
* Thymeleaf
* Base de datos: H2 y eventualmente MySQL
* Git y GitHub

* Grupo 1: Gestor de tareas https://github.com/Mapakitus/gestor-tareas
  * Entidades JPA `@Entity`: Tarea, Proyecto, Categoria, Usuario, Comentario
  * Paco Gutiérrez
  * Ángel García
  * Ayelén Bosch
  * Javi Noguer
  * Jorge Hurtado

* Grupo 2: Ecommerce https://github.com/isrcercas/FA-Proyecto-Final-Ecommerce-Grupo2
  * Entidades JPA `@Entity`: Producto, Categoria, Usuario, Compra, DetalleCompra
  * Israel Cervera
  * Antonio Mora
  * Vicente Antonio
  * Luis Miguel Roldán

* Grupo 3: Cartelera de cine https://github.com/ojosdegato/cine
  * Entidades JPA `@Entity`: Pelicula, Genero, Usuario, Proyeccion, Reserva
  * Marcos González
  * David Jiménez
  * Javier Cachón
  * Íñigo Lamadrid
  * Jose Alejandro Cobaria
  * Entidades:
    * Pelicula
    * Proyeccion: ManyToOne Pelicula, ManyToOne Sala, fecha, aforo
    * Sala

* Grupo 4: Restaurantes https://github.com/Twinkym/Restaurante
  * Entidades JPA `@Entity`: Restaurante, Plato, Usuario, Reserva, Pedido
  * Alejandro Dietta
  * David de la Puente
  * Luis Miguel Haro

* Grupo 5: Biblioteca (La casa del libro) https://github.com/manulibra11996/Biblioteca_java
  * Entidades JPA `@Entity`: Libro, Autor, Categoria, Usuario, Reserva o Compra
  * Francisco Domínguez
  * Rafael Sepulveda
  * Manuel Fernández
  * Miguel Ángel de Andrés
  * Laura María Madrigal

Otras ideas: 

* charlas tecnológicas tipo el TechFest: charla, ponente, ticket, sala, compra
* PCComponentes: ecommerce orientado a productos tecnológicos ordenadores


## PASOS A SEGUIR

1. Crear un repositorio de GitHub por grupo
2. Crear entidades y atributos
3. Repositorios
4. Controladores
5. HTMLs: list, detalle, formulario
6. Asociaciones ManyToOne entre entidades (parte más propensa a problemas)
7. Estilización CSS con Bootstrap CSS
8. Crear logo con canva o un generator de logos

Plantear dividir estas tareas según metodología ágil en una herramienta de gestión de proyectos.

Repositorio:

* Lo crea un usuario del grupo: github.com/user1/grupo1_proyecto_java (público)
* El admin invita como colaboradores a su equipo
* El resto lo clona
* Opción 1: hacer pull y commit y push todos los días/semanas a la rama main
* Opción 2: cada usuario crea una rama para sus desarrollos
* Opción 3: fork

Recomendación: Opción 1 y eventualmente opción 2.

Consejo: todos los días hacer pull y si nuestros cambios están bien hacer un commit y push

Requisitos:

* Cada uno es responsable de hacer pull commit y push de su código funcional
* Actualizar el progreso de las tareas en la herramienta de gestión de proyectos (Trello o Jira o Notion o GitHub Issues)



## REUNION CON MENTORES

* Lunes 26/05/2025 12:30 grupo1, grupo2, grupo3
* Lunes 26/05/2025 13:00 grupo4, grupo5

## ALCANCE DEL PROYECTO

### DESARROLLO: PUNTOS OBLIGATORIOS

* Entidades: @Entity
* Asociaciones: ManyToOne
* Repositorios
* Consultas personalizadas en repositorios con queries derivadas o JPQL en repositorios
* Controladores MVC con inyección de repositorios, sin servicios, para simplificar
* HTMLs: detalle, listado y formulario para cada entidad donde se puedan hacer todas las operaciones CRUD.
* HTMLs: Página de error personalizada, página de inicio personalizada.
* Bootstrap CSS y font awesome para iconos
* Base de datos H2


### DESARROLLO: PUNTOS OPCIONALES:

Los grupos que ya hayan completado la parte obligatoria y vayan avanzados y vean que les sobra tiempo mi consejo es que trabajen en las diapositivas de la presentación y en la demo.

Si aún así les sobra tiempo y quieren experimentar a agregar más cosas al proyecto entonces pueden:

* Uso de servicios entre controlador y repositorio: @Service
* Base de datos MySQL
* Búsquedas y filtros
* Paginación y ordenamiento con Pageable
* Controladores REST con DTOs @RestController
* Testing de integración con mockMvc de los controladores MVC
* Manejo global de excepciones con @ControllerAdvice
* Poder escribir una opinión mediante ManyToOne en un producto, película, tarea, o libro, como usuario anónimo.

GitHub con ejemplos: https://github.com/certidevs/spring

Fecha: 02/07/2025

### PRESENTACIÓN OBLIGATORIA

26/06/2025 ensayo con mentores

02/07/2025 presentación a empresas

Cada grupo presenta el proyecto en 15 minutos.

* Diapositivas
  * Nombre y logo del proyecto
  * Introducción y objetivos y problema que resuelve
  * Equipo: presentarse cada uno brevemente pero dando una pincelada de la experiencia o cursos anteriores.
  * Tecnologías empleadas: Java 24, IntelliJ IDEA, Spring Boot, HTML, Bootstrap CSS, Thymeleaf, H2 o MySQL, Git y GitHub, Reuniones diarias o semanales, gestión de proyectos con Trello-Jira-Notion
  * Mostrar el repositorio de GitHub, no hace falta explicar el código
  * Diseños Figma (opcional)
  * Demo:
    * Home
    * Listado de Algo (Productos, Tareas, Proyectos, Libros...)
    * Detalle de Algo (Producto, Tarea, Libro...)
    * Formulario de Algo (formulario para crear un producto)
    * Login y Registro
  * Conclusiones e ideas futuras
    * Trabajar en equipo de forma colaborativa
    * Aprender Java, Spring Boot, crear aplicación full stack web desde cero
    * Aprender a crear modelos de datos esquemas de base de datos
    * Ideas futuras: capa seguridad, distintos roles de usuario, agregar X funcionalidades, dashboard de compras realizadas

* Herramientas para hacer la presentación:
  * Canva
  * Google Slides
  * Microsoft PowerPoint
  * Figma
  * Miro