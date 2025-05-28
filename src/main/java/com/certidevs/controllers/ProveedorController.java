package com.certidevs.controllers;

import com.certidevs.entities.Proveedor;
import com.certidevs.repositories.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor // genera constructor automáticamente para los campos final
@Controller
public class ProveedorController {

    private final ProveedorRepository proveedorRepository;

    // listar todos los proveedores
    @GetMapping("/proveedores")
    public String findAll(Model model) {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        model.addAttribute("proveedores", proveedores);

        return "proveedor/proveedor-list";
    }

}
