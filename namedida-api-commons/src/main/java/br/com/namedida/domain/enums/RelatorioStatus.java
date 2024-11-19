package br.com.namedida.domain.enums;

public enum RelatorioStatus {
    ENVIADO("Enviado"),
    EM_ANALISE("Em análise"),
    CONCLUIDO("Concluído");

    private RelatorioStatus(String descricao) {
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