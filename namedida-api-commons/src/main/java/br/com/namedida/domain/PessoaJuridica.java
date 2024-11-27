package br.com.namedida.domain;

import br.com.namedida.domain.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "base_pj")
@Entity
public class PessoaJuridica extends Pessoa  {
    private String razaoSocial;
    private String cnpj;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.PJ;

    @Builder(builderMethodName="pessoaJuridicaBuilder")
    public PessoaJuridica(String nome, String email, Telefone telefone, Endereco endereco, String razaoSocial, String cnpj) {
        super(nome, email, telefone, endereco);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.tipoPessoa = TipoPessoa.PJ;
    }
}