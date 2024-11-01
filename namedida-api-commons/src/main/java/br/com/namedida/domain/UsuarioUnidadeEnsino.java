package br.com.namedida.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("unidadeensino")
@Entity
public class UsuarioUnidadeEnsino extends Usuario {
    private static final long serialVersionUID = 1L;

    private String setor;
    private String cargo;
    private String registro;

    @Builder(builderMethodName="usuarioUnidadeEnsino")
    public UsuarioUnidadeEnsino(String nome, String cpf, LocalDate dataNascimento, String email, String username, String password, Endereco endereco, Telefone telefone, String tipoUsuario, String setor, String cargo, String registro) {
        super(nome, cpf, dataNascimento, email, username, password, endereco, telefone, tipoUsuario);
        this.setor = setor;
        this.cargo = cargo;
        this.registro = registro;
    }
}
