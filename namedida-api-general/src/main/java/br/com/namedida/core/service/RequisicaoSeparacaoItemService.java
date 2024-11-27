package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.RequisicaoItemRepository;
import br.com.namedida.core.persistence.RequisicaoSeparacaoItemRepository;
import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.core.validator.LoteValidator;
import br.com.namedida.core.validator.RequisicaoItemValidator;
import br.com.namedida.domain.Lote;
import br.com.namedida.domain.RequisicaoItem;
import br.com.namedida.domain.RequisicaoSeparacaoItem;
import br.com.namedida.domain.form.RequisicaoSeparacaoItemForm;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisicaoSeparacaoItemService extends GenericService<RequisicaoSeparacaoItem> {
    private final RequisicaoSeparacaoItemRepository customRepository;
    private final LoteService loteService;
    private final RequisicaoItemRepository requisicaoItemRepository;

    @Autowired
    public RequisicaoSeparacaoItemService(
            RequisicaoSeparacaoItemRepository repository,
            List<IValidation<RequisicaoSeparacaoItem>> saveValidations,
            List<IValidation<RequisicaoSeparacaoItem>> updateValidation, StakeholdersBean stakeholdersBean, LoteService loteService, RequisicaoItemRepository requisicaoItemRepository, RequisicaoSeparacaoItemRepository requisicaoSeparacaoItemRepository)
    {
        super();
        this.loteService = loteService;
        this.requisicaoItemRepository = requisicaoItemRepository;
        this.repository = repository;
        this.customRepository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public Result save(RequisicaoSeparacaoItemForm form) throws Exception {
        RequisicaoSeparacaoItem requisicaoSeparacaoItem = RequisicaoSeparacaoItem.requisicaoSeparacaoItemBuilder()
                .quantidadeEntregue(form.getQuantidadeEntregue())
                .requisicaoItem(RequisicaoItemValidator.validate(form.getRequisicaoItem()))
                .estoque(LoteValidator.validate(form.getEstoque()))
                .build();

        this.executeRules(this.saveValidations, requisicaoSeparacaoItem);
        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(requisicaoSeparacaoItem));
            movimentarEstoque(requisicaoSeparacaoItem);
            movimentarRequisaoItem(requisicaoSeparacaoItem);
        }


        return this.result;
    }

    public Result updateItem(RequisicaoSeparacaoItem requisicaoSeparacaoItem, Long id)  {
        this.result = new Result();
        this.executeRules(this.saveValidations, requisicaoSeparacaoItem);
        if (!this.result.hasErrors()) {
            RequisicaoSeparacaoItem requisicaoSeparacaoItemOld = new RequisicaoSeparacaoItem();
            BeanUtils.copyProperties(this.repository.findById(id).get(), requisicaoSeparacaoItemOld);
            update(requisicaoSeparacaoItem, id);
            RequisicaoSeparacaoItem requisicaoSeparacaoItemNew = (RequisicaoSeparacaoItem) this.result.getData();

            requisicaoSeparacaoItemNew = movimentarEstoqueUpdate(requisicaoSeparacaoItemOld, requisicaoSeparacaoItemNew);
            requisicaoSeparacaoItemNew = movimentarRequisaoUpdateItem(requisicaoSeparacaoItemOld, requisicaoSeparacaoItemNew);
            this.result.setData(requisicaoSeparacaoItemNew);
        }
        return this.result;
    }


    public RequisicaoSeparacaoItem movimentarRequisaoUpdateItem(RequisicaoSeparacaoItem requisicaoSeparacaoItemOld, RequisicaoSeparacaoItem requisicaoSeparacaoItemNew) {
        RequisicaoItem requisicaoItem = requisicaoSeparacaoItemNew.getRequisicaoItem();
        Double quantidadeMovimentada =  requisicaoSeparacaoItemNew.getQuantidadeEntregue() - requisicaoSeparacaoItemOld.getQuantidadeEntregue();
        requisicaoItem.setQuantidadeEntregue(requisicaoItem.getQuantidadeEntregue() + quantidadeMovimentada);
        requisicaoItemRepository.save(requisicaoItem);
        return requisicaoSeparacaoItemNew;
    }

    public RequisicaoSeparacaoItem movimentarEstoqueUpdate(RequisicaoSeparacaoItem requisicaoSeparacaoItemOld, RequisicaoSeparacaoItem requisicaoSeparacaoItemNew) {
        Lote lote = requisicaoSeparacaoItemNew.getEstoque();
        Double quantidadeMovimentada = requisicaoSeparacaoItemOld.getQuantidadeEntregue() - requisicaoSeparacaoItemNew.getQuantidadeEntregue();
        lote.setQuantidade(lote.getQuantidade() + quantidadeMovimentada);
        loteService.save(lote);
        return requisicaoSeparacaoItemNew;
    }


    public Result deleteItem(Long id) {
        this.result = new Result();
        this.executeRules(this.deleteValidations, this.repository.findById(id).get());
        if (!this.result.hasErrors()) {
            delete(id);
            RequisicaoSeparacaoItem requisicaoSeparacaoItem = this.repository.findById(id).orElseThrow();
            requisicaoSeparacaoItem = movimentarEstoqueDelete(requisicaoSeparacaoItem);
            requisicaoSeparacaoItem = movimentarRequisaoDeleteItem(requisicaoSeparacaoItem);
            this.result.setData(requisicaoSeparacaoItem);
        }
        return this.result;
    }


    public RequisicaoSeparacaoItem movimentarRequisaoDeleteItem(RequisicaoSeparacaoItem requisicaoSeparacaoItem)  {
        RequisicaoItem requisicaoItem = requisicaoSeparacaoItem.getRequisicaoItem();
        requisicaoItem.setQuantidadeEntregue(requisicaoItem.getQuantidadeEntregue() - requisicaoSeparacaoItem.getQuantidadeEntregue());
        requisicaoItemRepository.save(requisicaoItem);
        return requisicaoSeparacaoItem;
    }

    public  RequisicaoSeparacaoItem movimentarEstoqueDelete(RequisicaoSeparacaoItem requisicaoSeparacaoItem) {
        Lote lote = requisicaoSeparacaoItem.getEstoque();
        lote.setQuantidade(lote.getQuantidade() + requisicaoSeparacaoItem.getQuantidadeEntregue());
        loteService.save(lote);
        return requisicaoSeparacaoItem;
    }

    public void movimentarRequisaoItem(RequisicaoSeparacaoItem requisicaoSeparacaoItem) throws Exception {
        RequisicaoItem requisicaoItem = requisicaoSeparacaoItem.getRequisicaoItem();
        requisicaoItem.setQuantidadeEntregue(requisicaoItem.getQuantidadeEntregue() + requisicaoSeparacaoItem.getQuantidadeEntregue());
        requisicaoItemRepository.save(requisicaoItem);
    }

    public void movimentarEstoque(RequisicaoSeparacaoItem requisicaoSeparacaoItem) throws Exception {
        Lote lote = requisicaoSeparacaoItem.getEstoque();
        lote.setQuantidade(lote.getQuantidade() - requisicaoSeparacaoItem.getQuantidadeEntregue());
        loteService.save(lote);
    }

    public Result getSeparacoesItem(Long requisicaoItemId) throws Exception {
        this.result = new Result();
        this.result.setData(customRepository.findAllByRequisicaoItemAndEnabled(RequisicaoItemValidator.validate(requisicaoItemId), true));
        return this.result;
    }
}