package br.com.namedida.domain.form;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ProdutoForm {
        private String nome;
        private String descricao;
        private String codigoDeBarras;
        private String categoria;
        private Long departamento;
}
