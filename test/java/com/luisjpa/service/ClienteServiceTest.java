// src/test/java/com/luisjpa/service/ClienteServiceTest.java
package com.luisjpa.service;

import com.luisjpa.Projeto4JpaApplication;
import com.luisjpa.domain.Cliente;
import com.luisjpa.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Projeto4JpaApplication.class)
public class ClienteServiceTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testCadastrarEBuscarCliente() {
        Cliente cliente = new Cliente(12345678910L, "Teste JPA", 99998888L, "Rua Teste", 123, "Cidade Teste", "SP", 30);
        Cliente clienteSalvo = clienteRepository.save(cliente);

        assertNotNull(clienteSalvo.getId());
        assertEquals(cliente.getNome(), clienteSalvo.getNome());

        Optional<Cliente> clienteEncontrado = clienteRepository.findById(clienteSalvo.getId());
        assertTrue(clienteEncontrado.isPresent());
        assertEquals(cliente.getCpf(), clienteEncontrado.get().getCpf());
    }
}