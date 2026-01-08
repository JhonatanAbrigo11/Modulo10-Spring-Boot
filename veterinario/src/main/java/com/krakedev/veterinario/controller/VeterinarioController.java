package com.krakedev.veterinario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veterinaria")


public class VeterinarioController {
    @GetMapping("/bienvenida")
    public String bienvenida() {
        return "Bienvenido al sistema de Gestión Veterinaria";
    }
}
