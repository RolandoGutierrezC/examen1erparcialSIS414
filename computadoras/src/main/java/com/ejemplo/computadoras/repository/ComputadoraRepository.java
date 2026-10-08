package com.ejemplo.computadoras.repository;

import com.ejemplo.computadoras.model.Computadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadoraRepository extends JpaRepository<Computadora, Long> {
}
