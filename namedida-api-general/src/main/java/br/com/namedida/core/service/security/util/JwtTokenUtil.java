package br.com.namedida.core.service.security.util;

import br.com.namedida.core.persistence.UsuarioDepartamentoRepository;
import br.com.namedida.core.persistence.UsuarioUnidadeEnsinoRepository;
import br.com.namedida.domain.enums.TipoUsuario;
import br.com.namedida.domain.security.UserAuthenticated;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtTokenUtil {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Autowired
    private UsuarioDepartamentoRepository usuarioRepository;
    @Autowired
    private UsuarioDepartamentoRepository usuarioDepartamentoRepository;
    @Autowired
    private UsuarioUnidadeEnsinoRepository usuarioUnidadeEnsinoRepository;

    public String generateJwtToken(UserAuthenticated user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("tipoUsuario", user.getTipoUsuario());

        claims.put("authorities", user.getAuthorities());

        return Jwts.builder().setClaims(claims).setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 72000 * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public Optional<UserAuthenticated> getUserDetailsFromToken(String token) {
        final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        boolean valid = !claims.getExpiration().before(new Date());

        if(!valid) {
            return Optional.empty();
        }

        UserAuthenticated usuario = null;
        Long id = claims.get("id", Long.class);
        String email = claims.get("email", String.class);
        String tipoUsuario = claims.get("tipoUsuario", String.class);

        if (tipoUsuario.equalsIgnoreCase(TipoUsuario.DEPARTAMENTO.name())) {
            usuario = usuarioDepartamentoRepository.findById(id)
                    .map(UserAuthenticated::new)
                    .orElseThrow(
                            () -> new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email));
        } else {
            usuario = usuarioUnidadeEnsinoRepository.findById(id)
                    .map(UserAuthenticated::new)
                    .orElseThrow(
                            () -> new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email));
        }

        return Optional.of(usuario);
    }
}