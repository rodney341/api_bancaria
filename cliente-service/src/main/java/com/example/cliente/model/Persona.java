package com.example.cliente.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Persona {

    @Column(nullable = false, unique = true)
    private String identificacion;
    @Column(nullable = false)
    private String nombre;
    private String genero;
    private Integer edad;
    private String direccion;
    private String telefono;

}

