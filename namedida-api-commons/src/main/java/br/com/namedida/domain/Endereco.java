package br.com.namedida.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "endereco")
@Entity
public class Endereco extends EntidadeDominio {
  private String numero;
  private String logradouro;
  private String complemento;
  private String bairro;
  private String cep;

  @ManyToOne
  private Cidade cidade;

  @Builder(builderMethodName="enderecoBuilder")
  public Endereco(String numero, String logradouro, String complemento, String bairro, String cep, Cidade cidade) {
    this.numero = numero;
    this.logradouro = logradouro;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cep = cep;
    this.cidade = cidade;
  }
}