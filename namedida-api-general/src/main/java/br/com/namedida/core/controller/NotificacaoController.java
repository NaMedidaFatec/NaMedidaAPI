package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.NotificacaoService;
import br.com.namedida.domain.Notificacao;
import br.com.namedida.domain.dto.ResponseDTO;
import br.com.namedida.domain.form.NotificacaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController extends GenericController<Notificacao> {
    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    public NotificacaoController(NotificacaoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(@RequestBody NotificacaoForm form) throws Exception {
        return notificacaoService.save(form);
    }

    @GetMapping("/me")
    public ResponseEntity<ResponseDTO> getAllMyNoticacoes() throws Exception {
        return this.generateResponse(notificacaoService.getAllMe(), HttpStatus.OK);
    }

    @PutMapping("/marcar-visto/{id}")
    public Result markSeen(@PathVariable Long id) throws Exception {
        return notificacaoService.markSeen(id);
    }
}
