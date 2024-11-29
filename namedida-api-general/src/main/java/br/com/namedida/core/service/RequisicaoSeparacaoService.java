package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.persistence.RequisicaoItemRepository;
import br.com.namedida.core.persistence.RequisicaoSeparacaoRepository;
import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.core.validator.RequisicaoValidator;
import br.com.namedida.domain.RequisicaoSeparacao;
import br.com.namedida.domain.Usuario;
import br.com.namedida.domain.form.RequisicaoSeparacaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RequisicaoSeparacaoService extends GenericService<RequisicaoSeparacao> {
    private final StakeholdersBean stakeholdersBean;
    private final RequisicaoSeparacaoRepository customRepository;
    private final NotificacaoService notificacaoService;

    @Autowired
    public RequisicaoSeparacaoService(
            RequisicaoSeparacaoRepository repository,
            List<IValidation<RequisicaoSeparacao>> saveValidations,
            List<IValidation<RequisicaoSeparacao>> updateValidation, StakeholdersBean stakeholdersBean, NotificacaoService notificacaoService)
    {
        super();
        this.customRepository = repository;
        this.notificacaoService = notificacaoService;
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
        this.stakeholdersBean = stakeholdersBean;
    }

    public Result save(RequisicaoSeparacaoForm form) throws Exception {
        Usuario separadoPor = stakeholdersBean.getUsuarioDepartamento() != null ? stakeholdersBean.getUsuarioDepartamento() : stakeholdersBean.getUsuarioUnidadeEnsino();

        RequisicaoSeparacao requisicaoSeparacao = RequisicaoSeparacao.requisicaoSeparacaoBuilder()
                .id(form.getId())
                .observacoes(form.getObservacoes())
                .data(form.getData())
                .finalizada(form.isFinalizada())
                .requisicao(RequisicaoValidator.validate(form.getRequisicao()))
                .separadoPor(separadoPor)
                .build();

        this.executeRules(this.saveValidations, requisicaoSeparacao);
        if (!this.result.hasErrors()) {
            requisicaoSeparacao = this.repository.save(requisicaoSeparacao);
            this.result.setData(requisicaoSeparacao);
        }

        if (requisicaoSeparacao != null) {
            notificacaoService.sendNotificacaoRequisicaoSeparacao(requisicaoSeparacao);
        }

        return this.result;
    }

    public Result getByRequisicao(Long requisicaoId) throws Exception {
        if (!this.result.hasErrors()) {
            this.result.setData(customRepository.findFirstByRequisicao(RequisicaoValidator.validate(requisicaoId)));
        }
        return this.result;
    }
}