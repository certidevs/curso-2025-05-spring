package com.example.services.impl;

import com.example.entities.Address;
import com.example.entities.Supermarket;
import com.example.repositories.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html
 */
class AddressServiceImplTest {

    // SUT - System Under Test
    private AddressServiceImpl addressService;
    // Dependencias (Mock)
    private AddressRepository addressRepo;
    private SupermarketServiceImpl supermarketService;

    @BeforeEach // se ejecuta para todos los test
    void setUp() {
        addressRepo = mock(AddressRepository.class); // crea objeto mock
        supermarketService = mock(SupermarketServiceImpl.class);

        addressService = new AddressServiceImpl(addressRepo, supermarketService);
    }

    @Test
    @DisplayName("findAll: Buscar todos los address y comprobar que la ciudad aparece en mayusculas")
    void findAllTest() {

        // 1. (configuración llamadas a mock) (específico de este test)
        List<Address> addressesDB = new ArrayList<>();
        addressesDB.add(new Address(1L, "calle1", "city1", "country1"));
        addressesDB.add(new Address(2L, "calle2", "city2", "country2"));
        when(addressRepo.findAll()).thenReturn(addressesDB);

        // 2. ejecutar el método a testear
        List<Address> addresses = addressService.findAll();

        // 3. comprobaciones
        assertNotNull(addresses);
        assertEquals(2, addresses.size());
        assertEquals("CITY1", addresses.get(0).getCity());
        assertEquals("CITY2", addresses.get(1).getCity());
        verify(addressRepo).findAll(); // verifica que el método findAll del mock ha sido invocado 1 vez
    }

    @Test
    @DisplayName("findByIdTrue: Buscar un address por id 1L y comprobar que tiene la ciudad en mayusculas")
    void findByIdTrueTest() {

        // 1. Configurar Mock
        Address addressDB = new Address(1L, "street1", "city1", "country1");
        Optional<Address> addressOptDB = Optional.of(addressDB);
        when(addressRepo.findById(1L)).thenReturn(addressOptDB);

        // 2. ejecutar el método a testear
        Optional<Address> addressOptional = addressService.findById(1L);

        // 3. comprobaciones
        assertTrue(addressOptional.isPresent());
        assertEquals("CITY1", addressOptional.get().getCity());
        verify(addressRepo).findById(1L);
    }

    @Test
    @DisplayName("findByIdTrueAny: Buscar un address por cualquier id utilizando anyLong() y comprobar que tiene la ciudad en mayusculas")
    void findByIdTrueAnyTest() {

        // 1. Configurar Mock
        Address addressDB = new Address(1L, "street1", "city1", "country1");
        Optional<Address> addressOptDB = Optional.of(addressDB);
        when(addressRepo.findById(anyLong())).thenReturn(addressOptDB);

        // 2. ejecutar el método a testear
        Optional<Address> addressOptional = addressService.findById(4L);

        // 3. comprobaciones
        assertTrue(addressOptional.isPresent());
        assertEquals("CITY1", addressOptional.get().getCity());
        verify(addressRepo).findById(4L);
    }

    @Test
    @DisplayName("findByIdFalse: Buscar un address por id que no existe")
    void findByIdFalseTest() {

        // 1. Configurar Mock
        Optional<Address> emptyOptional = Optional.empty();
        when(addressRepo.findById(anyLong())).thenReturn(emptyOptional);

        // 2. ejecutar el método a testear
        Optional<Address> addressOptional = addressService.findById(4L);

        // 3. comprobaciones
        assertTrue(addressOptional.isEmpty());
        verify(addressRepo).findById(4L);
    }

    @Test
    @DisplayName("findByCountry: Buscar address por country")
    void findByCountryTest() {

        List<Address> addressesDB = new ArrayList<>();
        addressesDB.add(new Address(1L, "calle1", "city1", "Spain"));
        addressesDB.add(new Address(2L, "calle2", "city2", "Spain"));
        when(addressRepo.findByCountry("SPAIN")).thenReturn(addressesDB);

        List<Address> addresses = addressService.findByCountry("Spain");

        assertNotNull(addresses);
        assertEquals(2, addresses.size());
        assertEquals("Spain", addresses.get(0).getCountry());
        assertEquals("Spain", addresses.get(1).getCountry());
        verify(addressRepo).findByCountry("SPAIN");
        verify(addressRepo, never()).findByCountry("Spain");
    }

    @Test
    @DisplayName("findByCountryNull: Buscar address por country null")
    void findByCountryNullTest() {

        List<Address> addresses = addressService.findByCountry(null);

        assertNotNull(addresses);
        assertEquals(0, addresses.size());
        verify(addressRepo, never()).findByCountry(anyString());
    }

    @Test
    @DisplayName("save: guardar address OK")
    void saveTest() {

        // mock
        Address addressInput = new Address(null, "street1", "city1", "Portugal");
        Address addressOutput = new Address(1L, "street1", "city1", "Portugal");
        when(addressRepo.save(addressInput)).thenReturn(addressOutput);

        // ejecutar sut
        Address addressDB = addressService.save(addressInput);

        // comprobaciones
        assertNotNull(addressDB);
        assertEquals(1L, addressDB.getId());
        assertEquals("Portugal", addressDB.getCountry());
        verify(addressRepo).save(addressInput);
    }

    @Test
    @DisplayName("save: guardar address con country a null")
    void saveNullCountryTest() {

        // 1. mock
        Address addressInput = new Address(null, "street1", "city1", null);
        Address addressOutput = new Address(1L, "street1", "city1", "Spain");
        when(addressRepo.save(addressInput)).thenReturn(addressOutput);

        // ejecutar sut
        Address addressDB = addressService.save(addressInput);

        // comprobaciones
        assertNotNull(addressDB);
        assertEquals(1L, addressDB.getId());
        assertEquals("Spain", addressDB.getCountry());
        // capturar argumento address para comprobar sus atributos antes de ser guardado
        ArgumentCaptor<Address> addressArg = ArgumentCaptor.forClass(Address.class);
        verify(addressRepo).save(addressArg.capture());
        assertEquals("Spain", addressArg.getValue().getCountry());

    }

    @Test
    @DisplayName("deleteById: borrar address por id")
    void deleteByIdTest() {

        // 1. Configurar mock:
            // 1.1. existsById
        when(addressRepo.existsById(1L)).thenReturn(true);

            // 1.2. findById
        Address addressDB = new Address(1L, "street1", "city1", "country1");
        Optional<Address> addressOptDB = Optional.of(addressDB);
        when(addressRepo.findById(1L)).thenReturn(addressOptDB);

            // 1.3. findAllByAddressesId
        Address adr1 = new Address(1L, "street1", "city1", "country1");
        Address adr2 = new Address(2L, "street2", "city2", "country2");
        Supermarket super1 = new Supermarket(1L, "sup1", 1990, null, new HashSet<>(Set.of(adr1, adr2)), null);
        Supermarket super2 = new Supermarket(2L, "sup2", 1990, null, new HashSet<>(Set.of(adr1, adr2)), null);
        List<Supermarket> supers = new ArrayList<>(List.of(super1, super2));
        when(supermarketService.findAllByAddressesId(1L)).thenReturn(supers);


        // ejecutar
        addressService.deleteById(1L);

        // comprobaciones
        verify(addressRepo).existsById(1L);
        verify(addressRepo).findById(1L);
        verify(supermarketService).findAllByAddressesId(1L);
        verify(supermarketService).saveAll(supers);
        verify(addressRepo).delete(addressDB);
        for(Supermarket market: supers)
            assertEquals(1, market.getAddresses().size());
    }
}