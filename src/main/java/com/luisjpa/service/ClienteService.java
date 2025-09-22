package com.luisjpa.service;

import com.luisjpa.domain.Cliente;
import com.luisjpa.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarPorCpf(Long cpf) {
        return clienteRepository.findByCpf(cpf);
    }
}