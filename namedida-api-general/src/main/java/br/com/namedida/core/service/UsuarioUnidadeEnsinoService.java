package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.domain.UsuarioUnidadeEnsino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUnidadeEnsinoService extends GenericService<UsuarioUnidadeEnsino> {

    @Autowired
    public UsuarioUnidadeEnsinoService(
            GenericRepository<UsuarioUnidadeEnsino> repository,
            List<IValidation<UsuarioUnidadeEnsino>> saveValidations,
            List<IValidation<UsuarioUnidadeEnsino>> updateValidation)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public UsuarioUnidadeEnsinoService() {

    }
}