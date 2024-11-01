package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.RequisicaoSeparacaoService;
import br.com.namedida.domain.RequisicaoSeparacao;
import br.com.namedida.domain.form.RequisicaoSeparacaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/requisicaoseparacao")
public class RequisicaoSeparacaoController extends GenericController<RequisicaoSeparacao> {
    @Autowired
    private RequisicaoSeparacaoService requisicaoService;

    @Autowired
    public RequisicaoSeparacaoController(RequisicaoSeparacaoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody RequisicaoSeparacaoForm form) throws Exception {
        return requisicaoService.save(form);
    }
}
