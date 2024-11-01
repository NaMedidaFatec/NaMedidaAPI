package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.RequisicaoSeparacaoItemService;
import br.com.namedida.domain.RequisicaoSeparacaoItem;
import br.com.namedida.domain.form.RequisicaoSeparacaoItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/requisicaoseparacaoitem")
public class RequisicaoSeparacaoItemController extends GenericController<RequisicaoSeparacaoItem> {
    @Autowired
    private RequisicaoSeparacaoItemService requisicaoService;

    @Autowired
    public RequisicaoSeparacaoItemController(RequisicaoSeparacaoItemService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody RequisicaoSeparacaoItemForm form) throws Exception {
        return requisicaoService.save(form);
    }
}
