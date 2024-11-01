package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.validator.CidadeValidator;
import br.com.namedida.core.validator.DepartamentoValidator;
import br.com.namedida.domain.*;
import br.com.namedida.domain.enums.NivelEnsino;
import br.com.namedida.domain.form.EnderecoForm;
import br.com.namedida.domain.form.ResponsavelForm;
import br.com.namedida.domain.form.UnidadeEnsinoForm;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeEnsinoService extends GenericService<UnidadeEnsino> {

    @Autowired
    public UnidadeEnsinoService(
            GenericRepository<UnidadeEnsino> repository,
            List<IValidation<UnidadeEnsino>> saveValidations,
            List<IValidation<UnidadeEnsino>> updateValidation)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public UnidadeEnsinoService() {

    }

    public Result save(UnidadeEnsinoForm form) throws Exception {
        ResponsavelForm responsavelForm = form.getResponsavelForm();
        EnderecoForm responsavelEnderecoForm = form.getResponsavelForm().getEnderecoForm();

        Responsavel responsavel = Responsavel.responsavelBuilder()
                .cargo(responsavelForm.getCargo())
                .setor(responsavelForm.getSetor())
                .rg(responsavelForm.getRg())
                .cpf(responsavelForm.getCpf())
                .apelido(responsavelForm.getApelido())
                .dataNascimento(responsavelForm.getDataNascimento())
                .nome(responsavelForm.getNome())
                .email(responsavelForm.getEmail())
                .telefone(Telefone.telefoneBuilder()
                        .ddd(responsavelForm.getTelefoneForm().getDdd())
                        .numero(responsavelForm.getTelefoneForm().getNumero()).build())
                .endereco(Endereco.enderecoBuilder()
                        .numero(responsavelEnderecoForm.getNumero())
                        .logradouro(responsavelEnderecoForm.getLogradouro())
                        .complemento(responsavelEnderecoForm.getComplemento())
                        .bairro(responsavelEnderecoForm.getBairro())
                        .cidade(CidadeValidator.validate(responsavelEnderecoForm.getCidade()))
                        .cep(responsavelEnderecoForm.getCep()).build())
                .build();

        if (Strings.isNotBlank(form.getNivelEnsino())) {
            responsavel.setEscolariade(NivelEnsino.valueOf(responsavelForm.getNivelEnsino()));
        }

        EnderecoForm unidadeEnsinoEnderecoForm = form.getEnderecoForm();
        UnidadeEnsino unidadeEnsino = UnidadeEnsino.unidadeensinoBuilder()
                .departamento(DepartamentoValidator.validate(form.getDepartamento()))
                .horarioAbertura(form.getHorarioAbertura())
                .horarioFechamento(form.getHorarioFechamento())
                .responsavel(responsavel)
                .qtdAlunosMatriculados(0)
                .qtdRefeicoes(0)
                .nome(form.getNome())
                .razaoSocial(form.getRazaoSocial())
                .cnpj(form.getCnpj())
                .email(form.getEmail())
                .nivelEnsino(NivelEnsino.valueOf(form.getNivelEnsino()))
                .telefone(Telefone.telefoneBuilder()
                        .ddd(form.getTelefoneForm().getDdd())
                        .numero(form.getTelefoneForm().getNumero()).build())
                .endereco(Endereco.enderecoBuilder()
                        .numero(unidadeEnsinoEnderecoForm.getNumero())
                        .logradouro(unidadeEnsinoEnderecoForm.getLogradouro())
                        .complemento(unidadeEnsinoEnderecoForm.getComplemento())
                        .bairro(unidadeEnsinoEnderecoForm.getBairro())
                        .cidade(CidadeValidator.validate(unidadeEnsinoEnderecoForm.getCidade()))
                        .cep(unidadeEnsinoEnderecoForm.getCep()).build())
                .build();

        if (Strings.isNotBlank(form.getNivelEnsino())) {
            unidadeEnsino.setNivelEnsino(NivelEnsino.valueOf(form.getNivelEnsino()));
        }

        this.executeRules(this.saveValidations, unidadeEnsino);

        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(unidadeEnsino));
        }
        return this.result;
    }
}