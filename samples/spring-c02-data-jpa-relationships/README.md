# Entidades y Asociaciones

Sobre una clase entidad:
* ``@Entity``
* ``@Table (Opcional)``

Sobre un atributo clave primaria:
* ``@Id``
* ``@GeneratedValue(strategy = GenerationType.IDENTITY)``

Personalizar el nombre de una columna en base de datos:
* ``@Column(name = "my_column")``

Hacer que una columna tenga valor único, que no se pueda repetir:
* ``@Column(unique = true)``

Hacer que una columna tenga un valor de forma obligatoria, no puede ser null:
* ``@Column(nullable = false)``

Hacer que una columna tenga tamaño máximo
* ``@Column(length = 50)``

Enumeraciones:
* ``@Enumerated(EnumType.STRING)``

Asociación de **uno a uno**:
* ``@OneToOne``
* ``@JoinColumn(unique = true)``

Asociación de **muchos a uno**:
* ``@ManyToOne``

Asociación de **uno a muchos**:
* Opción 1:
	* ``@ManyToOne``
	* ``@OneToMany(mappedBy = "")``
* Opción 2:
	* ``@OneToMany``
	* ``@JoinTable(name = "company_credit_cards")`` (Opcional)

Asociación de **muchos a muchos**:
* ``@ManyToMany``
* ``@JoinTable(name = "company_credit_cards")`` (Opcional)


## Ejemplos:

Caso categorías:
1. Enumeración: cuando hay un número fijo y pequeño de categorías
2. ``List<String> categories``: lista de string porque con el nombre de la categoría es suficiente
3. ``List<Category> categories``: lista de entidad Category porque tiene varios atributos name, minAge, color y además queremos que se puedan crear nuevas constantemente

Teléfonos de cliente:
1. ``List<String> phones`` Lista de String si es algo muy sencillo y con el número de teléfono es suficiente
2. ``List<Phone> phones`` Lista de entidad Phone si se necesita más información del teléfono por ejemplo: la operadora, el país, la tarifa, el horario de llamada...


Product:

* ``@ManyToMany List<Category> categories``