package com.certidevs.services;

import com.certidevs.entities.Producto;
import com.certidevs.repositories.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductoService {

    private ProductoRepository productoRepository;

    // métodos CRUD (delegación)

    public List<Producto> findAll() {
        return productoRepository.findAll(); // delegación simple
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    // lógica de negocio
}
