package br.com.namedida.domain;

import br.com.namedida.domain.enums.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "notificacao")
@Entity
public class Notificacao extends EntidadeDominio {
    @NotNull(message = "Mensagem obrigatória")
    private String mensagem;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime horario;

    private boolean visto;

    @ManyToOne
    private Usuario usuario;

    @Builder(builderMethodName="notificacaoBuilder")
    public Notificacao(String mensagem, LocalDateTime horario, boolean visto, Usuario usuario) {
        this.mensagem = mensagem;
        this.horario = horario;
        this.visto = visto;
        this.usuario = usuario;
    }
}
