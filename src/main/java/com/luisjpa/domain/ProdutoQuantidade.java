package com.luisjpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUTO_QUANTIDADE")
@Getter
@Setter
@NoArgsConstructor
public class ProdutoQuantidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO_FK", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "fk_prod_quant_produto"))
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "ID_VENDA_FK", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "fk_prod_quant_venda"))
    private Venda venda;

    @Column(name = "QUANTIDADE", nullable = false)
    private Integer quantidade;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private BigDecimal valorTotal;
}