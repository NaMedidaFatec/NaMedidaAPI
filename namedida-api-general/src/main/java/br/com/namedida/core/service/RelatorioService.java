package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.domain.Relatorio;
import br.com.namedida.domain.Usuario;
import br.com.namedida.domain.enums.RelatorioStatus;
import br.com.namedida.domain.form.RelatorioForm;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RelatorioService extends GenericService<Relatorio> {
    private final StakeholdersBean stakeholdersBean;

    @Autowired
    public RelatorioService(
            GenericRepository<Relatorio> repository,
            List<IValidation<Relatorio>> saveValidations,
            List<IValidation<Relatorio>> updateValidation, StakeholdersBean stakeholdersBean)
    {
        super();
        this.stakeholdersBean = stakeholdersBean;
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public RelatorioService(StakeholdersBean stakeholdersBean) {
        this.stakeholdersBean = stakeholdersBean;
    }

    public Result save(RelatorioForm form) throws Exception {
        Usuario enviadoPor = stakeholdersBean.getUsuarioDepartamento() != null ? stakeholdersBean.getUsuarioDepartamento() : stakeholdersBean.getUsuarioUnidadeEnsino();

        Relatorio relatorio = Relatorio.relatorioBuilder()
                .dataDeEnvio(LocalDateTime.now())
                .nome(form.getNome())
                .unidadeEnsino(stakeholdersBean.getUnidadeEnsino())
                .enviadoPor(enviadoPor)
                .build();

        if (Strings.isNotBlank(form.getStatus())) {
            relatorio.setStatus(RelatorioStatus.valueOf(form.getStatus()));
        }
        this.executeRules(this.saveValidations, relatorio);

        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(relatorio));
        }
        return this.result;
    }
}