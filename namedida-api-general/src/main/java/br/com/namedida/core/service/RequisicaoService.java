package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.core.validator.DepartamentoValidator;
import br.com.namedida.core.validator.UnidadeEnsinoValidator;
import br.com.namedida.domain.Departamento;
import br.com.namedida.domain.Requisicao;
import br.com.namedida.domain.UnidadeEnsino;
import br.com.namedida.domain.Usuario;
import br.com.namedida.domain.enums.Categoria;
import br.com.namedida.domain.form.RequisicaoForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RequisicaoService extends GenericService<Requisicao> {
    private final StakeholdersBean stakeholdersBean;

    @Autowired
    public RequisicaoService(
            GenericRepository<Requisicao> repository,
            List<IValidation<Requisicao>> saveValidations,
            List<IValidation<Requisicao>> updateValidation, StakeholdersBean stakeholdersBean)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
        this.stakeholdersBean = stakeholdersBean;
    }

    public Result save(RequisicaoForm form) throws Exception {
        Usuario solicitante = stakeholdersBean.getUsuarioDepartamento() != null ? stakeholdersBean.getUsuarioDepartamento() : stakeholdersBean.getUsuarioUnidadeEnsino();
        Requisicao requisicao = Requisicao.requisicaoBuilder()
                .id(form.getId())
                .observacoes(form.getObservacoes())
                .data(LocalDate.now())
                .finalizada(form.isFinalizada())
                .departamento(DepartamentoValidator.validate(form.getDepartamento()))
                .unidadeEnsino(UnidadeEnsinoValidator.validate(form.getUnidadeEnsino()))
                .solicitante(solicitante)
                .build();

        this.executeRules(this.saveValidations, requisicao);
        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(requisicao));
        }
        return this.result;
    }
}