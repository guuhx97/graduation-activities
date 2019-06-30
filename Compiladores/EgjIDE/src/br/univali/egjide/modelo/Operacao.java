package br.univali.egjide.modelo;

public class Operacao {
    private String operacao;
    private String indexVet;

    public Operacao(String operacao, String indexVet) {
        this.operacao = operacao;
        this.indexVet = indexVet;
    }

    public String getIndexVet() {
        return indexVet;
    }

    public void setIndexVet(String indexVet) {
        this.indexVet = indexVet;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
}
