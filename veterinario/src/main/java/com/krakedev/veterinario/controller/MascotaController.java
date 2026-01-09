package com.krakedev.veterinario.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinario.entity.Mascota;

@RestController
@RequestMapping("/api/mascotas")

public class MascotaController {

    private List<Mascota> mascotas = new ArrayList<>();

    public MascotaController () {
        mascotas.add(new Mascota(1, "Firulais", "Perro", 3, "Juan Perez"));
        mascotas.add(new Mascota(2, "Michi", "Gato", 2, "Ana Gomez"));
        mascotas.add(new Mascota(3, "Nemo", "Pez", 2, "Carlos Ruiz"));
        mascotas.add(new Mascota(4, "Chorlito", "Perro", 1, "Carlos Ruiz"));
        mascotas.add(new Mascota(5, "Luna", "Gato", 2, "Carlos Ruiz"));
    }

    @GetMapping
    public List<Mascota> obtenerMascotas() {
        return mascotas;
    }

    @GetMapping("/{id}")
    public Mascota obtenerMascotaPorId(@PathVariable int id){
        Optional<Mascota> mascota = mascotas.stream()
            .filter(m -> m.getId() == id)
            .findFirst();
        return mascota.orElse(null);
    }

    @PostMapping
    public Mascota agregarMascota (@RequestBody Mascota mascota) {
        mascotas.add(mascota);
        return mascota;
    }
}