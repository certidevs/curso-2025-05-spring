

## Patrón MVC:

* Modelo: en las clases Java controladores, se cargan datos en un ``Model`` y se puede acceder a ellos desde HTML, es decir, la vista. Los datos los traemos de un repositorio o un servicio.

* Vista: los archivos html de src/main/resources/templates. Emplea html y una sintaxis especial de Thymeleaf para poder mostrar los datos de java del Model. Por ejemplo: ``th:text="${desarrollador}"``

* Controlador: una clase de Java con métodos especiales para recibir peticiones HTTP desde un navegador. Tiene métodos con urls que corresponden a la url de una página.


## Ejemplos de sintaxis de Thymeleaf:

https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html

* Agregar en la etiqueta `<html>` el thymeleaf: `xmlns:th="http://www.thymeleaf.org"`

* Acceder a variables que están en Model: `${...}`
* Crear enlaces dinámicos: `@{...}`
* Selección de atributos de un objeto: `*{id}`
* Para construir layout con fragmentos: `~{...}`

Atributos comunes de thymeleaf (th:)

* ``th:text`` Reemplaza el contenido de texto de un elemento
* ``th:each`` Hacer bucles 
* ``th:if`` y `th:unless`: control de flujo condicional
* ``th:href`` para enlaces
* ``th:switch`` y ``th:case``: para evaluar múltiples opciones
* ``th:object`` define un objeto sobre el que hacer la sintaxis de selección `*{id}`
* ``th:field`` se usa para enlazar campos de un formularios a propiedades de un objeto
