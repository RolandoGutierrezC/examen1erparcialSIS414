package com.ejemplo.computadoras.controller;

import com.ejemplo.computadoras.model.Computadora;
import com.ejemplo.computadoras.service.ComputadoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/computadoras")
public class ComputadoraController {

    private final ComputadoraService service;

    public ComputadoraController(ComputadoraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Computadora> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computadora> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Computadora> crear(@RequestBody Computadora computadora) {
        Computadora nueva = service.guardar(computadora);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computadora> actualizar(@PathVariable Long id,
                                                  @RequestBody Computadora computadora) {
        return service.actualizar(id, computadora)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
