package br.com.namedida.domain.form;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RelatorioForm {
        private String nome;
        private LocalDateTime dataDeEnvio;
        private String status;
}
