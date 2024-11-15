package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
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

    @Autowired
    public RequisicaoSeparacaoService(
            GenericRepository<RequisicaoSeparacao> repository,
            List<IValidation<RequisicaoSeparacao>> saveValidations,
            List<IValidation<RequisicaoSeparacao>> updateValidation, StakeholdersBean stakeholdersBean)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
        this.stakeholdersBean = stakeholdersBean;
    }


    public Result save(RequisicaoSeparacaoForm form) throws Exception {
        Usuario separadoPor = stakeholdersBean.getUsuarioDepartamento() != null ? stakeholdersBean.getUsuarioDepartamento() : stakeholdersBean.getUsuarioUnidadeEnsino();

        RequisicaoSeparacao requisicao = RequisicaoSeparacao.requisicaoSeparacaoBuilder()
                .id(form.getId())
                .observacoes(form.getObservacoes())
                .data(LocalDate.now())
                .finalizada(form.isFinalizada())
                .requisicao(RequisicaoValidator.validate(form.getRequisicao()))
                .separadoPor(separadoPor)
                .build();

        this.executeRules(this.saveValidations, requisicao);
        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(requisicao));
        }
        return this.result;
    }
}