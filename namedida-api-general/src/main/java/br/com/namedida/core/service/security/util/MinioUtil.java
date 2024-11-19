package br.com.namedida.core.service.security.util;

import br.com.namedida.core.persistence.UsuarioDepartamentoRepository;
import br.com.namedida.core.persistence.UsuarioUnidadeEnsinoRepository;
import br.com.namedida.domain.enums.TipoUsuario;
import br.com.namedida.domain.security.UserAuthenticated;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class MinioUtil {
    @Value("${minio.access.endpoint}")
    private String endpoint;

    @Value("${minio.access.accessKey}")
    private String accessKey;

    @Value("${minio.access.secretKey}")
    private String secretKey;

    public MinioClient generateMinioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}