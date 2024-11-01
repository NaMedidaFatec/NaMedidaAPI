package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.EstadoService;
import br.com.namedida.core.service.UnidadeEnsinoService;
import br.com.namedida.domain.UnidadeEnsino;
import br.com.namedida.domain.form.UnidadeEnsinoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/unidadeensino")
public class UnidadeEnsinoController extends GenericController<UnidadeEnsino> {
    @Autowired
    private UnidadeEnsinoService unidadeEnsinoService;

    @Autowired
    public UnidadeEnsinoController(UnidadeEnsinoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody UnidadeEnsinoForm form) throws Exception {
        return unidadeEnsinoService.save(form);
    }
}
