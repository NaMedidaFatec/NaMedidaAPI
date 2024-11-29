package br.com.namedida.domain;


import br.com.namedida.domain.enums.NivelEnsino;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("unidadeensino")
@Entity
public class UnidadeEnsino extends PessoaJuridica {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Departamento departamento;

    @NotNull(message = "Identificação do departamento")
    private LocalTime horarioAbertura;
    private LocalTime horarioFechamento;

    @Formula("(SELECT getQtdAlunosMatriculados(id))")
    private Integer qtdAlunosMatriculados = 0;

    @Formula("(SELECT getRefeicoesUnidade(id))")
    private Integer qtdRefeicoes = 0;

    @Formula("(SELECT getQtdRelatoriosEntregues(id))")
    private Integer qtdRelatoriosEntregues = 0;

    @Enumerated(EnumType.STRING)
    private NivelEnsino nivelEnsino;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "responsavel_id")
    private Responsavel responsavel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeEnsino", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<UnidadeEnsinoRefeicao> refeicoes = new ArrayList<UnidadeEnsinoRefeicao>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeEnsino", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<UnidadeEnsinoTurma> unidadeEnsinoTurmas = new ArrayList<UnidadeEnsinoTurma>();

    private String cie;

    @Builder(builderMethodName="unidadeensinoBuilder")
    public UnidadeEnsino(String nome, String email, Telefone telefone, Endereco endereco, String razaoSocial, String cnpj, Departamento departamento, LocalTime horarioAbertura, LocalTime horarioFechamento, Integer qtdAlunosMatriculados, Integer qtdRefeicoes, NivelEnsino nivelEnsino, Responsavel responsavel, Collection<UnidadeEnsinoRefeicao> refeicoes, Collection<UnidadeEnsinoTurma> unidadeEnsinoTurmas, String cie) {
        super(nome, email, telefone, endereco, razaoSocial, cnpj);
        this.departamento = departamento;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.qtdAlunosMatriculados = qtdAlunosMatriculados;
        this.qtdRefeicoes = qtdRefeicoes;
        this.nivelEnsino = nivelEnsino;
        this.responsavel = responsavel;
        this.refeicoes = refeicoes;
        this.unidadeEnsinoTurmas = unidadeEnsinoTurmas;
        this.cie = cie;
    }
}
