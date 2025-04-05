package com.example.cliente.service;

import com.example.cliente.config.RabbitConfig;
import com.example.cliente.model.Cliente;
import com.example.cliente.repository.ClienteRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final AmqpTemplate amqpTemplate;
    private final ClienteRepository clienteRepository;

    public ClienteService(AmqpTemplate amqpTemplate, ClienteRepository clienteRepository) {
        this.amqpTemplate = amqpTemplate;
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente crearCliente(Cliente cliente) {
        Cliente guardado = clienteRepository.save(cliente);
        amqpTemplate.convertAndSend(RabbitConfig.CLIENTE_QUEUE, guardado.getClienteId());
        return guardado;
    }

    public Optional<Cliente> actualizarCliente(Long id, Cliente clienteActualizado) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setContrasena(clienteActualizado.getContrasena());
            cliente.setEstado(clienteActualizado.getEstado());
            return clienteRepository.save(cliente);
        });
    }

    public boolean eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

