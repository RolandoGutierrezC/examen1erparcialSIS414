package com.ejemplo.computadoras.service;

import com.ejemplo.computadoras.model.Computadora;
import com.ejemplo.computadoras.repository.ComputadoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputadoraService {

    private final ComputadoraRepository repository;

    public ComputadoraService(ComputadoraRepository repository) {
        this.repository = repository;
    }

    public List<Computadora> listar() {
        return repository.findAll();
    }

    public Optional<Computadora> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Computadora guardar(Computadora computadora) {
        computadora.setId(null); // evita sobrescribir registros existentes al crear
        return repository.save(computadora);
    }

    public Optional<Computadora> actualizar(Long id, Computadora datos) {
        return repository.findById(id).map(existente -> {
            existente.setMarca(datos.getMarca());
            existente.setProcesador(datos.getProcesador());
            existente.setRam(datos.getRam());
            existente.setPrecio(datos.getPrecio());
            return repository.save(existente);
        });
    }

    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
