package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.validator.CidadeValidator;
import br.com.namedida.domain.*;
import br.com.namedida.domain.form.DepartamentoForm;
import br.com.namedida.domain.form.EnderecoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService extends GenericService<Departamento> {

    @Autowired
    public DepartamentoService(
            GenericRepository<Departamento> repository,
            List<IValidation<Departamento>> saveValidations,
            List<IValidation<Departamento>> updateValidation)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public DepartamentoService() {

    }

    public Result save(DepartamentoForm form) throws Exception {
        EnderecoForm departamentoEnderecoForm = form.getEnderecoForm();

        Departamento departamento = Departamento.builder()
                .nome(form.getNome())
                .email(form.getEmail())
                .cnpj(form.getCnpj())
                .razaoSocial(form.getRazaoSocial())
                .identificador(form.getIdentificador())
                .telefone(Telefone.telefoneBuilder()
                        .ddd(form.getTelefoneForm().getDdd())
                        .numero(form.getTelefoneForm().getNumero()).build())
                .endereco(Endereco.enderecoBuilder()
                        .numero(departamentoEnderecoForm.getNumero())
                        .logradouro(departamentoEnderecoForm.getLogradouro())
                        .complemento(departamentoEnderecoForm.getComplemento())
                        .bairro(departamentoEnderecoForm.getBairro())
                        .cidade(CidadeValidator.validate(departamentoEnderecoForm.getCidade()))
                        .cep(departamentoEnderecoForm.getCep()).build())
                .build();

        this.executeRules(this.saveValidations, departamento);

        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(departamento));
        }
        return this.result;
    }
}