package com.example.services.impl;

import com.example.entities.Address;
import com.example.entities.Supermarket;
import com.example.repositories.AddressRepository;
import com.example.services.AddressService;
import com.example.services.SupermarketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private static final String DEFAULT_COUNTRY = "Spain";
    private final AddressRepository addressRepository;
    private final SupermarketService supermarketService;

    @Override
    public List<Address> findAll() {
        List<Address> addresses = addressRepository.findAll();

        for (Address address : addresses)
            address.setCity(address.getCity().toUpperCase());

        return addresses;
    }

    @Override
    public Optional<Address> findById(Long id) {
        Optional<Address> addressOpt = addressRepository.findById(id);
        if (addressOpt.isEmpty())
            return addressOpt;

        Address address = addressOpt.get();
        address.setCity(address.getCity().toUpperCase());
        return Optional.of(address);
    }

    @Override
    public List<Address> findByCountry(String country) {
        if (!StringUtils.hasLength(country))
            return new ArrayList<>();

        return addressRepository.findByCountry(country.toUpperCase());
    }

    @Override
    public Address save(Address address) {
        if (!StringUtils.hasLength(address.getCountry()))
            address.setCountry(DEFAULT_COUNTRY);

        return addressRepository.save(address);
    }

    @Override
    public void deleteById(Long id) {
        if (!addressRepository.existsById(id))
            return;

        Address address = addressRepository.findById(id).get();

        // desasociar supermarkets
        List<Supermarket> supermarkets = supermarketService.findAllByAddressesId(id);
        for (Supermarket supermarket : supermarkets)
            supermarket.getAddresses().remove(address); // many to many
            // supermarket.setAddress(null); // many to one

        supermarketService.saveAll(supermarkets);

        // borrar
        addressRepository.delete(address);
    }
}
