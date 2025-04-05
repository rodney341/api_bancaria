
package com.example.cuenta.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movimientoId;
    private LocalDate fecha;
    private String tipoMovimiento;
    private Double valor;
    private Double saldo;

    @Column(name = "cuenta_id")
    private Long cuentaId; // Relación por ID

}

