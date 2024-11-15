package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.RelatorioService;
import br.com.namedida.domain.Relatorio;
import br.com.namedida.domain.form.RelatorioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/relatorio")
public class RelatorioController extends GenericController<Relatorio> {

    @Autowired
    private RelatorioService relatorioService;
    @Autowired
    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody RelatorioForm form) throws Exception {
        return relatorioService.save(form);
    }
}
