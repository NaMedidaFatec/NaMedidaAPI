package br.com.namedida.domain;


import br.com.namedida.domain.enums.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "produto")
@Entity
public class Produto extends EntidadeDominio {
    @NotNull(message = "Nome  obrigatória")
    private String nome;
    private String descricao;
    private String codigoDeBarras;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JsonIgnore
    private Departamento departamento;

    @Builder(builderMethodName="produtoBuilder")
    public Produto(String nome, String descricao, String codigoDeBarras, Categoria categoria, Departamento departamento) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigoDeBarras = codigoDeBarras;
        this.categoria = categoria;
        this.departamento = departamento;
    }
}
