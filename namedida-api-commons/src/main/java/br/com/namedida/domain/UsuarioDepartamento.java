package br.com.namedida.domain;

import br.com.namedida.domain.enums.TipoUsuario;
import jakarta.persistence.*;
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

    @JoinColumn(name = "departamento_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Departamento departamento;

    @Builder(builderMethodName="usuarioDepartamentoBuilder")
    public UsuarioDepartamento(String nome, String cpf, LocalDate dataNascimento, String email, String username, String password, Endereco endereco, Telefone telefone, String cargo, String registro, Departamento departamento) {
        super(nome, cpf, dataNascimento, email, username, password, endereco, telefone, TipoUsuario.DEPARTAMENTO.name());
        this.cargo = cargo;
        this.registro = registro;
        this.departamento = departamento;
    }
}
