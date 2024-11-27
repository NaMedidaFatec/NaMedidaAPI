package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.persistence.RequisicaoItemRepository;
import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.core.validator.DepartamentoValidator;
import br.com.namedida.core.validator.ProdutoValidator;
import br.com.namedida.core.validator.RequisicaoValidator;
import br.com.namedida.core.validator.UnidadeEnsinoValidator;
import br.com.namedida.domain.RequisicaoItem;
import br.com.namedida.domain.form.RequisicaoItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RequisicaoItemService extends GenericService<RequisicaoItem> {
    private final RequisicaoItemRepository customRepository;

    @Autowired
    public RequisicaoItemService(
            RequisicaoItemRepository repository,
            List<IValidation<RequisicaoItem>> saveValidations,
            List<IValidation<RequisicaoItem>> updateValidation, StakeholdersBean stakeholdersBean)
    {
        super();
        this.repository = repository;
        this.customRepository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public Result save(RequisicaoItemForm form) throws Exception {
        RequisicaoItem requisicaoitem = RequisicaoItem.requisicaoitemItemBuilder()
                .id(form.getId())
                .quantidade(form.getQuantidade())
                .quantidadeEntregue(form.getQuantidadeEntregue())
                .produto(ProdutoValidator.validate(form.getProduto()))
                .requisicao(RequisicaoValidator.validate(form.getRequisicao()))
                .build();
        this.executeRules(this.saveValidations, requisicaoitem);
        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(requisicaoitem));
        }
        return this.result;
    }

    public Result getItens(Long requisicaoId) throws Exception {
        if (!this.result.hasErrors()) {
            this.result.setData(customRepository.findAllByRequisicao(RequisicaoValidator.validate(requisicaoId)));
        }
        return this.result;
    }
}