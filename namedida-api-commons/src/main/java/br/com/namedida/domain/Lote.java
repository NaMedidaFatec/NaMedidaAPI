package br.com.namedida.domain;


import br.com.namedida.domain.deserializer.ProdutoDeserializer;
import br.com.namedida.domain.deserializer.UnidadeEnsinoDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "lote")
@Entity
public class Lote extends EntidadeDominio {

    @NotNull(message = "A identificação do Lote é obrigatória")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data de fabricação obrigatória")
    private LocalDate dataFabricacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data de vencimento obrigatória")
    private LocalDate dataValidade;

    private Double quantidade;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonDeserialize(using = ProdutoDeserializer.class)
    private Produto produto;

    @Builder(builderMethodName="loteBuilder")
    public Lote(String nome, LocalDate dataFabricacao, LocalDate dataValidade, Double quantidade, Produto produto) {
        this.nome = nome;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.quantidade = quantidade;
        this.produto = produto;
    }
}
