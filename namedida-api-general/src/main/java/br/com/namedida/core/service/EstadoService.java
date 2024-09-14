package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.domain.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService extends GenericService<Estado> {

    @Autowired
    public EstadoService(
            GenericRepository<Estado> repository,
            List<IValidation<Estado>> saveValidations,
            List<IValidation<Estado>> updateValidation)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public EstadoService() {

    }
}