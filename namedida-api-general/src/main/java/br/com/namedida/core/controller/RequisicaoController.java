package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.RequisicaoService;
import br.com.namedida.domain.Requisicao;
import br.com.namedida.domain.form.RequisicaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/requisicao")
public class RequisicaoController extends GenericController<Requisicao> {
    @Autowired
    private RequisicaoService requisicaoService;

    @Autowired
    public RequisicaoController(RequisicaoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody RequisicaoForm form) throws Exception {
        return requisicaoService.save(form);
    }
}
