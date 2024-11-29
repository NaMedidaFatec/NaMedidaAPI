package br.com.namedida.domain;


import br.com.namedida.domain.deserializer.UnidadeEnsinoDeserializer;
import br.com.namedida.domain.enums.RelatorioStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "relatorio")
@Entity
public class Relatorio extends EntidadeDominio {
    private String nome;

    private LocalDateTime dataDeEnvio;

    @ManyToOne
    private Usuario enviadoPor;

    @Enumerated(EnumType.STRING)
    private RelatorioStatus status = RelatorioStatus.EM_ANALISE;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonDeserialize(using = UnidadeEnsinoDeserializer.class)
    private UnidadeEnsino unidadeEnsino;

    @Builder(builderMethodName="relatorioBuilder")
    public Relatorio(String nome, LocalDateTime dataDeEnvio, Usuario enviadoPor, RelatorioStatus status, UnidadeEnsino unidadeEnsino) {
        this.nome = nome;
        this.dataDeEnvio = dataDeEnvio;
        this.enviadoPor = enviadoPor;
        this.status = status;
        this.unidadeEnsino = unidadeEnsino;
    }
}
