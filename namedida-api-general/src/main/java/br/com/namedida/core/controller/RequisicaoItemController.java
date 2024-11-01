package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.RequisicaoItemService;
import br.com.namedida.domain.RequisicaoItem;
import br.com.namedida.domain.form.RequisicaoItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/requisicaoitem")
public class RequisicaoItemController extends GenericController<RequisicaoItem> {
    @Autowired
    private RequisicaoItemService requisicaoService;

    @Autowired
    public RequisicaoItemController(RequisicaoItemService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody RequisicaoItemForm form) throws Exception {
        return requisicaoService.save(form);
    }
}
