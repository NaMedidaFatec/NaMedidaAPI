package br.com.namedida.domain.enums;

public enum TipoUsuario {
    DEPARTAMENTO("Departamento"),
    UNIDADE_ENSINO("Unidade Ensino");

    private TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return name();
    }
}