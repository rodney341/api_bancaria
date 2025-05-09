package com.example.cuenta.service;

import com.example.cuenta.exeption.SaldoInsuficienteException;
import com.example.cuenta.model.Cuenta;
import com.example.cuenta.model.Movimiento;
import com.example.cuenta.repository.CuentaRepository;
import com.example.cuenta.repository.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final CuentaRepository cuentaRepository;

    public MovimientoService(MovimientoRepository movimientoRepository, CuentaRepository cuentaRepository) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaRepository = cuentaRepository;
    }

    public Movimiento registrarMovimientoEnCuenta(Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.findById(movimiento.getCuentaId())
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        Double saldoInicial = cuenta.getSaldo();
        Double nuevoSaldo = saldoInicial + movimiento.getMovimiento();

        if (nuevoSaldo < 0) {
            throw new SaldoInsuficienteException("No hay suficiente saldo para realizar el movimiento.");
        }

        movimiento.setSaldoInicial(saldoInicial);
        movimiento.setSaldoDisponible(nuevoSaldo);
        movimiento.setFecha(LocalDate.now());

        cuenta.setSaldo(nuevoSaldo);
        cuentaRepository.save(cuenta);

        return movimientoRepository.save(movimiento);
    }

    public List<Movimiento> obtenerMovimientos() {
        return movimientoRepository.findAll();
    }
}


