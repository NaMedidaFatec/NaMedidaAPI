package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.UnidadeEnsinoRefeicaoItemRepository;
import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.core.validator.ProdutoValidator;
import br.com.namedida.core.validator.UnidadeEnsinoRefeicaoValidator;
import br.com.namedida.domain.UnidadeEnsinoRefeicaoItem;
import br.com.namedida.domain.form.UnidadeEnsinoRefeicaoItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefeicaoItemService extends GenericService<UnidadeEnsinoRefeicaoItem> {
    private final UnidadeEnsinoRefeicaoItemRepository customRepository;

    @Autowired
    public RefeicaoItemService(
            UnidadeEnsinoRefeicaoItemRepository repository,
            List<IValidation<UnidadeEnsinoRefeicaoItem>> saveValidations,
            List<IValidation<UnidadeEnsinoRefeicaoItem>> updateValidation, StakeholdersBean stakeholdersBean)
    {
        super();
        this.repository = repository;
        this.customRepository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public Result save(UnidadeEnsinoRefeicaoItemForm form) throws Exception {
        UnidadeEnsinoRefeicaoItem requisicaoitem = UnidadeEnsinoRefeicaoItem.refeicaoItemBuilder()
                .quantidade(form.getQuantidade())
                .produto(ProdutoValidator.validate(form.getProduto()))
                .refeicao(UnidadeEnsinoRefeicaoValidator.validate(form.getRefeicao()))
                .build();
        this.executeRules(this.saveValidations, requisicaoitem);
        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(requisicaoitem));
        }
        return this.result;
    }

    public Result getItens(Long refeicaoId) throws Exception {
        if (!this.result.hasErrors()) {
            this.result.setData(customRepository.findAllByRefeicao(UnidadeEnsinoRefeicaoValidator.validate(refeicaoId)));
        }
        return this.result;
    }
}