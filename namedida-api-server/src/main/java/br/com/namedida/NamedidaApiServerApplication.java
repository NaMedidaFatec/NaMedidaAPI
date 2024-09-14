package br.com.namedida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EntityScan({ "br.com.namedida" })
@SpringBootApplication
@EnableJpaAuditing
public class NamedidaApiServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NamedidaApiServerApplication.class, args);
    }

}
