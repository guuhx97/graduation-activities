package br.univali.egjide.modelo;

import java.util.ArrayList;
import java.util.List;
//import br.univali.egjide.modelo.

/**
 *
 * @author Prog
 */
public class Simbolo {
    private String nome;
    private String tipo;
    private boolean inicializado = false;
    private boolean usada = false;
    private String escopo;
    private boolean param;
    private int pos = 0;
    private boolean vet = false;
    private boolean func = false;
    private int internalId;
    private List<String> valoresVet = new ArrayList<>();
    private List<Operacao> operacoes = new ArrayList<>();
    private String valor;    
    private String indexVet = null;
    private String io = null;
    private OperacaoRelacional opRel = new OperacaoRelacional();

    public List<String> getValoresVet() {
        return valoresVet;
    }

    public void setValoresVet(List<String> valoresVet) {
        this.valoresVet = valoresVet;
    }
    
    public void addValorVer(String valor){
        this.valoresVet.add(valor);
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }
    
    public void addOperacao(String operacao, String indexVet){
        this.operacoes.add(new Operacao(operacao, indexVet));
    }
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getIndexVet() {
        return indexVet;
    }

    public void setIndexVet(String indexVet) {
        this.indexVet = indexVet;
    }

    public String getIo() {
        return io;
    }

    public void setIo(String io) {
        this.io = io;
    }

    public OperacaoRelacional getOpRel() {
        return opRel;
    }

    public void setOpRel(OperacaoRelacional opRel) {
        this.opRel = opRel;
    }    

    public int getInternalId() {
        return internalId;
    }

    public void setInternalId(int internalId) {
        this.internalId = internalId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String id) {
        this.nome = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isInicializado() {
        return inicializado;
    }

    public void setInicializado(boolean inicializado) {
        this.inicializado = inicializado;
    }

    public boolean isUsada() {
        return usada;
    }

    public void setUsada(boolean usada) {
        this.usada = usada;
    }

    public String getEscopo() {
        return escopo;
    }

    public void setEscopo(String escopo) {
        this.escopo = escopo;
    }

    public boolean isParam() {
        return param;
    }

    public void setParam(boolean param) {
        this.param = param;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public boolean isVet() {
        return vet;
    }

    public void setVet(boolean vet) {
        this.vet = vet;
    }

    public boolean isFunc() {
        return func;
    }

    public void setFunc(boolean func) {
        this.func = func;
    }
    
    
}
