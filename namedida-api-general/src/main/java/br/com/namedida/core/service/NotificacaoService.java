package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.persistence.NotificacaoRepository;
import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.core.validator.ProdutoValidator;
import br.com.namedida.domain.*;
import br.com.namedida.domain.form.NotificacaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificacaoService extends GenericService<Notificacao> {
    private final NotificacaoRepository customRepository;
    private final StakeholdersBean stakeholdersBean;

    private final UsuarioDepartamentoService departamentoService;
    private final UsuarioUnidadeEnsinoService usuarioService;


    @Autowired
    public NotificacaoService(
            GenericRepository<Notificacao> repository,
            NotificacaoRepository customRepository,
            List<IValidation<Notificacao>> saveValidations,
            List<IValidation<Notificacao>> updateValidation, StakeholdersBean stakeholdersBean, UsuarioDepartamentoService departamentoService, UsuarioUnidadeEnsinoService usuarioService)
    {
        super();
        this.stakeholdersBean = stakeholdersBean;
        this.departamentoService = departamentoService;
        this.usuarioService = usuarioService;
        this.repository = repository;
        this.customRepository = customRepository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public Result save(NotificacaoForm form) throws Exception {
        Notificacao notificacao = Notificacao.notificacaoBuilder()
                .mensagem(form.getMensagem())
                .horario(form.getHorario())
                .visto(form.isVisto())
                .usuario(form.getUsuario())
                .build();

        this.executeRules(this.saveValidations, notificacao);
        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(notificacao));
        }
        return this.result;
    }

    public Result getAllMe() throws Exception {
        if (!this.result.hasErrors()) {
            this.result.setData(customRepository.findAllByUsuario(stakeholdersBean.getUsuarioUnidadeEnsino()));
        }
        return this.result;
    }

    public void sendNotificacaoRequisicao(Requisicao requisicao) throws Exception {
        Result result = departamentoService.findAllByDepartamento(stakeholdersBean.getDepartamento().getId());
        List<UsuarioDepartamento> usuarios = (List<UsuarioDepartamento>) result.getData();
        for (UsuarioDepartamento usuario : usuarios) {
            Notificacao notificacao = Notificacao.notificacaoBuilder()
                    .usuario(usuario)
                    .visto(false)
                    .mensagem("Solicitação de suprimentos " + requisicao.getId() + "realizada pela escola " + stakeholdersBean.getUsuarioUnidadeEnsino().getUnidadeEnsino().getNome() + ", solicitante: " +requisicao.getSolicitante().getNome())
                    .build();
            customRepository.save(notificacao);
        }
    }

    public void sendNotificacaoRequisicaoSeparacao(RequisicaoSeparacao requisicaoSeparacao) throws Exception {
        Result result = usuarioService.findAllByDepartamento(stakeholdersBean.getDepartamento().getId());
        List<UsuarioUnidadeEnsino> usuarios = (List<UsuarioUnidadeEnsino>) result.getData();
        for (UsuarioUnidadeEnsino usuario : usuarios) {
            Notificacao notificacao = Notificacao.notificacaoBuilder()
                    .usuario(usuario)
                    .visto(false)
                    .mensagem("Separação de suprimentos criada para o pedido " + requisicaoSeparacao.getRequisicao().getId() + "  por " + stakeholdersBean.getUsuarioDepartamento().getNome() + "responsável: " + requisicaoSeparacao.getSeparadoPor().getNome())
                    .build();
            customRepository.save(notificacao);
        }
    }


    public Result markSeen(Long id) throws Exception {
        Notificacao notificacao = customRepository.findById(id).orElse(null);
        if(notificacao != null){
            notificacao.setVisto(true);

            this.executeRules(this.saveValidations, notificacao);
            if (!this.result.hasErrors()) {
                this.result.setData(this.repository.save(notificacao));
            }
        }

        return this.result;
    }

}