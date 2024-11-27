package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.domain.Responsavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService extends GenericService<Responsavel> {
    @Autowired
    public ResponsavelService(
            GenericRepository<Responsavel> repository,
            List<IValidation<Responsavel>> saveValidations,
            List<IValidation<Responsavel>> updateValidation)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public Result save(String nomeResponsavel) throws Exception {
        Responsavel responsavel = new Responsavel();

        responsavel.setNome(nomeResponsavel);

        this.executeRules(this.saveValidations, responsavel);

        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(responsavel));
        }
        return this.result;
    }

}
