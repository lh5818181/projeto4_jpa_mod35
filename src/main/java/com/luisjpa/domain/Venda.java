package com.luisjpa.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_VENDA")
@Getter
@Setter
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODIGO", unique = true)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE_FK", foreignKey = @jakarta.persistence.ForeignKey(name = "fk_venda_cliente"))
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProdutoQuantidade> produtos = new HashSet<>();

    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;

    @Column(name = "DATA_VENDA")
    private Instant dataVenda;

    @Column(name = "STATUS_VENDA")
    private Status status;

    public enum Status {
        INICIADA, CONCLUIDA, CANCELADA;

        public static Status getByName(String name) {
            for (Status status : values()) {
                if (status.name().equals(name)) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Invalid status name: " + name);
        }
    }
}