package br.com.namedida.domain.security;

import br.com.namedida.domain.Usuario;
import br.com.namedida.domain.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class UserAuthenticated implements UserDetails {
    @JsonIgnore
    public final Usuario user;

    public UserAuthenticated(Usuario user) {
        this.user = user;
    }

    public String getTipoUsuario() {
        return user.getTipoUsuario();
    }

    public Long getId() {
        return user.getId();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public Usuario getUsuario() {
        return user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
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
        return user.getEnabled();
    }
}
