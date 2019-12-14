package Objetos;

/**
 *
 * @author Gusta
 */
public class EspecieLance {
    private int codigo;
    private Lance lance;
    private Especie especie;
    private double qtd_kilos;

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
     * @return the lance
     */
    public Lance getLance() {
        return lance;
    }

    /**
     * @param lance the lance to set
     */
    public void setLance(Lance lance) {
        this.lance = lance;
    }

    /**
     * @return the especie
     */
    public Especie getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    /**
     * @return the qtd_kilos
     */
    public double getQtd_kilos() {
        return qtd_kilos;
    }

    /**
     * @param qtd_kilos the qtd_kilos to set
     */
    public void setQtd_kilos(double qtd_kilos) {
        this.qtd_kilos = qtd_kilos;
    } 
}
