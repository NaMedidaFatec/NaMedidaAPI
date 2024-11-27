package br.com.namedida.domain.security;

import br.com.namedida.domain.Usuario;
import br.com.namedida.domain.UsuarioDepartamento;
import br.com.namedida.domain.UsuarioUnidadeEnsino;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class UserAuthenticated implements UserDetails {
    @JsonIgnore
    public Usuario user;
    public UsuarioDepartamento userDepartamento = null;
    public UsuarioUnidadeEnsino userUnidadeEnsino = null;

    public UserAuthenticated(UsuarioUnidadeEnsino user) {
        this.user = user;
        this.userUnidadeEnsino = user;
    }

    public UserAuthenticated(UsuarioDepartamento user) {
        this.user = user;
        this.userDepartamento = user;
    }

    public Usuario getUser() {
        if (userDepartamento != null) {
            return userDepartamento;
        }
        return userUnidadeEnsino;
    }

    public String getTipoUsuario() {
        return user.getTipoUsuario();
    }

    public Long getId() {
        return getUser().getId();
    }

    @Override
    public String getUsername() {
        return getUser().getEmail();
    }

    public String getEmail() {
        return getUser().getEmail();
    }

    @Override
    public String getPassword() {
        return getUser().getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "read");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getUser().getEnabled();
    }
}
