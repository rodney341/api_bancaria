package com.example.cuenta.dto;

import com.example.cuenta.model.Movimiento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CuentaReporteDTO {
    private Long numeroCuenta;
    private Double saldo;
    private List<Movimiento> movimientos;
}
