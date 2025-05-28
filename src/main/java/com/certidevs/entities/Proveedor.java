package com.certidevs.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String email;
    private String telefono;
    private Boolean activo;

    @ManyToMany
    @JoinTable(name = "proveedor_producto")
    @Builder.Default // inicializa productos con el valor por defecto (un ArrayList)
    private List<Producto> productos = new ArrayList<>();
}
