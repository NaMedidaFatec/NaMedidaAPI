package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.persistence.UsuarioUnidadeEnsinoRepository;
import br.com.namedida.core.persistence.UsuarioUnidadeEnsinoRepository;
import br.com.namedida.core.validator.DepartamentoValidator;
import br.com.namedida.core.validator.UnidadeEnsinoValidator;
import br.com.namedida.domain.Departamento;
import br.com.namedida.domain.UnidadeEnsino;
import br.com.namedida.domain.UsuarioUnidadeEnsino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUnidadeEnsinoService extends GenericService<UsuarioUnidadeEnsino> {
    private final UsuarioUnidadeEnsinoRepository customRepository;

    @Autowired
    public UsuarioUnidadeEnsinoService(
            UsuarioUnidadeEnsinoRepository customRepository,
            GenericRepository<UsuarioUnidadeEnsino> repository,
            List<IValidation<UsuarioUnidadeEnsino>> saveValidations,
            List<IValidation<UsuarioUnidadeEnsino>> updateValidation)
    {
        super();
        this.repository = repository;
        this.customRepository = customRepository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public UsuarioUnidadeEnsinoService(UsuarioUnidadeEnsinoRepository customRepository) {

        this.customRepository = customRepository;
    }

    public Result findAllByDepartamento(Long departamentoId) throws Exception {
        if (!this.result.hasErrors()) {
            Departamento departamento = DepartamentoValidator.validate(departamentoId);
            this.result.setData(customRepository.findAllByUnidadeEnsinoDepartamento(departamento));
        }
        return this.result;
    }
}