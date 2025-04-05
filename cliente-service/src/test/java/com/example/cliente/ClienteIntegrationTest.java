package com.example.cliente;

import com.example.cliente.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void crearClienteTest() {
        // Crear objeto Cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("Carlos");
        cliente.setGenero("M");
        cliente.setEdad(30);
        cliente.setIdentificacion("123456789");
        cliente.setDireccion("Calle Falsa 123");
        cliente.setTelefono("3001234567");
        cliente.setContrasena("123456");
        cliente.setEstado(true);

        // Preparar request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Cliente> request = new HttpEntity<>(cliente, headers);

        // Realizar POST
        ResponseEntity<Cliente> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/clientes",
                request,
                Cliente.class
        );

        // Verificar resultados
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getNombre()).isEqualTo("Carlos");
        assertThat(response.getBody().getIdentificacion()).isEqualTo("123456789");
    }
}
