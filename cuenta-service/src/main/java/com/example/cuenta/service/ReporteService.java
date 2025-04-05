package com.example.cuenta.service;

import com.example.cuenta.dto.CuentaReporteDTO;
import com.example.cuenta.dto.ReporteEstadoCuenta;
import com.example.cuenta.model.Cuenta;
import com.example.cuenta.model.Movimiento;
import com.example.cuenta.repository.CuentaRepository;
import com.example.cuenta.repository.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteService {

    private final CuentaRepository cuentaRepository;
    private final MovimientoRepository movimientoRepository;

    public ReporteService(CuentaRepository cuentaRepository, MovimientoRepository movimientoRepository) {
        this.cuentaRepository = cuentaRepository;
        this.movimientoRepository = movimientoRepository;
    }

    public ReporteEstadoCuenta generarReporte(Long clienteId, LocalDate desde, LocalDate hasta) {
        List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);

        List<CuentaReporteDTO> cuentasConMovimientos = cuentas.stream().map(cuenta -> {
            List<Movimiento> movimientos = movimientoRepository
                .findByCuentaIdAndFechaBetween(cuenta.getCuentaId(), desde, hasta);

            return new CuentaReporteDTO(
                cuenta.getNumeroCuenta(),
                cuenta.getSaldoInicial(),
                movimientos
            );
        }).collect(Collectors.toList());

        return new ReporteEstadoCuenta(clienteId, cuentasConMovimientos);
    }
}


