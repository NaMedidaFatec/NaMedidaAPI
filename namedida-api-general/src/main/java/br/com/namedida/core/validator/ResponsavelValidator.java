package br.com.namedida.core.validator;

import br.com.namedida.core.persistence.ResponsavelRepository;
import br.com.namedida.domain.Responsavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponsavelValidator {
    private static ResponsavelRepository responsavelValidator;

    @Autowired
    public void setResponsavelRepository(ResponsavelRepository repository) {
        ResponsavelValidator.responsavelValidator = repository;
    }

    public static Responsavel validate(Long id) throws Exception {
        return responsavelValidator.
                findById(id).
                orElseThrow(() -> new Exception("Responsável não encontrado"));
    }
}
