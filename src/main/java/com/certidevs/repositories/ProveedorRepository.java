package com.certidevs.repositories;

import com.certidevs.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    // encontrar proveedores que sean activos
    List<Proveedor> findByActivoTrue();

    // encontrar proveedores que no sean activos
    List<Proveedor> findByActivoFalse();
}