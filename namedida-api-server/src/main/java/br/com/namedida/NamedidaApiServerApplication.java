package br.com.namedida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EntityScan({ "br.com.namedida" })
@SpringBootApplication(scanBasePackages = "br.com.namedida")
@EnableJpaAuditing
public class NamedidaApiServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NamedidaApiServerApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
