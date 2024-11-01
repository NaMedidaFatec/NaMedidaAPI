package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.core.validator.LoteValidator;
import br.com.namedida.core.validator.ProdutoValidator;
import br.com.namedida.core.validator.RequisicaoItemValidator;
import br.com.namedida.core.validator.RequisicaoValidator;
import br.com.namedida.domain.RequisicaoSeparacaoItem;
import br.com.namedida.domain.form.RequisicaoSeparacaoItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisicaoSeparacaoItemService extends GenericService<RequisicaoSeparacaoItem> {

    private final StakeholdersBean stakeholdersBean;

    @Autowired
    public RequisicaoSeparacaoItemService(
            GenericRepository<RequisicaoSeparacaoItem> repository,
            List<IValidation<RequisicaoSeparacaoItem>> saveValidations,
            List<IValidation<RequisicaoSeparacaoItem>> updateValidation, StakeholdersBean stakeholdersBean)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
        this.stakeholdersBean = stakeholdersBean;
    }


    public Result save(RequisicaoSeparacaoItemForm form) throws Exception {
        RequisicaoSeparacaoItem requisicaoitem = RequisicaoSeparacaoItem.requisicaoSeparacaoItemBuilder()
//                .id(form.getId())
                .quantidade(form.getQuantidade())
                .quantidadeEntregue(form.getQuantidadeEntregue())
                .requisicaoItem(RequisicaoItemValidator.validate(form.getRequisicaoItem()))
                .estoque(LoteValidator.validate(form.getLote()))
                .build();

        this.executeRules(this.saveValidations, requisicaoitem);
        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(requisicaoitem));
        }
        return this.result;
    }
}