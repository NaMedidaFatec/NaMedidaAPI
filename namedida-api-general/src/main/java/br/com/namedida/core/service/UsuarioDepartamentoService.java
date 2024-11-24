package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.domain.UsuarioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioDepartamentoService extends GenericService<UsuarioDepartamento> {

    @Autowired
    public UsuarioDepartamentoService(
            GenericRepository<UsuarioDepartamento> repository,
            List<IValidation<UsuarioDepartamento>> saveValidations,
            List<IValidation<UsuarioDepartamento>> updateValidation)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public UsuarioDepartamentoService() {

    }
}