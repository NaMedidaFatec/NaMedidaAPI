package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.validator.ProdutoValidator;
import br.com.namedida.domain.Lote;
import br.com.namedida.domain.form.LoteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteService extends GenericService<Lote> {

    @Autowired
    public LoteService(
            GenericRepository<Lote> repository,
            List<IValidation<Lote>> saveValidations,
            List<IValidation<Lote>> updateValidation)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public LoteService() {

    }

    public Result save(LoteForm form) throws Exception {
        Lote lote = Lote.loteBuilder()
                .nome(form.getNome())
                .dataFabricacao(form.getDataFabricacao())
                .dataValidade(form.getDataFabricacao())
                .produto(ProdutoValidator.validate(form.getProduto()))
                .quantidade(form.getQuantidade())
                .build();

        this.executeRules(this.saveValidations, lote);
        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(lote));
        }
        return this.result;
    }
}