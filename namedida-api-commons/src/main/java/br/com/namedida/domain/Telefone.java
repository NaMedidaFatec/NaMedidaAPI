package br.com.namedida.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "telefone")
@Entity
public class Telefone extends EntidadeDominio {
  private String numero;
  private String ddd;

  @Builder(builderMethodName="telefoneBuilder")
  public Telefone(String numero, String ddd) {
    this.numero = numero;
    this.ddd = ddd;
  }
}