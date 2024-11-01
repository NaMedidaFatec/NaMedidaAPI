package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.validator.UnidadeEnsinoValidator;
import br.com.namedida.domain.*;
import br.com.namedida.domain.form.UnidadeEnsinoTurmaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeEnsinoTurmaService extends GenericService<UnidadeEnsinoTurma> {

    @Autowired
    public UnidadeEnsinoTurmaService(
            GenericRepository<UnidadeEnsinoTurma> repository,
            List<IValidation<UnidadeEnsinoTurma>> saveValidations,
            List<IValidation<UnidadeEnsinoTurma>> updateValidation)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public UnidadeEnsinoTurmaService() {

    }

    public Result save(UnidadeEnsinoTurmaForm form) throws Exception {
        UnidadeEnsinoTurma unidadeEnsinoTurma = UnidadeEnsinoTurma.unidadeensinoturmaBuilder()
                .nome(form.getNome())
                .quantidade(form.getQuantidade())
                .horarioInicial(form.getHorarioInicial())
                .horarioFinal(form.getHorarioFinal())
                .sala(form.getSala())
                .quantidade(form.getQuantidade())
                .unidadeEnsino(UnidadeEnsinoValidator.validate(form.getUnidadeEnsino()))
                .build();

        this.executeRules(this.saveValidations, unidadeEnsinoTurma);

        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(unidadeEnsinoTurma));
        }
        return this.result;
    }
}