package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.validator.UnidadeEnsinoValidator;
import br.com.namedida.domain.UnidadeEnsinoRefeicao;
import br.com.namedida.domain.form.UnidadeEnsinoRefeicaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeEnsinoRefeicaoService extends GenericService<UnidadeEnsinoRefeicao> {

    @Autowired
    public UnidadeEnsinoRefeicaoService(
            GenericRepository<UnidadeEnsinoRefeicao> repository,
            List<IValidation<UnidadeEnsinoRefeicao>> saveValidations,
            List<IValidation<UnidadeEnsinoRefeicao>> updateValidation)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public UnidadeEnsinoRefeicaoService() {

    }

    public Result save(UnidadeEnsinoRefeicaoForm form) throws Exception {
        UnidadeEnsinoRefeicao unidadeEnsinoRefeicao = UnidadeEnsinoRefeicao.unidadeensinorefeicaoBuilder()
                .nome(form.getNome())
                .descricao(form.getDescricao())
                .horarioDisponibilidade(form.getHorarioDisponibilidade())
                .unidadeEnsino(UnidadeEnsinoValidator.validate(form.getUnidadeEnsino()))
                .build();

        this.executeRules(this.saveValidations, unidadeEnsinoRefeicao);

        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(unidadeEnsinoRefeicao));
        }
        return this.result;
    }
    
}