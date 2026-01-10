package com.krakedev.veterinario.service;

import java.util.List;
import java.util.Optional;

import com.krakedev.veterinario.entity.Mascota;

public interface MascotaService {
    Mascota registrarMascota(Mascota mascota);
    List<Mascota> listarMascotas();
    Optional<Mascota> buscarPorNombre (String nombre);
    Optional<Mascota> buscarPorId (int id);
    Mascota actualizarMascota(Long id,Mascota mascota);
    void eliminarMascota(Long id);

    
}
