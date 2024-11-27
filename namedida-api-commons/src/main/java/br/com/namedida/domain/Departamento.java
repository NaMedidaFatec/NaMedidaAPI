package br.com.namedida.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("departamento")
@Entity
public class Departamento extends PessoaJuridica {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Identificação do departamento")
    private String identificador;

    @JsonIgnoreProperties({"departamento"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<UnidadeEnsino> escolas = new ArrayList<UnidadeEnsino>();

    @Builder
    public Departamento(String nome, String email, Telefone telefone, Endereco endereco, String razaoSocial, String cnpj, String identificador, Collection<UnidadeEnsino> escolas) {
        super(nome, email, telefone, endereco, razaoSocial, cnpj);
        this.identificador = identificador;
        this.escolas = escolas;
    }
}
