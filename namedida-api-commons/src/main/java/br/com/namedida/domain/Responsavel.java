package br.com.namedida.domain;

import br.com.namedida.domain.enums.NivelEnsino;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("responsavel")
@Entity
public class Responsavel extends PessoaFisica {
  private String cargo;
  private String setor;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "varchar(255) default 'SUPERIOR'")
  private NivelEnsino escolariade;

  @Builder(builderMethodName="responsavelBuilder")

  public Responsavel(String nome, String email, Telefone telefone, Endereco endereco, String rg, String cpf, String apelido, LocalDate dataNascimento, String cargo, String setor, NivelEnsino escolariade) {
    super(nome, email, telefone, endereco, rg, cpf, apelido, dataNascimento);
    this.cargo = cargo;
    this.setor = setor;
    this.escolariade = escolariade;
  }
}