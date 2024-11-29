package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.persistence.RelatorioRepository;
import br.com.namedida.core.persistence.UsuarioDepartamentoRepository;
import br.com.namedida.core.validator.DepartamentoValidator;
import br.com.namedida.core.validator.RequisicaoValidator;
import br.com.namedida.domain.Departamento;
import br.com.namedida.domain.UsuarioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioDepartamentoService extends GenericService<UsuarioDepartamento> {
    private final UsuarioDepartamentoRepository customRepository;

    @Autowired
    public UsuarioDepartamentoService(
            GenericRepository<UsuarioDepartamento> repository,
            UsuarioDepartamentoRepository customRepository,
            List<IValidation<UsuarioDepartamento>> saveValidations,
            List<IValidation<UsuarioDepartamento>> updateValidation)
    {
        super();
        this.repository = repository;
        this.customRepository = customRepository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public UsuarioDepartamentoService(UsuarioDepartamentoRepository customRepository) {
        this.customRepository = customRepository;
    }


    public Result findAllByDepartamento(Long departamentoId) throws Exception {
        if (!this.result.hasErrors()) {
            this.result.setData(customRepository.findAllByDepartamento(DepartamentoValidator.validate(departamentoId)));
        }
        return this.result;
    }
}