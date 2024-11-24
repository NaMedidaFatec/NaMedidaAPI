package br.com.namedida.domain;

import br.com.namedida.domain.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "base_pf")
@Entity
public class PessoaFisica extends Pessoa  {
    private String rg;
    private String cpf;
    private String apelido;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.PF;

    @Builder(builderMethodName="pessoaFisicaBuilder")
    public PessoaFisica(String nome, String email, Telefone telefone, Endereco endereco, String rg, String cpf, String apelido, LocalDate dataNascimento) {
        super(nome, email, telefone, endereco);
        this.rg = rg;
        this.cpf = cpf;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.tipoPessoa = TipoPessoa.PF;
    }
}