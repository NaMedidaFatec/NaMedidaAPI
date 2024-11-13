package br.com.namedida.core.controller;

import br.com.namedida.core.service.UsuarioService;
import br.com.namedida.core.service.UsuarioUnidadeEnsinoService;
import br.com.namedida.domain.Usuario;
import br.com.namedida.domain.UsuarioUnidadeEnsino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/usuarioUnidadeEnsino")
public class UsuarioUnidadeEnsinoController extends GenericController<UsuarioUnidadeEnsino> {

    @Autowired
    public UsuarioUnidadeEnsinoController(UsuarioUnidadeEnsinoService service) {
        this.service = service;
    }
}
