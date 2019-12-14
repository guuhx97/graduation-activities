package Objetos;

/**
 *
 * @author Gusta
 */
public class Especie {
    
    private int codigo;
    private String nome;
    private double profund_max;
    private double profund_min;
    
    public Especie(){
        
    }
    
    
    public Especie(int codigo, String nome, double profund_max, double profund_min){
        this.codigo = codigo;
        this.nome = nome;
        this.profund_max = profund_max;
        this.profund_min = profund_min; 
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
     * @return the foto
     */
   

    /**
     * @return the profund_max
     */
    public double getProfund_max() {
        return profund_max;
    }

    /**
     * @param profund_max the profund_max to set
     */
    public void setProfund_max(double profund_max) {
        this.profund_max = profund_max;
    }

    /**
     * @return the profund_min
     */
    public double getProfund_min() {
        return profund_min;
    }

    /**
     * @param profund_min the profund_min to set
     */
    public void setProfund_min(double profund_min) {
        this.profund_min = profund_min;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
}
