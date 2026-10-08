package com.ejemplo.computadoras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Computadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String procesador;
    private Integer ram;
    private Double precio;

    public Computadora() {
    }

    public Computadora(String marca, String procesador, Integer ram, Double precio) {
        this.marca = marca;
        this.procesador = procesador;
        this.ram = ram;
        this.precio = precio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getProcesador() { return procesador; }
    public void setProcesador(String procesador) { this.procesador = procesador; }

    public Integer getRam() { return ram; }
    public void setRam(Integer ram) { this.ram = ram; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
}
