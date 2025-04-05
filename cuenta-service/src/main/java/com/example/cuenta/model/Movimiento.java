
package com.example.cuenta.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    @Column(name = "saldo_inicial")
    private Double saldoInicial;
    private Double movimiento;
    @Column(name = "saldo_disponible")
    private Double saldoDisponible;
    @Column(name = "cuenta_id")
    private Long cuentaId;

}

