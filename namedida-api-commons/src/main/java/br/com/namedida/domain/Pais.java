package br.com.namedida.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "pais")
@Entity
public class Pais extends EntidadeDominio {

    @NotNull(message = "O nome do estado é obrigatório")
    private String nome;

}
