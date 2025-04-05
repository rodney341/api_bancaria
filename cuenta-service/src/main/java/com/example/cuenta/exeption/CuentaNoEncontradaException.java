package com.example.cuenta.exeption;

public class CuentaNoEncontradaException extends RuntimeException {
    public CuentaNoEncontradaException(Long numeroCuenta) {
        super("Cuenta no encontrada con número: " + numeroCuenta);
    }
}
