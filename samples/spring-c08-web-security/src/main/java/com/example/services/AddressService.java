package com.example.services;

import com.example.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> findAll();
    Optional<Address> findById(Long id);
    List<Address> findByCountry(String country);
    Address save(Address address);
    void deleteById(Long id);
}
