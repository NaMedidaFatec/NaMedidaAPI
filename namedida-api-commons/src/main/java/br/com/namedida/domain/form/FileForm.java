package br.com.namedida.domain.form;

import lombok.Data;


@Data
public class FileForm {
    private String numero;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cep;
    private Long cidade;
}


