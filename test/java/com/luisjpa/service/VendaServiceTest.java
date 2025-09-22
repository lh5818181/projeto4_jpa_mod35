package com.luisjpa.service;

import com.luisjpa.Projeto4JpaApplication;
import com.luisjpa.domain.Cliente;
import com.luisjpa.domain.Produto;
import com.luisjpa.domain.ProdutoQuantidade;
import com.luisjpa.domain.Venda;
import com.luisjpa.repository.ClienteRepository;
import com.luisjpa.repository.ProdutoRepository;
import com.luisjpa.repository.VendaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Projeto4JpaApplication.class)
@Transactional
public class VendaServiceTest {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Test
    public void testCadastrarVenda() {
        // 1. Criar e salvar um cliente e um produto
        Cliente cliente = new Cliente(12345678911L, "Venda Teste", 99998888L, "Rua Teste", 123, "Cidade Teste", "SP", 30);
        clienteRepository.save(cliente);

        Produto produto1 = new Produto("PRD001", "Produto 1", "Desc. Prod 1", new BigDecimal("100.00"), "Azul");
        produtoRepository.save(produto1);

        Produto produto2 = new Produto("PRD002", "Produto 2", "Desc. Prod 2", new BigDecimal("50.00"), "Verde");
        produtoRepository.save(produto2);

        // 2. Criar a venda e adicionar os produtos
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setDataVenda(Instant.now());
        venda.setCodigo("VENDA-001");

        ProdutoQuantidade pq1 = new ProdutoQuantidade();
        pq1.setProduto(produto1);
        pq1.setQuantidade(2);
        pq1.setValorTotal(produto1.getValor().multiply(new BigDecimal(pq1.getQuantidade())));
        pq1.setVenda(venda);

        ProdutoQuantidade pq2 = new ProdutoQuantidade();
        pq2.setProduto(produto2);
        pq2.setQuantidade(3);
        pq2.setValorTotal(produto2.getValor().multiply(new BigDecimal(pq2.getQuantidade())));
        pq2.setVenda(venda);

        Set<ProdutoQuantidade> produtos = new HashSet<>();
        produtos.add(pq1);
        produtos.add(pq2);

        venda.setProdutos(produtos);

        // 3. Salvar a venda usando o serviço
        Venda vendaSalva = vendaService.cadastrar(venda);

        // 4. Validar os resultados
        assertNotNull(vendaSalva.getId());
        assertEquals(Venda.Status.INICIADA, vendaSalva.getStatus());
        assertEquals(new BigDecimal("350.00"), vendaSalva.getValorTotal());

        Optional<Venda> vendaEncontrada = vendaRepository.findById(vendaSalva.getId());
        assertTrue(vendaEncontrada.isPresent());
        assertEquals("VENDA-001", vendaEncontrada.get().getCodigo());
    }
}