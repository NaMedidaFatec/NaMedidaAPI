package br.com.namedida.domain.form;

import br.com.namedida.domain.Usuario;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RelatorioForm {
        private String nome;
        private LocalDateTime dataDeEnvio;
        private String status;
}
