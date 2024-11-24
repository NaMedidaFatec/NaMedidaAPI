package br.com.namedida.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "base")
@Entity
public class Pessoa extends EntidadeDominio {
    private String nome;
    private String email;

    @JoinColumn(name = "telefone_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Telefone telefone;

    @JoinColumn(name = "endereco_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @Builder(builderMethodName="pessoaBuilder")
    public Pessoa(String nome, String email, Telefone telefone, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}