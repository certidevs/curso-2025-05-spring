package com.certidevs.services;

import com.certidevs.dto.ProductoStats;
import com.certidevs.entities.Producto;
import com.certidevs.repositories.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

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

    public List<Producto> findByCategoria_Id(Long id) {
        return productoRepository.findByCategoria_Id(id);
    }

    public List<Producto> findByNombreContainsIgnoreCase(String nombre) {
        return productoRepository.findByNombreContainsIgnoreCase(nombre);
    }

    // LÓGICA DE NEGOCIO

    // método privado que valida si un producto es válido
    private boolean isValidProduct(Producto producto) {
        return producto.getDisponible() != null && producto.getDisponible() // está disponible
        && producto.getStock() != null && producto.getStock() > 0 // tiene stock
        && producto.getPrecio() != null && producto.getPrecio() > 0; // tiene precio válido
    }

    // calcular estadísticas para productos de UNA categoría específica
    public ProductoStats calculateStatsByCategoryId(Long id) {
        // obtener productos de la categoría
        List<Producto> productos = productoRepository.findByCategoria_Id(id);

        // encontrar precio máximo
        double maxPrice = 0.0;
        for (Producto producto : productos) {
            // sólo considerar productos válidos
            if (isValidProduct(producto) && producto.getPrecio() > maxPrice) {
                maxPrice = producto.getPrecio();
            }
        }

        // encontrar precio mínimo
        double minPrice = maxPrice; // incializar con el máximo encontrado
        for (Producto producto : productos) {
            if (isValidProduct(producto) && producto.getPrecio() < minPrice) {
                minPrice = producto.getPrecio();
            }
        }

        // calcular totales para la media
        int countProducts = 0; // contador de unidades
        double sumPrice = 0.0; // suma total ponderada por stock
        for (Producto producto : productos) {
            if (isValidProduct(producto)) {
                countProducts += producto.getStock(); // suma unidades
                sumPrice += producto.getPrecio() * producto.getStock(); // suma ponderada
            }
        }

        // calcular precio medio ponderado
        double meanPrice = 0.0;
        if (sumPrice > 0 && countProducts > 0) {
            meanPrice = sumPrice / countProducts; // media ponderada
            meanPrice = Math.round(meanPrice * 100) / 100.0; // redondear a 2 decimales
        }

        // devolver DTO con las estadíscas calculadas
        return new ProductoStats(minPrice, maxPrice, meanPrice, countProducts);
    }

    // calcular estadísticas para todos los productos
    public ProductoStats calculateGeneralStats() {
        // obtener todos los productos
        List<Producto> productos = productoRepository.findAll();

        // encontrar precio máximo
        double maxPrice = 0.0;
        for (Producto producto : productos) {
            // sólo considerar productos válidos
            if (isValidProduct(producto) && producto.getPrecio() > maxPrice) {
                maxPrice = producto.getPrecio();
            }
        }

        // encontrar precio mínimo
        double minPrice = maxPrice; // incializar con el máximo encontrado
        for (Producto producto : productos) {
            if (isValidProduct(producto) && producto.getPrecio() < minPrice) {
                minPrice = producto.getPrecio();
            }
        }

        // calcular totales para la media
        int countProducts = 0; // contador de unidades
        double sumPrice = 0.0; // suma total ponderada por stock
        for (Producto producto : productos) {
            if (isValidProduct(producto)) {
                countProducts += producto.getStock(); // suma unidades
                sumPrice += producto.getPrecio() * producto.getStock(); // suma ponderada
            }
        }

        // calcular precio medio ponderado
        double meanPrice = 0.0;
        if (sumPrice > 0 && countProducts > 0) {
            meanPrice = sumPrice / countProducts; // media ponderada
            meanPrice = Math.round(meanPrice * 100) / 100.0; // redondear a 2 decimales
        }

        // devolver DTO con las estadíscas calculadas
        return new ProductoStats(minPrice, maxPrice, meanPrice, countProducts);
    }
}