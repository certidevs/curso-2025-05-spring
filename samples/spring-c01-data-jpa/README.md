
# Spring

Enlace para crear proyecto:

https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.0.2&packaging=jar&jvmVersion=19&groupId=com.example&artifactId=demo&name=spring-c01-data-jpa&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example&dependencies=data-jpa,mysqlc


## Configuración

Este proyecto Spring Boot contiene:

* MySQL
* Spring Data JPA

Creación de entidades usando:

* @Entity
* @Id
* @GeneratedValue
* @Column

En application.properties se añaden las propiedades de configuración para conectarse a MySQL.


## Asociaciones

### Uno a uno

* @OneToOne
* @JoinColumn(unique = true)

Author tiene un Address y un Address pertenece únicamente a un solo Author.

![[asociacion_onetoone.png]]


### Muchos a uno

* @ManyToOne

Muchos Book tienen un mismo Author.

Many books to One Author.

Se genera una columna **author_id** en la tabla **books**.


### Uno a Muchos

* @OneToMany

Un Author tiene muchos Books.

One Author to Many Books.

Nota: cuando hay una lista, se carga a LAZY, es decir, que por defecto esos no se traen de la base de datos.

Las listas por defecto no se cargan, para cargar los datos la lista hay varias opciones:

* fetch = FetchType.EAGER en la anotación @OneToMany
* Consulta en el repositorio
* Consulta personalizada en el repositorio con @Query

![[asociacion_onetomany_manytoone.png]]

### Muchos a muchos

* @ManyToMany

Un libro puede tener muchos géneros, y a su vez y género puede estar en varios libros distintos.

Se crea una tabla extra para mapear los ids de cada tabla.

* book
* book_categories
* category
![[asociacion_many_to_many.png]]

## Generar diagrama tablas

En MySQL Workbench:

1. Database > Reverse Engineer
2. Seleccionar conexión
3. Seleccionar base de datos
4. Darle a Next hasta que abra el diagrama

## Excepciones

### InvalidDataAccessApiUsageException

```
Exception in thread "main" org.springframework.dao.InvalidDataAccessApiUsageException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.example.entities.Author.address -> com.example.entities.Address
```

Esto ocurre porque se ha intentado guardar un author sin haber guardado el objeto address primero.


### DataIntegrityViolationException

```
Exception in thread "main" org.springframework.dao.DataIntegrityViolationException: could not execute statement; SQL [n/a]; constraint
```

Esto ocurre porque se está duplicando una clave única, es decir, que una columna debe ser única pero estamos repitiendo ese dato en múltiples objetos y por tanto la base de datos no lo permite y lanza excepción.


### SQLIntegrityConstraintViolationException
```
SQLIntegrityConstraintViolationException: Cannot delete or update a parent row: a foreign key constraint fails (`spring_c02`.`smartphone`, CONSTRAINT `FKvnxdatl8fprgynr5odmf803u` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
```

Esto se produce porque se ha intentado borrar un objeto person de la base de datos pero tiene asociados teléfonos. Es necesario desasociar esos teléfonos o borrarlos antes de borrar la persona.