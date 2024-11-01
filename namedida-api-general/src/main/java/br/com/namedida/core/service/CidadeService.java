package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.domain.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService extends GenericService<Cidade> {

    @Autowired
    public CidadeService(
            GenericRepository<Cidade> repository,
            List<IValidation<Cidade>> saveValidations,
            List<IValidation<Cidade>> updateValidation)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public CidadeService() {

    }
}