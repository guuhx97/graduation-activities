package Objetos;

/**
 *
 * @author Gusta
 */
public class Embarcacao {
    private int codigo;
    private String nome;
    private double tamanho;
    
    public Embarcacao(int codigo, String nome, double tamanho){
        this.codigo = codigo;
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public Embarcacao() {
   
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
     * @return the tamanho
     */
    public double getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
}
