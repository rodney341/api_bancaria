package com.example.cuenta.dto;

import com.example.cuenta.model.Movimiento;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.text.StyledEditorKit;
import java.util.List;
@Data
@AllArgsConstructor
public class CuentaReporteDTO {
    private Long numeroCuenta;
    private Double saldo;
    private Boolean estado;
    private List<Movimiento> movimientos;
}
