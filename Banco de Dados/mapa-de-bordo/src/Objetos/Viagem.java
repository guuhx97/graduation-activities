package Objetos;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Gusta
 */
public class Viagem {

    /**
     * @return the lance
     */
    public ArrayList<Lance> getLance() {
        return lance;
    }

    /**
     * @param lance the lance to set
     */
    public void setLance(ArrayList<Lance> lance) {
        this.lance = lance;
    }
    
    private int codigo;
    private Porto porto_saida;
    private Porto porto_chegada;
    private Embarcacao embarcacao;
    private LocalDate data_saida;
    private LocalDate data_chegada;  
    private ArrayList<Lance> lance;

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
     * @return the porto_saida
     */
    public Porto getPorto_saida() {
        return porto_saida;
    }

    /**
     * @param porto_saida the porto_saida to set
     */
    public void setPorto_saida(Porto porto_saida) {
        this.porto_saida = porto_saida;
    }

    /**
     * @return the porto_chegada
     */
    public Porto getPorto_chegada() {
        return porto_chegada;
    }

    /**
     * @param porto_chegada the porto_chegada to set
     */
    public void setPorto_chegada(Porto porto_chegada) {
        this.porto_chegada = porto_chegada;
    }

    /**
     * @return the embarcacao
     */
    public Embarcacao getEmbarcacao() {
        return embarcacao;
    }

    /**
     * @param embarcacao the embarcacao to set
     */
    public void setEmbarcacao(Embarcacao embarcacao) {
        this.embarcacao = embarcacao;
    }

    /**
     * @return the data_saida
     */
    public LocalDate getData_saida() {
        return data_saida;
    }

    /**
     * @param data_saida the data_saida to set
     */
    public void setData_saida(LocalDate data_saida) {
        this.data_saida = data_saida;
    }

    /**
     * @return the data_chegada
     */
    public LocalDate getData_chegada() {
        return data_chegada;
    }

    /**
     * @param data_chegada the data_chegada to set
     */
    public void setData_chegada(LocalDate data_chegada) {
        this.data_chegada = data_chegada;
    }
}
