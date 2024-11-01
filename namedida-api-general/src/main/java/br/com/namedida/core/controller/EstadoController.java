package br.com.namedida.core.controller;

import br.com.namedida.core.service.EstadoService;
import br.com.namedida.domain.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/estados")
public class EstadoController extends GenericController<Estado> {

    @Autowired
    public EstadoController(EstadoService service) {
        this.service = service;
    }
}
