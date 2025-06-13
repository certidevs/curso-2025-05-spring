
# Capa servicio


## Paquete service

* Una interfaz e implementación por cada entidad
Por ejemplo: EmployeeService (Interfaz) y EmployeeServiceImpl (Implementación)


## Lombok

* Lombok: https://projectlombok.org/features/
	* @Getter, @Setter, @ToString, @NoArgsConstructor....

En IntelliJ IDEA en Settings: annotation processing y habilitar la casilla **Enable annotation processing**.


## Logger

Framework de logging para registrar logs (información de la ejecución de la aplicación) en  consola, archivos...

## DTO

Data Transfer Object. Una clase clase Java normal y corriente (no es una entidad) que se utiliza para transferir información de una capa a otra o de un sistema a otro.



## Excepciones

```
NoSuchBeanDefinitionException: No qualifying bean of type 'com.example.services.EmployeeService' available
```

Esto ocurre porque falta una anotación ``@Service`` en la clase servicio para que Spring pueda detectar esa clase y crear objetos de la misma.


```
com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.

Caused by: java.net.ConnectException: Connection refused: no further information
```

Este fallo se produce porque no se ha podido conectar con la base de datos, es necesario arrancar la base de datos primero.


```
Caused by: org.springframework.data.mapping.PropertyReferenceException: No property 'findAllActive' found for type 'Employee'
Caused by: java.lang.IllegalArgumentException: Failed to create query for method public abstract java.util.List com.example.repositories.EmployeeRepository.findAllActiveTrue(); No property 'findAllActive' found for type 'Employee'

```
Esto ocurre porque está mal la consulta creada en el repositorio, le falta la palabra By.