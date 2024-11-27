package br.com.namedida.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "requisicaoitem")
@Entity
public class RequisicaoItem extends EntidadeDominio {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Double quantidade;

    private Double quantidadeEntregue;

    @ManyToOne
    private Produto produto;

    @Formula("(SELECT getEstoque(produto_id))")
    private Double quantidadeEstoque = 0d;

    @ManyToOne
    private Requisicao requisicao;

    @Transient
    @Getter(AccessLevel.NONE)
    private Double quantidadePendente = 0d;

    public Double getQuantidadePendente() {
        return getQuantidade() - getQuantidadeEntregue();
    }

    @Builder(builderMethodName = "requisicaoitemItemBuilder")
    public RequisicaoItem(Long id, Double quantidade, Double quantidadeEntregue, Produto produto, Double quantidadeEstoque, Requisicao requisicao, Double quantidadePendente) {
        this.quantidade = quantidade;
        this.quantidadeEntregue = quantidadeEntregue;
        this.produto = produto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.requisicao = requisicao;
        this.quantidadePendente = quantidadePendente;
    }
}
