package com.example.cuenta.service;

import com.example.cuenta.model.Cuenta;
import com.example.cuenta.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public List<Cuenta> listarCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta crearCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> obtenerCuentaPorId(Long id) {
        return cuentaRepository.findById(id);
    }

    public Optional<Cuenta> actualizarCuenta(Long id, Cuenta cuentaActualizada) {
        return cuentaRepository.findById(id).map(cuenta -> {
            cuenta.setTipoCuenta(cuentaActualizada.getTipoCuenta());
            cuenta.setEstado(cuentaActualizada.getEstado());
            cuenta.setSaldo(cuentaActualizada.getSaldo());
            return cuentaRepository.save(cuenta);
        });
    }

    public boolean eliminarCuenta(Long id) {
        if (cuentaRepository.existsById(id)) {
            cuentaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


