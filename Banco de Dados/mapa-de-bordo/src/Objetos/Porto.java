/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Gusta
 */
public class Porto {
    private int codigo;
    private String nome;
    private String tipoDeAdministraçao;
    private int anoFundacao;

    public Porto(){
        
    }
    
    public Porto(int codigo, String nome, String tipoAdministracao, int anoFundacao){
        this.codigo = codigo;
        this.nome = nome;
        this.tipoDeAdministraçao = tipoAdministracao;
        this.anoFundacao = anoFundacao;    
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipoDeAdministraçao
     */
    public String getTipoDeAdministraçao() {
        return tipoDeAdministraçao;
    }

    /**
     * @param tipoDeAdministraçao the tipoDeAdministraçao to set
     */
    public void setTipoDeAdministraçao(String tipoDeAdministraçao) {
        this.tipoDeAdministraçao = tipoDeAdministraçao;
    }

    /**
     * @return the anoFundacao
     */
    public int getAnoFundacao() {
        return anoFundacao;
    }

    /**
     * @param anoFundacao the anoFundacao to set
     */
    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
}
