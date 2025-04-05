package com.example.cuenta.messaging;

import com.example.cuenta.config.RabbitConfig;
import com.example.cuenta.model.Cuenta;
import com.example.cuenta.repository.CuentaRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteListener {

    @Autowired
    private CuentaRepository cuentaRepository;

    @RabbitListener(queues = RabbitConfig.CLIENTE_QUEUE)
    public void recibirClienteId(Long clienteId) {
        System.out.println("📨 Recibido nuevo cliente ID: " + clienteId);

        Cuenta cuenta = new Cuenta();
        cuenta.setClienteId(clienteId);
        cuenta.setNumeroCuenta(UUID.randomUUID().toString().substring(0, 10)); // Número aleatorio
        cuenta.setTipoCuenta("AHORROS");
        cuenta.setSaldoInicial(0.0);
        cuenta.setEstado(true);

        cuentaRepository.save(cuenta);

        System.out.println("✅ Cuenta creada automáticamente para cliente ID: " + clienteId);
    }
}
