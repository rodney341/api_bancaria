package com.example.cuenta.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum TipoCuenta {
    AHORROS,
    CORRIENTE;

    public static String valoresValidos() {
         return Arrays.stream(TipoCuenta.values())
                      .map(Enum::name)
                      .collect(Collectors.joining(", "));
    }
}