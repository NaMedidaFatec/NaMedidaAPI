package br.com.namedida.core.service.security.bean;

import br.com.namedida.domain.*;
import br.com.namedida.domain.security.UserAuthenticated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Getter
@Setter
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StakeholdersBean {
    private UsuarioDepartamento usuarioDepartamento;
    private UsuarioUnidadeEnsino usuarioUnidadeEnsino;

    public UnidadeEnsino getUnidadeEnsino() {
        return usuarioUnidadeEnsino.getUnidadeEnsino();
    }

    public Departamento getDepartamento() {
        if (usuarioDepartamento != null) {
            return usuarioDepartamento.getDepartamento();
        }
        return usuarioUnidadeEnsino.getUnidadeEnsino().getDepartamento();
    }
}
