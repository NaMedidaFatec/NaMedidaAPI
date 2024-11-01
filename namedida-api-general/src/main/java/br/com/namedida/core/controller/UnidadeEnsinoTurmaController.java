package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.UnidadeEnsinoService;
import br.com.namedida.core.service.UnidadeEnsinoTurmaService;
import br.com.namedida.domain.UnidadeEnsinoTurma;
import br.com.namedida.domain.form.UnidadeEnsinoForm;
import br.com.namedida.domain.form.UnidadeEnsinoTurmaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/unidadeensinoturma")
public class UnidadeEnsinoTurmaController extends GenericController<UnidadeEnsinoTurma> {

    @Autowired
    private UnidadeEnsinoTurmaService unidadeEnsinoTurmaService;
    @Autowired
    public UnidadeEnsinoTurmaController(UnidadeEnsinoTurmaService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody UnidadeEnsinoTurmaForm form) throws Exception {
        return unidadeEnsinoTurmaService.save(form);
    }
}
