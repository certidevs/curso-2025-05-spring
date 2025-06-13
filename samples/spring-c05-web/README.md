
# Spring Web

1. Crear **proyecto** [aquí](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.0.2&packaging=jar&jvmVersion=19&groupId=com.example&artifactId=spring-c05-web&name=spring-c05-web&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example&dependencies=data-jpa,mysql,lombok,web,devtools,thymeleaf): 
	* Spring Data JPA
	* MySQL
	* Lombok
	* Spring Web
	* Spring Boot Devtools
	* Thymeleaf
2. Rellenar **application.properties** con la configuración de MySQL
3. Arrancar MySQL, debe estar en Ejecución
4. Crear **paquete** controller
5. Dentro de paquete controller crear una **clase java HelloController**
	1. ``@Controller``
	2. ``@GetMapping("hello")``
6. Crear un archivo **HTML** en **src/main/resources/templates**, por ejemplo hello.html
7. Ejecutar método **main**
8. Comprobar que en la consola aparece la línea ``Tomcat started on port(s): 8080 (http) with context path ''``
	1. Si da error de que el puerto 8080 está ocupado se puede cambiar el puerto en application.properties utilizando la clave: ``server.port=8081``
9. Abrir en el navegador la URL: http://localhost:8080/

## Pasos crear capa completa para una entidad

1. Entidad
2. Repositorio
3. Servicio
4. Controlador
5. HTML

Ejemplo con entidad cerveza:

1. **Entidad**: Beer
2. **Repositorio**: BeerRepository
3. **Servicio**: BeerService y BeerServiceImpl
4. **Controlador**: BeerController
5. **HTML**:
	1. **beer-list.html**: Listado de cervezas, tiene una tabla donde se muestran todas las cervezas y cada una tiene botones para realizar acciones y navegar a otras pantallas.
	2. **beer-detail.html**: Detalle de una cerveza, muestra los valores de los atributos de una cerveza en concreto.
	3. beer-form.html: Formulario para crear o editar una cerveza

Ejemplo con entidad BankAccount:

1. **Entidad**: BankAccount
2. **Repositorio**: BankAccountRepository
3. **Servicio**: BankAccountService y BankAccountServiceImpl
4. **Controlador**: BankAccountController
5. **HTML**:
	1. bank-account-list.html
	2. bank-account-detail.html
	3. bank-account-form.html



## Spring Boot Devtools

Esta dependencia permite reinicios rápidos y automáticos cuando se hacen cambios en la aplicación.

Marcar las siguientes opciones:

Settings > Compiler > Build project automatically

Settings > Advanced Settings > Allow auto-make to start even....


## Bootstrap

Para buscar dependencias maven/gradle: https://mvnrepository.com/

https://getbootstrap.com/docs/5.2/getting-started/introduction/

Agregar dependencias en el **pom.xml** y recargar Maven:

```xml
<dependency>  
    <groupId>org.webjars</groupId>  
    <artifactId>bootstrap</artifactId>  
    <version>5.2.3</version>  
</dependency>  
<!-- https://mvnrepository.com/artifact/org.webjars/webjars-locator-core -->  
<dependency>  
    <groupId>org.webjars</groupId>  
    <artifactId>webjars-locator-core</artifactId>  
    <version>0.52</version>  
</dependency>
```

En el HTML agregar dentro de las etiquetas **head** la siguiente línea:

```html
<link rel="stylesheet" th:href="@{/webjars/bootstrap/css/bootstrap.min.css}"/>
```


## Interfaz de usuario

Para la entidad cerveza:

1. **beer-list.html**: Listado de cervezas
2. **beer-detail.html**: Detalle de una cerveza
3. **beer-form.html**: Crear/editar una cerveza

## Ejemplos Bootstrap

Ejemplos ya hechos de páginas con Bootstrap:

https://getbootstrap.com/docs/5.2/examples/


## Thymeleaf

https://www.thymeleaf.org/documentation.html

https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html



