
# Ejemplo desde cero

1. Crear **proyecto** Spring y revisar que están todos los starters/dependencias:
	* spring-boot-starter-data-jpa
	* spring-boot-starter-thymeleaf
	* spring-boot-starter-web
	* spring-boot-devtools
	* mysql-connector-j
	* lombok

2. Añadir **dependencias** extra dentro de las etiquetas ``<dependencies>`` y `</dependencies>`

```xml
<dependency>  
    <groupId>org.webjars</groupId>  
    <artifactId>bootstrap</artifactId>  
    <version>5.2.3</version>  
</dependency>  
<dependency>  
    <groupId>org.webjars</groupId>  
    <artifactId>webjars-locator-core</artifactId>  
    <version>0.52</version>  
</dependency>
```

3. Clic derecho dentro del **pom.xml > Maven > Reload Project**
4. Agregar propiedades de configuración en el archivo **application.properties**:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_c06?createDatabaseIfNotExist=true  
spring.datasource.username=root  
spring.datasource.password=admin  
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  
spring.jpa.hibernate.ddl-auto=create  
spring.jpa.show-sql=true  
spring.jpa.properties.hibernate.format_sql=true  
spring.main.banner-mode=off
```

**Nota**: el nombre de la base de datos es **spring_c06**, se puede cambiar por el que se quiera.

5. Crear **entidad**: Food
	* Añadir anotaciones a la entidad:

```java

import jakarta.persistence.*;  
import lombok.*;
@Getter  
@Setter  
@ToString  
@NoArgsConstructor  
@AllArgsConstructor  
@Builder  
@Entity  
@Table(name = "foods")  
public class Food {  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  
    private String name;  
}
```


6. Crear **repositorio**: FoodRepository
```java
import org.springframework.data.jpa.repository.JpaRepository;  
import com.example.entities.Food;  
  
public interface FoodRepository extends JpaRepository<Food, Long> {  
}
```


7. Crear **servicio**: FoodService y FoodServiceImpl

```java
import com.example.entities.Food;  
  
import java.util.List;  
  
public interface FoodService {  
    // crud  
    List<Food> findAll();  
      
    // lógica de negocio  
}
```

```java
import com.example.entities.Food;  
import com.example.repositories.FoodRepository;  
import lombok.AllArgsConstructor;  
import org.springframework.stereotype.Service;  
import java.util.List;  
  
@AllArgsConstructor  
@Service  
public class FoodServiceImpl implements FoodService {  
    private final FoodRepository foodRepository;  
  
    @Override  
    public List<Food> findAll() {  
        return foodRepository.findAll();  
    }  
}
```

8. Crear **controlador**: FoodController

```java
@AllArgsConstructor  
@Controller  
public class FoodController {  
  
    private final FoodService foodService;  
   
    @GetMapping("foods")  
    public String findAll(Model model) {  
        List<Food> foods = foodService.findAll();  
        model.addAttribute("foods", foods);  
        return "food-list";  
    }  
}
```

9. Crear **listado HTML**: 
	* Crear archivo **food-list.html** en la carpeta src/main/resources/templates
	* Añadir bootstrap en el head de html: 
		* `<link rel="stylesheet" th:href="@{/webjars/bootstrap/css/bootstrap.min.css}"/>`
	* Añadir bootstrap js antes de cerrar el body de html:
		* ``<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>``
	* Crear contenido: tabla
	* Comprobar si funciona: Entrar en la URL: http://localhost:8080/foods (Tiene que coincidir con @GetMapping)

10. Crear **detalle HTML**:
	* Crear archivo **food-detail.html** en la carpeta src/main/resources/templates
	* Añadir bootstrap
	* Crear contenido: card
	* Comprobar si funciona: Entrar en la URL:
		* http://localhost:8080/foods/1
		* http://localhost:8080/foods/2
		* http://localhost:8080/foods/3



## Operaciones Thymeleaf

![[Thymeleaf1.png]]


## Excepciones

```
java.lang.IllegalStateException: Ambiguous handler methods mapped for '/foods/1':
```

Esto se debe a una colisión de métodos en los controladores. La solución es no duplicar urls en los controladores utilizando urls diferentes para cada método.


## Esquema:

1. Entidad y asociaciones
2. Repositorios con consultas
3. Servicios
4. Controladores
5. Archivos HTML


## Flujo de ejecución:

Listado:
1. http://localhost:8080/foods
2. FoodController método findAll()
3. food-list.html

Listado por categoría:
1. http://localhost:8080/foods/category/verdura
2. FoodController método findAllByCategory(category)
3. food-list.html

Detalle:
1. http://localhost:8080/foods/2
2. FoodController método findById(id)
3. food-detail.html

Entrar al formulario para **CREAR** una nueva Food:
1. http://localhost:8080/foods/create (GET) llama a **createForm()** de **FoodController** 
2. food-form.html
3. Rellenar inputs del formulario
4. Pulsar botón guardar
5. Se envía automáticamente a **saveForm()** de **FoodController (POST)**
6. Se guarda en base de datos
7. Redirección a **findAll() (GET)** donde se muestran el listado de Food

Entrar al formulario para **EDITAR** una Food existente:
1. http://localhost:8080/foods/{id}/edit (GET) llama a **editForm()** de **FoodController**
2. findById(id) para recuperar el food
3. food-form.html
4. Modificar inputs del formulario
5. Pulsar botón guardar
6. Se envía automáticamente a **saveForm()** de **FoodController (POST)**
7. Se guarda en base de datos
8. Redirección a **findAll() (GET)** donde se muestran el listado de Food

Borrar por id:
1. Pulsar **botón Borrar** en el listado o en el detalle
2. Se ejecuta el método **deleteById(id)** de **FoodController**
3. Ejecuta el método **deleteById** del **FoodService**
4. Ejecutar el método **deleteById** del **FoodRepository**
5. Se redirige hacia el método **findAll()** de **FoodController**
6. food-list.html
