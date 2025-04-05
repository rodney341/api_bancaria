package com.example.cliente.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testClienteGettersAndSetters() {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);
        cliente.setNombre("Juan Pérez");
        cliente.setContrasena("secreta123");
        cliente.setEstado(true);

        assertEquals(1L, cliente.getClienteId());
        assertEquals("Juan Pérez", cliente.getNombre());
        assertEquals("secreta123", cliente.getContrasena());
        assertTrue(cliente.getEstado());
    }
}
