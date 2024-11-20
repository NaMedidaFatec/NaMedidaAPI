package br.com.namedida.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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

  @Transient
  public String getTelefoneCompleto() {
    return String.format("(%s) %s",
            ddd != null && !ddd.isEmpty() ? ddd : "",
            numero != null && !numero.isEmpty() ? String.format("%04d-%04d",
                    Integer.parseInt(numero.substring(0, 4)),
                    Integer.parseInt(numero.substring(4))
            ) : ""
    );
  }
}