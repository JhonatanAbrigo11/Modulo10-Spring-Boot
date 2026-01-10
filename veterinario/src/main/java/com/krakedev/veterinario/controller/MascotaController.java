package com.krakedev.veterinario.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinario.entity.Mascota;
import com.krakedev.veterinario.service.MascotaService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor


public class MascotaController {

    private final MascotaService mascotaService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarMascota(@RequestBody Mascota mascota) {
        Mascota nuevaMascota = mascotaService.registrarMascota(mascota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
    }

    @GetMapping
    public ResponseEntity<List<Mascota>> listarMascotas() {
        List<Mascota> mascotas = mascotaService.listarMascotas();
        return ResponseEntity.ok(mascotas);
    }







    // private List<Mascota> mascotas = new ArrayList<>();

    // public MascotaController () {
    //     mascotas.add(new Mascota(1, "Firulais", "Perro", 3, "Juan Perez", LocalDate.of(2022, 5, 12)));
    //     mascotas.add(new Mascota(2, "Michi", "Gato", 2, "Ana Gomez", LocalDate.of(2021, 8, 15)));
    //     mascotas.add(new Mascota(3, "Nemo", "Pez", 2, "Carlos Ruiz", LocalDate.of(2020, 11, 3)));
    //     mascotas.add(new Mascota(4, "Chorlito", "Perro", 1, "Carlos Ruiz", LocalDate.of(2023, 3, 7)));
    //     mascotas.add(new Mascota(5, "Luna", "Gato", 2, "Carlos Ruiz", LocalDate.of(2021, 9, 19)));
    // }

    // @GetMapping
    // public List<Mascota> obtenerMascotas() {
    //     return mascotas;
    // }

    // @GetMapping("/{id}")
    // public Mascota obtenerMascotaPorId(@PathVariable int id){
    //     Optional<Mascota> mascota = mascotas.stream()
    //         .filter(m -> m.getId() == id)
    //         .findFirst();
    //     return mascota.orElse(null);
    // }

    // @PostMapping
    // public Mascota agregarMascota (@RequestBody Mascota mascota) {
    //     mascotas.add(mascota);
    //     return mascota;
    // }

    // @DeleteMapping("/{id}")
    // public void eliminarMascota(@PathVariable int id) {
    //     mascotas.removeIf(m -> m.getId() == id);
    // }
}