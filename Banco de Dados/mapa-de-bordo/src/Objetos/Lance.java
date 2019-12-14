package Objetos;


import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;

/**
 *
 * @author Gusta
 */
public class Lance {
    
    
    private int codigo;
    private Viagem viagem;
    private LocalDate dataLance;
    private Time horaInicial;
    private Time horaFinal;
    private double compRede;
    private double alturaRede;
    private double tamanhoMalha;
    private double profundidade;
    private double latitude;
    private double longitude;
    private ArrayList<Captura> captura;

    public Lance(int codigo, double compRede, double alturaRede, double tamanhoMalha, double profundidade, double latitude, double longitude){
        this.codigo = codigo;
        this.compRede = compRede;
        this.alturaRede = alturaRede;
        this.tamanhoMalha = tamanhoMalha;
        this.profundidade = profundidade;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Lance(int codigo, Viagem viagem, LocalDate dataLance, Time horaInicial, Time horaFinal, double compRede, double alturaRede, double tamanhoMalha, double profundidade, double latitude, double longitude, ArrayList<Captura> captura) {
        this.codigo = codigo;
        this.viagem = viagem;
        this.dataLance = dataLance;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.compRede = compRede;
        this.alturaRede = alturaRede;
        this.tamanhoMalha = tamanhoMalha;
        this.profundidade = profundidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.captura = captura;
    }

    public Lance() {
       
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
     * @return the viagem
     */
    public Viagem getViagem() {
        return viagem;
    }

    /**
     * @param viagem the viagem to set
     */
    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    /**
     * @return the dataLance
     */
    public LocalDate getDataLance() {
        return dataLance;
    }

    /**
     * @param dataLance the dataLance to set
     */
    public void setDataLance(LocalDate dataLance) {
        this.dataLance = dataLance;
    }

    /**
     * @return the horaInicial
     */
    public Time getHoraInicial() {
        return horaInicial;
    }

    /**
     * @param horaInicial the horaInicial to set
     */
    public void setHoraInicial(Time horaInicial) {
        this.horaInicial = horaInicial;
    }

    /**
     * @return the horaFinal
     */
    public Time getHoraFinal() {
        return horaFinal;
    }

    /**
     * @param horaFinal the horaFinal to set
     */
    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    /**
     * @return the compRede
     */
    public double getCompRede() {
        return compRede;
    }

    /**
     * @param compRede the compRede to set
     */
    public void setCompRede(double compRede) {
        this.compRede = compRede;
    }

    /**
     * @return the alturaRede
     */
    public double getAlturaRede() {
        return alturaRede;
    }

    /**
     * @param alturaRede the alturaRede to set
     */
    public void setAlturaRede(double alturaRede) {
        this.alturaRede = alturaRede;
    }

    /**
     * @return the tamanhoMalha
     */
    public double getTamanhoMalha() {
        return tamanhoMalha;
    }

    /**
     * @param tamanhoMalha the tamanhoMalha to set
     */
    public void setTamanhoMalha(double tamanhoMalha) {
        this.tamanhoMalha = tamanhoMalha;
    }

    /**
     * @return the profundidade
     */
    public double getProfundidade() {
        return profundidade;
    }

    /**
     * @param profundidade the profundidade to set
     */
    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the captura
     */
//    public ArrayList<Captura> getCaptura() {
//        return captura;
//    }
//
//    /**
//     * @param captura the captura to set
//     */
//    public void setCaptura(ArrayList<Captura> captura) {
//        this.captura = captura;
//    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

   
}
