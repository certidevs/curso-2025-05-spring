
1. Crear proyecto con **Spring Security**, esto añade automáticamente las siguientes dependencias en el pom.xml:
	1. spring-boot-starter-security
	2. thymeleaf-extras-springsecurity6
	3. spring-security-test

2. **UserEntity** implements **UserDetails**
	1. Poner a **true** los métodos: isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired(), isEnabled()

3. **UserEntityRepository**

4. **UserDetailsServiceImpl** implements **UserDetailsService**
	1. Se implementa el método **loadUserByUsername**()

5. **SecurityConfig**
	1. Crear bean **PasswordEncoder** utilizando **BCryptPasswordEncoder**

6. **Crear usuarios** en App
	1. Guardar usuarios en base de datos desde **main()** con sus contraseñas codificadas utilizando el PasswordEncoder
	
7. **Iniciar sesión**:
	1. Iniciar la aplicación y entrar a cualquier url. 
	2. Automáticamente lleva a la pantalla ``http://localhost:8080/login``
	3. Spring Security obliga a iniciar sesión, para lo cual es necesario usuario y contraseña.

8. **Cerrar sesión**:
	1. Entrar en la url ``http://localhost:8080/logout``
	2. Saldrá un botón de confirmación de cerrar sesión

9. **Personalizar HTML con thymeleaf**:
	1. Añadir en html: ``xmlns:sec="http://www.thymeleaf.org/extras/spring-security"``
	2. Mostrar elementos **condicionalmente** en función de si el usuario ha iniciado sesión o no
	3. Botón de cerrar sesión
	4. Mostrar el nombre de usuario en la barra de navegación
	5. Ver la clase **SecurityExpressionRoot** para saber qué métodos están disponibles desde thymeleaf

8. Personalizar **Acceso URLS** controladores:
	1. SecurityConfig se crea un bean **SecurityFilterChain** que utiliza **HttpSecurity** para permitir y retringir el acceso a determinadas urls de controladores.