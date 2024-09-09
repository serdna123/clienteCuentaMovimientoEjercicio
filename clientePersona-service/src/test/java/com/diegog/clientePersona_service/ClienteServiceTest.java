package com.diegog.clientePersona_service;

import com.diegog.clientePersona_service.model.Cliente;
import com.diegog.clientePersona_service.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClienteServiceTest {

    @Mock
    private com.diegog.clientePersona_service.reposiroty.ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void testCrearCliente() {
        // Datos de prueba
        Cliente cliente = new Cliente();
        cliente.setClienteId("C040");
        cliente.setNombre("Diego Gallegos");
        cliente.setContrasena("password");
        cliente.setEstado(true);

        // Simulación del comportamiento del repositorio
        Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);

        // Llamada al servicio
        Cliente nuevoCliente = clienteService.createCliente(cliente);

        // Verificaciones
        assertNotNull(nuevoCliente);
        assertEquals("C040", nuevoCliente.getClienteId());
        assertEquals("Diego Gallegos", nuevoCliente.getNombre());
        assertTrue(nuevoCliente.isEstado());

        // Verifica que el método save del repositorio fue llamado una vez
        Mockito.verify(clienteRepository, Mockito.times(1)).save(cliente);
        System.out.println("FIN TEST  testCrearCliente");
    }
}
