package br.com.namedida.core.validator;

import br.com.namedida.core.persistence.CidadeRepository;
import br.com.namedida.domain.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeValidator {
    private static CidadeRepository cidadeRepository;

    @Autowired
    public void setCidadeRepository(CidadeRepository repository) {
        CidadeValidator.cidadeRepository = repository;
    }

    public static Cidade validate(Long id) throws Exception {
        return cidadeRepository.
                findById(id).
                orElseThrow(() -> new Exception("Cidade não encontrada"));
    }
}