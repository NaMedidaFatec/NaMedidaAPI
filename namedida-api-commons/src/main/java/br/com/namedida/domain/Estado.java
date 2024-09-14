package br.com.namedida.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "estado")
@Entity
public class Estado extends EntidadeDominio {

    @NotNull(message = "Sigla obrigatória")
    private String uf;

    @NotNull(message = "O nome do estado é obrigatório")
    private String nome;
}
