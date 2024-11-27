package br.com.namedida.core.persistence;

import br.com.namedida.domain.Notificacao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends GenericRepository<Notificacao> {
}
