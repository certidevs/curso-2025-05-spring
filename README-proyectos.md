
Tecnologías:
* Spring Boot
* HTML, Bootstrap CSS
* Thymeleaf
* Base de datos: H2 y eventualmente MySQL
* Git y GitHub

* Grupo 1: 
  * Nombre: GestorTIC
  * Gestor de tareas https://github.com/Mapakitus/gestor-tareas
  * Entidades JPA `@Entity`: Tarea, Proyecto, Categoria, Usuario, Comentario
  * Paco Gutiérrez
  * Ángel García
  * Javi Noguer
  * Jorge Hurtado
  * Asociaciones:
    * Task ManyToOne Project
    * User ManyToMany Project
    * Comment ManyToOne Task
    * Task ManyToOne Category
  * HTMLs:
    * task-list.html
    * task-detail.html: mostrar task y comments filtrados por task id
    * task-form.html
    * comment-form.html
  * ENTIDADES FINALES: Comment, Project, Task, User
  * Presentación: 
    * Presentación de equipo <-- más conciso, centrado en experiencia laboral o de cursos previos y este curso actual
    * En qué consiste el proyecto, qué problema resuelve? <-- Faltaría esto
    * Desarrollo seguido
    * Perfiles de usuario, Usuarios y Project Manager
    * Modelo de datos <-- Darle más Zoom
    * Entidades <-- La quitamos
    * Tecnologías empleadas
    * Dependencias <-- Es similar al anterior, se puede fusionar
    * Tecnologías de colaboración
    * Repositorio Git en GitHub <-- más zoom
    * Entidades <-- repetido con el que hubo antes?
    * Responsive en ordenador, mobile, tablet (6 min hasta aquí)
    * Demo (dar más zoom)
      * home
      * registro en popup
      * iniciar sesion
      * lista de proyectos
      * nuevo proyecto formulario
      * lista de proyecto
      * editar proyecto y asignar usuarios
      * ver detalle de proyecto
      * lista de tareas con filtro <-- poner un container para evitar ancho máximo, responsive
      * distinción de tareas asignadas a mí y lista de tareas general
      * pruebas con varios usuarios
    * Retorno a presentación (otros 6 min hasta aquí)
    * ¿Qué hemos aprendido?
    * Objetivos para futuras versiones
    * Gracias (15 min en total)
    
  * FEEDBACK JUEVES:
    * Muy bien de tiempo
    * Bien estructurada la presentación

  * FEEDBACK LUNES:
    * Muy buena introducción
    * Muy bonitas y personales los agradecimientos
    * Bien de tiempo
    
  * FEEDBACK MARTES:
    * Bien de tiempo

* Grupo 2: 
  * Nombre: Discommerce Shop
  * Ecommerce https://github.com/isrcercas/FA-Proyecto-Final-Ecommerce-Grupo2
  * Entidades JPA `@Entity`: Producto, Categoria, Usuario, Compra, DetalleCompra
  * Israel Cervera
  * Antonio Mora
  * Vicente Antonio
  * Luis Miguel Roldán
  * Asociacion
    * Producto ManyToOne Categoria
    * Compra ManyToOne Usuario
    * DetalleCompra ManyToOne Compra
    * DetalleCompra ManyToOne Producto
  * ENTIDADES FINALES: Categoria, Producto, Usuario, Compra
  * Presentación
    * Índice
    * Presentaciones de equipo
    * Objetivo del proyecto, qué problema soluciona
    * Tecnologías utilizadas
    * Modelo ER con asociaciones
    * Características clave, funcionalidades, desafíos
    * Fases del desarrollo 
    * Captura del repositorio de GitHub o mostrarlo en el navegador
    * Demo <-- Poner la demo aquí (5 min hasta aquí)
      * Home que permite navegar a distintas pantallas
      * Registro usuario
      * Listado usuarios
      * Editar usuarios
      * Lista de categorías
      * filtros
      * crear nuevo producto
      * detalle producto <-- sería interesante poder hacer clic en la categoría y que te lleve al listado de prod filtrado por categoría
      * crear nueva compra con control de stock
      * en el listado de productos se podría colorear el stock, en rojo, naranja o verde en función de un umbral: th:if
      * 10 min hasta aquí
    * Qué hemos aprendido?
    * Mejoras y actualizaciones
    * El jueves empezamos con grupo 2
    
  * FEEDBACK JUEVES:
    * Muy bien ajustado al tiempo
    * Presentación bien estructurada
    
  * FEEDBACK LUNES:
    * Bien de tiempo
    * Muy bien la demo

  * FEEDBACK MARTES:
    *Muy bien de tiempo (14:30)

