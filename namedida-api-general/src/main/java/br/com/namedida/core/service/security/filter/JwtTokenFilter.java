package br.com.namedida.core.service.security.filter;

import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.core.service.security.util.JwtTokenUtil;
import br.com.namedida.domain.Usuario;
import br.com.namedida.domain.UsuarioDepartamento;
import br.com.namedida.domain.UsuarioUnidadeEnsino;
import br.com.namedida.domain.enums.TipoUsuario;
import br.com.namedida.domain.security.UserAuthenticated;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;

    private final StakeholdersBean stakeholdersBean;

    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil, StakeholdersBean stakeholdersBean) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.stakeholdersBean = stakeholdersBean;
    }

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        final String token = header.split(" ")[1].trim();
        var userAuthenticated = jwtTokenUtil.getUserDetailsFromToken(token);

        if (userAuthenticated.isEmpty()) {
            chain.doFilter(request, response);
            return;
        }

        UsuarioDepartamento usuarioDepartamento = null;
        UsuarioUnidadeEnsino usuarioUnidadeEnsino = null;
        if (userAuthenticated.get().getUser().getTipoUsuario().equals(TipoUsuario.DEPARTAMENTO)) {
            usuarioDepartamento = userAuthenticated.get().getUserDepartamento();
        } else {
            usuarioUnidadeEnsino = userAuthenticated.get().getUserUnidadeEnsino();
        }

        stakeholdersBean.setUsuarioDepartamento(usuarioDepartamento);
        stakeholdersBean.setUsuarioUnidadeEnsino(usuarioUnidadeEnsino);


        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(
                userAuthenticated.get(), null,
                userAuthenticated.get().getAuthorities()
        );

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
}