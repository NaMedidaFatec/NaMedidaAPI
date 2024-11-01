package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.DepartamentoService;
import br.com.namedida.domain.Departamento;
import br.com.namedida.domain.form.DepartamentoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/departamento")
public class DepartamentoController extends GenericController<Departamento> {

    @Autowired
    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping("/save")
    public Result save(
            @RequestBody DepartamentoForm form) throws Exception {
        return departamentoService.save(form);
    }
}
