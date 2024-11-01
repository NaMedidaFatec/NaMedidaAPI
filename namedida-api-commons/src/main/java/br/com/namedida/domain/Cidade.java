package br.com.namedida.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "cidade")
@Entity
public class Cidade extends EntidadeDominio {
    private String nome;

    @ManyToOne
    @JoinColumn(name = "estado")
    private Estado estado;

    @Override
    public String toString() {
        StringBuilder descricao = new StringBuilder(nome);
        if (estado != null) {
            descricao.append(" - ").append(estado.getUf());
        }
        return descricao.toString();
    }
}
