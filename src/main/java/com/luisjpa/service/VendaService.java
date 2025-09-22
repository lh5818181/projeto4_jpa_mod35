package com.luisjpa.service;

import com.luisjpa.domain.Venda;
import com.luisjpa.repository.VendaRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@Transactional
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda cadastrar(Venda venda) {
        // Lógica de negócio, como calcular valor total e definir status
        venda.setStatus(Venda.Status.INICIADA);
        venda.setValorTotal(venda.getProdutos().stream()
                .map(pq -> pq.getValorTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        return vendaRepository.save(venda);
    }

    public Venda finalizarVenda(Venda venda) {
        venda.setStatus(Venda.Status.CONCLUIDA);
        return vendaRepository.save(venda);
    }

    public Venda cancelarVenda(Venda venda) {
        venda.setStatus(Venda.Status.CANCELADA);
        return vendaRepository.save(venda);
    }
}