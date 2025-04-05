package com.example.cuenta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ReporteEstadoCuenta {
    private Long clienteId;
    private List<CuentaReporteDTO> cuentas;
}
