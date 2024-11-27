package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.persistence.NotificacaoRepository;
import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.core.validator.ProdutoValidator;
import br.com.namedida.domain.Notificacao;
import br.com.namedida.domain.Usuario;
import br.com.namedida.domain.form.NotificacaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacaoService extends GenericService<Notificacao> {
    private final NotificacaoRepository customRepository;
    private final StakeholdersBean stakeholdersBean;

    @Autowired
    public NotificacaoService(
            GenericRepository<Notificacao> repository,
            NotificacaoRepository customRepository,
            List<IValidation<Notificacao>> saveValidations,
            List<IValidation<Notificacao>> updateValidation, StakeholdersBean stakeholdersBean)
    {
        super();
        this.stakeholdersBean = stakeholdersBean;
        this.repository = repository;
        this.customRepository = customRepository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public Result save(NotificacaoForm form) throws Exception {
        Usuario usuario = stakeholdersBean.getUsuarioDepartamento() != null ? stakeholdersBean.getUsuarioDepartamento() : stakeholdersBean.getUsuarioUnidadeEnsino();
        Notificacao notificacao = Notificacao.notificacaoBuilder()
                .mensagem(form.getMensagem())
                .horario(LocalDateTime.now())
                .visto(false)
                .usuario(usuario)
                .build();

        this.executeRules(this.saveValidations, notificacao);
        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(notificacao));
        }
        return this.result;
    }

}