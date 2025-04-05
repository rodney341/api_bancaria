
package com.example.cuenta.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuentaId;

    @Column(name = "numero_cuenta", nullable = false, unique = true)
    private String numeroCuenta;

    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;

    @Column(name = "cliente_id")
    private Long clienteId;

}

