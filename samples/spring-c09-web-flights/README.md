# Aplicación vuelos

- [x] Crear el proyecto
- [x] Agregar dependencias extra: bootstrap y webjars. Y recargar Maven
- [x] Configurar conexión MySQL en application.properties

- [x] Entidad Flight
- [x] Repositorio FlightRepository
- [x] Interfaz servicio FlightService: crud y lógica de negocio
- [x] Implementación servicio FlightServiceImpl
- [x] Controlador FlightController
	- [ ] findAll
	- [ ] findById
	- [ ] showCreateForm
	- [ ] showEditForm
	- [ ] saveForm
	- [ ] deleteById

- [ ] Entidad Ticket asociada a Flight ManyToOne
- [ ] Repositorio TicketRepository
- [ ] Interfaz servicio TicketService: crud y lógica de negocio
- [ ] Implementación servicio TicketServiceImpl
- [ ] Controlador TicketController
	- [ ] findAll
	- [ ] findById
	- [ ] showCreateForm
	- [ ] showEditForm
	- [ ] saveForm
	- [ ] deleteById

- [ ] Entidad Passenger asociada a Ticket One To Many. Se integra con UserDetails
- [ ] Repositorio PassengerRepository
- [ ] Interfaz servicio PassengerService: crud y lógica de negocio
- [ ] Implementación servicio PassengerServiceImpl
- [ ] Controlador PassengerController
	- [ ] findAll
	- [ ] findById
	- [ ] showCreateForm
	- [ ] showEditForm
	- [ ] saveForm
	- [ ] deleteById

- [ ] flight-list.html
- [ ] flight-detail.html
- [ ] flight-form.html
- [ ] ticket-list.html
- [ ] ticket-detail.html
- [ ] ticket-form.html