* Grupo 3: Cartelera de cine https://github.com/ojosdegato/cine
  * Cinemax
  * Entidades JPA `@Entity`: Pelicula, Genero, Usuario, Proyeccion, Reserva
  * Marcos González
  * David Jiménez
  * Javier Cachón
  * Íñigo Lamadrid
  * Jose Alejandro Cobaria
  * Entidades:
    * Pelicula ManyToOne Categoria-Genero
    * Proyeccion: ManyToOne Pelicula
    * Reserva ManyToOne Usuario 
    * Reserva ManyToOne Proyeccion
      * Ticket ManyToOne Reserva (opcional, no haría falta, la reserva ya serviría)
  * ENTIDADES FINALES: Pelicula, Proyeccion, Sala, Actor, Reserva, Usuario
  * Presentación
      * Faltaría integrar todo en una presentación y demo
      * Mockups de las pantallas <-- Reemplazar por la demo real
      * Lo de AI se podría indicar en la parte de Desarrollos Futuros
      * Demo:
      * Home
      * formulario de crear pelicula
      * listado de peliculas
      * tooltip de Ayuda
      * Filtro por género
      * Editar película
      * Detalle de la película <-- Mostrar imagen de la película
      * Borrar película
  
  * FEEDBACK JUEVES:
    * Acompañar el discurso con diapositivas
    * Agilizar la explicación de herramientas y dependencias
    * Presentarse todos a la vez
    * La demostración de la aplicación hacerla a mitad, no al final
    * Ajustarse mejor al tiempo

  * FEEDBACK MARTES:
    * Controlar el tiempo, acortar algunas secciones
    * Hablar un poco menos sobre el cómo se ha creado el logo

* Grupo 4: Restaurantes https://github.com/Twinkym/Restaurante
  * Web Spanish Restaurant
  * Entidades JPA `@Entity`: Restaurante, Plato, Usuario, Reserva, Pedido
  * Entidades JPA `@Entity`: Restaurante, Mesa, Menu, Plato, Reserva, Categoría
  * Alejandro Dietta
  * David de la Puente
  * Luis Miguel Haro
  * Entidades
    * Mesa: id, numero, capacidad, disponible
    * Reserva: fechaHora LocalDateTime, numeroPersonas, nombreCliente, telefono
    * Plato: nombre, descripcion, precio, imageUrl
    * Categoria: nombre, description
  * Asociaciones:
    * Mesa ManyToOne Restaurante
    * Menu ManyToOne Restaurante
    * Plato ManyToOne Menu
    * Plato ManyToOne Categoria
    * Reserva ManyToOne Mesa
  * ENTIDADES FINALES: Plato, Restaurante, Mesa, Menu, Bebida
  * Presentación:
    * Inicio
    * Equipo
    * Índice
    * Definir objetivo global problema que se resuelve
    * Tecnologías de programacion
    * Menu
    * Gestión de resturantes, el código no se ve, igual mejor una captura del github
    * Arquitectura 
    * Diagrama de flujo
    * Diagrama ER
    * MySQL Workbench
    * Futuro del proyecto
    * Demo: (3 min hasta aquí)
      * Home, ajustar las resoluciones de las imágenes para que no salgan distorsionadas
      * Menú dropdown
      * Reducir el número de entidades para conseguir un MVP funcional de CRUD sobre una o dos entidades completo
  
  * FEEDBACK JUEVES:
    * Ajustarse al tiempo
    * No mostrar tanto código, mostrar la aplicación
    * Si se muestra código, cambiar el IDE para que se lea mejor el código
    * No comentar mucho sobre lo que no os ha dado tiempo, centrarse en lo que sí está hecho

  * FEEDBACK LUNES:
    * Bien de tiempo
    * Tener preparada la aplicación funcionando

* Grupo 5: 
  * Librocultour
  * Biblioteca (La casa del libro) https://github.com/manulibra11996/Biblioteca_java
    * Entidades JPA `@Entity`: Libro, Autor, Categoria, Usuario, Reserva o Compra
    * Francisco Domínguez
    * Rafael Sepulveda
    * Manuel Fernández
    * Miguel Ángel de Andrés
    * Laura María Madrigal
    * Asociaciones:
      * Libro ManyToOne Author
      * Libro ManyToOne Categoria
      * Reserva ManyToOne Usuario
      * Reserva ManyToOne Libro
    * ENTIDADES FINALES: Libro, Autor, Categoria, Socio, Prestamo
    * Presentación
      * Intro
      * Equipo, falta descripción de Laura
      * Introducción y definición
      * Herramientas bases <-- Cambiar título por Herramientas de desarrollo y poner logos
      * Diseño de la base de datos
      * Programación del repositorio <-- Agregar alguna imagen
      * Desarrollo de la página web <-- Agregar algún logo de las tecnologías
      * 6 min hasta aquí
      * Demo (9 min hasta aquí)
        * Diseño Figma 
        * Home de libros y autores
        * Listado de libros
        * Usuarios
        * Política de privacidad cookies etc
      * Pruebas y depuración
      * Conclusión
      * Agradecimientos
      
    * FEEDBACK JUEVES:
      * Ajustar el tiempo un poquito
      
    * FEEDBACK LUNES:
      * Mostrar sólo la presentación
      * Practicar los cambios de persona que presenta
      * Bien de tiempo

    * FEEDBACK MARTES:
      * Asegurarse de que funcione lo que vais a mostrar de la aplicación
      * Bien de tiempo

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
* Asociaciones: ManyToOne/OneToMany
* Repositorios
* Consultas personalizadas en repositorios con queries derivadas o JPQL en repositorios
* Controladores MVC con inyección de repositorios, sin servicios, para simplificar
* HTMLs: detalle, listado y formulario para cada entidad donde se puedan hacer todas las operaciones CRUD.
* HTMLs: Página de error personalizada, página de inicio personalizada.
* Bootstrap CSS y font awesome para iconos
* Base de datos H2
* Rama main


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
* Spring Security
* Múltiples ramas

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