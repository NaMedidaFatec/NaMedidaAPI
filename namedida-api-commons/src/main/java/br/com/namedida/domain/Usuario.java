package br.com.namedida.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "base")
@Entity
public class Usuario extends EntidadeDominio {
  private String nome;
  private String cpf;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataNascimento;

  @NotNull
  private String email;
  private String password;

  @JoinColumn(name = "endereco_id")
  @ManyToOne(cascade = CascadeType.ALL)
  private Endereco endereco;

  @JoinColumn(name = "telefone_id")
  @ManyToOne(cascade = CascadeType.ALL)
  private Telefone telefone;

  @Column(name = "discriminator", insertable = false, updatable = false)
  private String tipoUsuario;

  @Builder(builderMethodName="usuarioBuilder")
  public Usuario(String nome, String cpf, LocalDate dataNascimento, String email, String username, String password, Endereco endereco, Telefone telefone, String tipoUsuario) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.email = email;
    this.password = password;
    this.endereco = endereco;
    this.telefone = telefone;
    this.tipoUsuario = tipoUsuario;
  }
}