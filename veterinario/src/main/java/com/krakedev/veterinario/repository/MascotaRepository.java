package com.krakedev.veterinario.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krakedev.veterinario.entity.EstadoMascota;
import com.krakedev.veterinario.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    Optional<Mascota> findById(Long id);

    Optional<Mascota> findByNombre(String nombre);

    Optional<Mascota> findByNombreDueno(String nombreDueno);

    Optional<Mascota> findByEspecie(String especie);

    Optional<Mascota> findByEdad(int edad);

    Optional<Mascota> findByFechaRegistro(LocalDate fechaRegistro);

    List<Mascota> findByEstadoMascota (EstadoMascota estadoMascota);
    

}
