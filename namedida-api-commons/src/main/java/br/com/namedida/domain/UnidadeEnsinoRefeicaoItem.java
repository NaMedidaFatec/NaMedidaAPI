package br.com.namedida.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import org.hibernate.annotations.Formula;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "refeicaoitem")
@Entity
public class UnidadeEnsinoRefeicaoItem extends EntidadeDominio {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Double quantidade;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private UnidadeEnsinoRefeicao refeicao;

    @Builder(builderMethodName = "refeicaoItemBuilder")
    public UnidadeEnsinoRefeicaoItem(Long id, Double quantidade, Produto produto, UnidadeEnsinoRefeicao refeicao) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
        this.refeicao = refeicao;
    }
}
