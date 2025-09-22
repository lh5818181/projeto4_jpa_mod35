package com.luisjpa.repository;

import com.luisjpa.domain.ProdutoQuantidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoQuantidadeRepository extends JpaRepository<ProdutoQuantidade, Long> {
}