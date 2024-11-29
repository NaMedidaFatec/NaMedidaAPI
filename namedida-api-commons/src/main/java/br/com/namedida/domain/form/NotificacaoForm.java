package br.com.namedida.domain.form;

import br.com.namedida.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class NotificacaoForm {
        private String mensagem;

        private LocalDateTime horario;

        private boolean visto;

        private Usuario usuario;
}
