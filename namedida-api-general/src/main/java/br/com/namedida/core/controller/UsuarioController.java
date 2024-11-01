package br.com.namedida.core.controller;

import br.com.namedida.core.service.UsuarioService;
import br.com.namedida.domain.Usuario;
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
@RequestMapping("/usuarios")
public class UsuarioController extends GenericController<Usuario> {

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
}
