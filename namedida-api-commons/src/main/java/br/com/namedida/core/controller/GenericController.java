package br.com.namedida.core.controller;

import br.com.namedida.domain.dto.ResponseDTO;
import br.com.namedida.core.business.BusinessError;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.GenericService;
import br.com.namedida.domain.EntidadeDominio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

public abstract class GenericController<T extends EntidadeDominio> {
    protected GenericService service;

    @GetMapping
    public ResponseEntity<ResponseDTO> listEntity() {
        try {
            return this.generateResponse(service.findAll(), HttpStatus.OK);
        } catch (Exception e) {

        }
        return null;
    }

    @GetMapping("/enabled/{enabled}")
    public ResponseEntity<ResponseDTO> listAllEntity(@PathVariable boolean enabled) {
        try {
            return this.generateResponse(service.findAllEnabled(enabled), HttpStatus.OK);
        } catch (Exception e) {

        }
        return null;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findEntity(@PathVariable Long id) {
        try {
            return this.generateResponse(service.findOne(id), HttpStatus.OK);
        } catch (Exception e) {

        }
        return null;
    }

    @PutMapping("/toggle/{id}")
    public ResponseEntity<ResponseDTO> toggleEnabledEntity(@PathVariable Long id) {
        try {
            return this.generateResponse(service.toggleEnabledEntity(id), HttpStatus.OK);
        } catch (Exception e) {

        }
        return null;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> save(@Valid @RequestBody T entity) {
        try {
            return this.generateResponse(service.save(entity), HttpStatus.CREATED);
        } catch (Exception e) {

        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @Valid @RequestBody T entity) {
        try {
            return this.generateResponse(service.update(entity, id), HttpStatus.OK);
        } catch (Exception e) {

        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id) {
        try {
            return this.generateResponse(service.delete(id), HttpStatus.OK);
        } catch (Exception e) {
        }
        return null;

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Result result = new Result();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            result.addError(new BusinessError(error.getDefaultMessage()));
        });

        return this.generateResponse(result, null);
    }

    protected ResponseEntity<ResponseDTO> generateResponse(Result result, HttpStatus status) {
        ResponseDTO dto = new ResponseDTO();
        if (result.hasErrors()) {
            dto.businessErrorResponse(result);
            return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        }

        dto.successResponse(result);
        return new ResponseEntity<>(dto, status);
    }
}
