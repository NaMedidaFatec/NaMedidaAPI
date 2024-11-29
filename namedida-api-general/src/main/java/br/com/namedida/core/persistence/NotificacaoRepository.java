package br.com.namedida.core.persistence;

import br.com.namedida.domain.Notificacao;
import br.com.namedida.domain.Relatorio;
import br.com.namedida.domain.UnidadeEnsino;
import br.com.namedida.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends GenericRepository<Notificacao> {
    List<Notificacao> findAllByUsuario(Usuario usuario);
}
