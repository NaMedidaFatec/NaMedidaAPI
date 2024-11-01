package br.com.namedida.core.validator;

import br.com.namedida.core.persistence.DepartamentoRepository;
import br.com.namedida.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoValidator {
    private static DepartamentoRepository departamentoRepository;

    @Autowired
    public void setDepartamentoRepository(DepartamentoRepository repository) {
        DepartamentoValidator.departamentoRepository = repository;
    }

    public static Departamento validate(Long id) throws Exception {
        return departamentoRepository.
                findById(id).
                orElseThrow(() -> new Exception("Departamento não encontrado"));
    }
}