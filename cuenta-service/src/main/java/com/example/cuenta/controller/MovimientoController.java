
package com.example.cuenta.controller;

import com.example.cuenta.model.Cuenta;
import com.example.cuenta.model.Movimiento;
import com.example.cuenta.repository.CuentaRepository;
import com.example.cuenta.repository.MovimientoRepository;
import com.example.cuenta.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<Movimiento> registrarMovimiento(@RequestBody Movimiento movimiento) {
        Movimiento nuevoMovimiento = movimientoService.registrarMovimientoEnCuenta(movimiento);
        return ResponseEntity.ok(nuevoMovimiento);
    }

    @GetMapping
    public List<Movimiento> listar() {
        return movimientoService.obtenerMovimientos();
    }
}
