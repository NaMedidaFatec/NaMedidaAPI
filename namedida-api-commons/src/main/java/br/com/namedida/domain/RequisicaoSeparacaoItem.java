package br.com.namedida.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "requisicaoseparacaoitem")
@Entity
public class RequisicaoSeparacaoItem extends EntidadeDominio {
    private static final long serialVersionUID = 1L;

    private Double quantidadeEntregue;

    @ManyToOne
    private RequisicaoItem requisicaoItem;

    @ManyToOne
    private Lote estoque;

    @Formula("(SELECT getEstoque(produto_id))")
    private Double quantidadeEstoque = 0d;

    @Transient
    @Getter(AccessLevel.NONE)
    private Double quantidade = 0d;
    public Double getQuantidade() {
        return requisicaoItem.getQuantidadePendente();
    }

    @Transient
    @Getter(AccessLevel.NONE)
    private Double quantidadePendente = 0d;
    public Double getQuantidadePendente() {
        return getQuantidade() - getQuantidadeEntregue();
    }

    @Builder(builderMethodName = "requisicaoSeparacaoItemBuilder")
    public RequisicaoSeparacaoItem(Double quantidadeEntregue, RequisicaoItem requisicaoItem, Lote estoque, Double quantidadeEstoque, Double quantidade, Double quantidadePendente) {
        this.quantidadeEntregue = quantidadeEntregue;
        this.requisicaoItem = requisicaoItem;
        this.estoque = estoque;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidade = quantidade;
        this.quantidadePendente = quantidadePendente;
    }
}
