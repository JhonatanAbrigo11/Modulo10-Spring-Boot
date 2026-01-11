package com.krakedev.veterinario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.veterinario.entity.Mascota;
import com.krakedev.veterinario.repository.MascotaRepository;
import com.krakedev.veterinario.service.MascotaService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {
    private final MascotaRepository mascotaRepository;

    @Override
    public Mascota registrarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> buscarPorNombre(String nombre) {
        return mascotaRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Mascota> buscarPorId(int id) {
        return mascotaRepository.findById(id);
    }

    @Override
    @SneakyThrows
    public Mascota actualizarMascota(int id, Mascota mascota) {
        Mascota mascotaExistente = mascotaRepository.findById(id)
                .orElseThrow(() -> new Exception("Mascota no encontrada con id: " + id));

        mascotaExistente.setNombre(mascota.getNombre());
        mascotaExistente.setEspecie(mascota.getEspecie());
        mascotaExistente.setEdad(mascota.getEdad());
        mascotaExistente.setNombreDueno(mascota.getNombreDueno());
        mascotaExistente.setFechaRegistro(mascota.getFechaRegistro());

        return mascotaRepository.save(mascotaExistente);
    }

    @Override
    @SneakyThrows
    public void eliminarMascota(Long id) {
         Mascota mascotaExistente = mascotaRepository.findById(id)
                .orElseThrow(() -> new Exception("Mascota no encontrada con id: " + id));
        mascotaRepository.delete(mascotaExistente);
    }

}
