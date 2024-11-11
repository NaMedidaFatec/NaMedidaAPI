package br.com.namedida.domain;


import br.com.namedida.domain.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Formula;
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

    @JoinColumn(name = "unidadeEnsino_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private UnidadeEnsino unidadeEnsino;

    @Builder(builderMethodName="usuarioUnidadeEnsino")
    public UsuarioUnidadeEnsino(String nome, String cpf, LocalDate dataNascimento, String email, String username, String password, Endereco endereco, Telefone telefone, String setor, String cargo, String registro, UnidadeEnsino unidadeEnsino) {
        super(nome, cpf, dataNascimento, email, username, password, endereco, telefone, TipoUsuario.UNIDADE_ENSINO.name());
        this.setor = setor;
        this.cargo = cargo;
        this.registro = registro;
        this.unidadeEnsino = unidadeEnsino;
    }
}
