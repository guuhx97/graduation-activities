/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Gustavo
 */
public class Fotografia {
    
    private int codigo;
    private String caminhoFoto;
    private int codigo_especie;
    
    public Fotografia(){
        
    }
       
    public  Fotografia(String caminhoFoto){
        this.caminhoFoto = caminhoFoto;
    }
    public Fotografia(int codigo, String caminhoFoto, int codigo_especie){
        this.caminhoFoto = caminhoFoto;
        this.codigo = codigo;
        this.codigo_especie = codigo_especie;
    }
    
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigoEspecie(int codigo_especie){
        this.codigo_especie = codigo_especie;
    }
    
    public int getCodigoEspecie(){
        return codigo_especie;
    }
    
    public void setCaminhoFoto(String fotografia){
       this.caminhoFoto = fotografia;
    }
    
    public String getCaminhoFoto(){
        return caminhoFoto;
    }
    
    
    
}
