package br.com.namedida.core.validator;

import br.com.namedida.core.persistence.LoteRepository;
import br.com.namedida.domain.Lote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoteValidator {
    private static LoteRepository loteRepository;

    @Autowired
    public void setLoteRepository(LoteRepository repository) {
        LoteValidator.loteRepository = repository;
    }

    public static Lote validate(Long id) throws Exception {
        return loteRepository.
                findById(id).
                orElseThrow(() -> new Exception("Lote não encontrado"));
    }
}