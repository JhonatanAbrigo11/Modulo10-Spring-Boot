package com.krakedev.veterinario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre) {
        Optional<Mascota> mascota = mascotaService.buscarPorNombre(nombre);
        return mascota.isPresent() ? ResponseEntity.ok(mascota.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada");
    }

    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        Optional<Mascota> mascota = mascotaService.buscarPorId(id);
        return mascota.isPresent() ? ResponseEntity.ok(mascota.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada");
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarMascota(@PathVariable int id, @RequestBody Mascota mascota) {
        try {
            Mascota mascotaAcutalizada = new Mascota();
            mascotaAcutalizada.setNombre(mascota.getNombre());
            mascotaAcutalizada.setEspecie(mascota.getEspecie());
            mascotaAcutalizada.setEdad(mascota.getEdad());
            mascotaAcutalizada.setNombreDueno(mascota.getNombreDueno());
            mascotaAcutalizada.setFechaRegistro(mascota.getFechaRegistro());

            Mascota mascotaBDD = mascotaService.actualizarMascota(id, mascotaAcutalizada);
            return ResponseEntity.ok(mascotaBDD);
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND) .body("Mascota no encontrada con id: " + id);

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarMascota(@PathVariable int id) {
        try {
            mascotaService.eliminarMascota((long) id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND) .body("Mascota no encontrada con id: " + id);
        }
        catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }

    }

    // private List<Mascota> mascotas = new ArrayList<>();

    // public MascotaController () {
    // mascotas.add(new Mascota(1, "Firulais", "Perro", 3, "Juan Perez",
    // LocalDate.of(2022, 5, 12)));
    // mascotas.add(new Mascota(2, "Michi", "Gato", 2, "Ana Gomez",
    // LocalDate.of(2021, 8, 15)));
    // mascotas.add(new Mascota(3, "Nemo", "Pez", 2, "Carlos Ruiz",
    // LocalDate.of(2020, 11, 3)));
    // mascotas.add(new Mascota(4, "Chorlito", "Perro", 1, "Carlos Ruiz",
    // LocalDate.of(2023, 3, 7)));
    // mascotas.add(new Mascota(5, "Luna", "Gato", 2, "Carlos Ruiz",
    // LocalDate.of(2021, 9, 19)));
    // }

    // @GetMapping
    // public List<Mascota> obtenerMascotas() {
    // return mascotas;
    // }

    // @GetMapping("/{id}")
    // public Mascota obtenerMascotaPorId(@PathVariable int id){
    // Optional<Mascota> mascota = mascotas.stream()
    // .filter(m -> m.getId() == id)
    // .findFirst();
    // return mascota.orElse(null);
    // }

    // @PostMapping
    // public Mascota agregarMascota (@RequestBody Mascota mascota) {
    // mascotas.add(mascota);
    // return mascota;
    // }

    // @DeleteMapping("/{id}")
    // public void eliminarMascota(@PathVariable int id) {
    // mascotas.removeIf(m -> m.getId() == id);
    // }
}