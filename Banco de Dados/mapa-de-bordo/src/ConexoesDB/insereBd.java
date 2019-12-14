/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexoesDB;

import Objetos.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class insereBd {
    
    
       ConexaoDB conexao = new ConexaoDB();
    
       public boolean inserePorto(Porto porto) throws SQLException{
           String sql = "INSERT INTO porto(nome, administracao, ano_fundacao) VALUES('"+porto.getNome()+"','"+porto.getTipoDeAdministraçao()+"','"+porto.getAnoFundacao()+"')";
           PreparedStatement stmt = conexao.conecta().prepareStatement(sql);          
           return stmt.execute();       
       }
       
       public boolean insereEmbarcacao(Embarcacao embarcacao) throws SQLException{
           String sql = "INSERT INTO embarcacao(nome,tamanho) VALUES('"+embarcacao.getNome()+"','"+embarcacao.getTamanho()+"')";
           PreparedStatement stmt = conexao.conecta().prepareStatement(sql);          
           return stmt.execute();       
       }
       
       public boolean insereEspecie (Especie especie, ArrayList<Fotografia> listaFotos) throws SQLException{
           int UltimoId = 0;
           int cont = 0;
           String sqlFotografia;
           PreparedStatement stmt3;
           
           String sqlEspecie = "INSERT INTO especie(nome, profundidade_max, profundidade_min) VALUES ('"+especie.getNome()+"','"+especie.getProfund_max()+"','"+especie.getProfund_min()+"')";
           PreparedStatement stmt = conexao.conecta().prepareStatement(sqlEspecie);  
           if(stmt.execute()){
               return false;
           }
           String sqlUltimoId = "SELECT MAX(id) FROM especie";
           PreparedStatement stmt2 = ConexaoDB.conecta().prepareStatement(sqlUltimoId);
           ResultSet rs = stmt2.executeQuery();
           if(rs.next()){
               UltimoId = rs.getInt(1);
           }
           for (Fotografia listaFoto : listaFotos) {
                sqlFotografia ="INSERT INTO foto_especie(especie_id, foto)VALUES ('"+UltimoId+"','"+listaFoto.getCaminhoFoto()+"');";           
                stmt3 = conexao.conecta().prepareStatement(sqlFotografia);  
                if(!stmt3.execute()){
                    return false;
                }
           }
           return true;
       }

       public boolean insereViagem(Viagem viagem){
           
           return true;
       }

}
