## RETOS

- Crear entidad Asignatura: https://app.certidevs.com/code-exam/e6a0c6d9-b18b-4e9b-a70c-5931164f9cfa
- Entidad y repositorio: https://app.certidevs.com/code-exam/56db9c44-e4f1-4732-abe8-a0dc6e7c0da8
- Métodos derivados y consultas JPQL en repositorios: https://app.certidevs.com/code-exam/912a460d-1c7b-431c-9d9d-9659fed166d2
- Relación ManyToOne con Tarea y Proyecto: https://app.certidevs.com/project-exam/0ddc1351-0c41-4f79-a98b-2b5ca2080529
- Controller de Categoria: https://app.certidevs.com/code-exam/ca2249e8-c2f8-412b-aabe-cc4b3a4a1166

## PROYECTO VACÍO
Hacer fork al proyecto y clonar desde TU cuenta (no la de MdelOlmoCode): https://github.com/MdelolmoCode/proyecto-base


## TRADUCCIONES

- `Entity` -> Entidad
- `Repository` -> Repositorio
- `GeneratedValue` -> Valor generado
- `IDENTITY` -> Identidad

- `new` -> Nuevo

- `Table` -> Tabla
- `name` -> Nombre

- `OneToOne` -> Uno a uno
- `OneToMany` -> Uno a muchos
- `ManyToOne` -> Muchos a uno
- `ManyToMany` -> Muchos a muchos

- `Is` -> Es (por defecto)
- `Like` -> Como (parecido a)
- `NotLike` -> No como (no parecido a)
- `StartsWith` -> Empieza con
- `EndsWith` -> Acaba con
- `Empty` -> Vacío
- `NotEmpty` -> No vacío
- `True` -> Verdadero
- `False` -> Falso
- `Contains` -> Contiene
- `NotContains` -> No contiene
- `Between` -> Entre
- `LessThan` -> Menor que/Menos que
- `LessThanEqual` -> Menor o igual que/Menos o igual que
- `GreaterThan` -> Mayor que/Más que
- `GreaterThanEqual` -> Mayor o igual que/Más o igual que
- `After` -> Después
- `Before` -> Antes
- `In` -> En
- `NotIn` -> No en
- `Not` -> No
- `Null` -> Nulo (null)
- `NotNull` -> No nulo (no null)

- `table` -> tabla/mesa
- `head` -> cabeza
- `header` -> header
- `row` -> fila
- `body` -> cuerpo


### Spring Boot Devtools
Permitir reinicios rápidos y automáticos cuando se hacen cambios en la aplicación.

Marcas las siguientes opciones:

1. `Settings` > `Build, Execution, Deployment > Compiler` > `Build project automatically`
    ![img_3.png](img_3.png)
2. `Settings` > `Advanced Settings` > `Compiler` > `Allow auto-make to start even if developed application is currently running`
    ![img_4.png](img_4.png)
3. Agregar dependencia Spring Boot Devtools al `pom.xml`:
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    ```
4. Agregar línea a `application.properties`:
  `spring.thymeleaf.cache=false`


### Cómo hacer un fork del proyecto

Un fork es una copia del repositorio que yo puedo editar y subir cambios (porque es mi repositorio).

Pasos para hacer un fork:

1. Entrar en https://github.com/ con mi cuenta
2. Ir al repositorio del que quiero hacer fork: https://github.com/certidevs/curso-2025-05-spring
3. Pulsar el botón "Fork" (en línea con el nombre del repositorio)
![img.png](img.png)
4. Nombrar al repositorio como queramos. Se recomienda modificar el nombre para evitar confusiones con el repositorio original
![img_1.png](img_1.png)
5. Pulsar el botón "Create fork"
![img_2.png](img_2.png)
6. Copiar la nueva url desde tu cuenta y clonar el proyecto en el IDE que se quiera


## Cómo actualizar un fork

1. En github.com, entrar en tu repositorio forkeado
2. Actualizar el repositorio dándole `Sync fork` y a `Update branch`
![img_5.png](img_5.png)
3. Actualizar proyecto con un Pull dándole a `Update Project` en Intellij IDEA

## Instalar MySQL

1. Acceder a la página https://dev.mysql.com/downloads/installer/
2. Seleccionamos la versión 8.0.42
3. Le damos al botón "Download" de cualquier instalador
   ![img_6.png](img_6.png)
4. Clicar en el enlace "No thanks, just start my download."
   ![img_7.png](img_7.png)
5. Ejecutar el archivo .msi
6. Aceptar permitir cambios
7. Seleccionar instalación "Full"
   ![img_8.png](img_8.png)
8. Seleccionar el directorio de instalación. Dejar por defecto.
    ![img_9.png](img_9.png)
9. Darle a "Execute"
   ![img_10.png](img_10.png)
10. Si da error en alguno, darle a "Back", a "Next" y volver a "Execute"
    ![img_11.png](img_11.png)
11. Cuando estén todos con el tick verde o con "Ready to install", darle a "Next" o "Execute"
12. Se empezará a instalar. Puede tardar un rato
    ![img_12.png](img_12.png)
13. Se le da a "Next"
    ![img_13.png](img_13.png)
14. Se le da a "Next"
    ![img_14.png](img_14.png)
15. Escribimos una constraseña. Por ejemplo, `admin`. Y le damos a "Check"
16. Desmarcar "Start the MySQL Server at System Startup" y darle a "Next"
    ![img_15.png](img_15.png)
17. Darle a "Next"
18. Darle a "Execute"
    ![img_16.png](img_16.png)
19. Se le da a "Finish"
    ![img_17.png](img_17.png)
20. No marcar nada y darle a "Finish"
    ![img_18.png](img_18.png)
21. Escribir en "Password" la contraseña que se haya elegido, por ejemplo, `admin`. Se da a "Check" y a "Next"
    ![img_19.png](img_19.png)
22. Se le da a "Execute" y "Finish"
    ![img_20.png](img_20.png)
23. Se le da a "Next"
24. Desmarcar las 2 opciones y "Finish"
    ![img_21.png](img_21.png)