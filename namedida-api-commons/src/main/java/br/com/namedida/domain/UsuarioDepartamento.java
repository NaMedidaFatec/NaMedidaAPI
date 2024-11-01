package br.com.namedida.domain;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("departamento")
@Entity
public class UsuarioDepartamento extends Usuario {
    private static final long serialVersionUID = 1L;
    private String cargo;
    private String registro;

    @Builder(builderMethodName="usuarioDepartamentoBuilder")

    public UsuarioDepartamento(String nome, String cpf, LocalDate dataNascimento, String email, String username, String password, Endereco endereco, Telefone telefone, String tipoUsuario, String cargo, String registro) {
        super(nome, cpf, dataNascimento, email, username, password, endereco, telefone, tipoUsuario);
        this.cargo = cargo;
        this.registro = registro;
    }
}
