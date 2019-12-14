/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexoesDB;

import Objetos.Embarcacao;
import Objetos.Especie;
import Objetos.Fotografia;
import Objetos.Porto;
import Objetos.Viagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class buscaBd {
    
    
    ConexaoDB conexao = new ConexaoDB();
    ArrayList<Embarcacao> embarcacao = new ArrayList<>();
    ArrayList<Especie> especie = new ArrayList<>();
    ArrayList<Porto> porto = new ArrayList<>();
    ArrayList<Fotografia> fotografia = new ArrayList<>();
    ArrayList<Viagem> viagem = new ArrayList<>();
    

    public ArrayList<Embarcacao> buscaEmbarcacao() throws SQLException{
        String sql = "SELECT * FROM embarcacao";
        PreparedStatement stmt = conexao.conecta().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next() != false){
            embarcacao.add(new Embarcacao(rs.getInt("id"),rs.getString("nome"),rs.getDouble("tamanho")));
        }
        return embarcacao;
    }
    
    public ArrayList<Especie> buscaEspecie() throws SQLException{
        
        String sql = "SELECT * FROM especie";
        PreparedStatement stmt = conexao.conecta().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next() != false){
            especie.add(new Especie(rs.getInt("id"),rs.getString("nome"),rs.getDouble("profundidade_max"),rs.getDouble("profundidade_min")));
        }
        return especie;
        
    }
    
    public ArrayList<Fotografia> buscaFotografia() throws SQLException{
        String sql = "SELECT * FROM foto_especie";
        PreparedStatement stmt = conexao.conecta().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next() != false){
            fotografia.add(new Fotografia(rs.getInt("id"), rs.getString("foto"),rs.getInt("especie_id")));
        }
        return fotografia;
    }
    
    public ArrayList<Porto> buscaPorto() throws SQLException{
        String sql = "SELECT * FROM porto";
        PreparedStatement stmt = conexao.conecta().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next() != false){
            porto.add(new Porto(rs.getInt("id"),rs.getString("nome"), rs.getString("administracao"), rs.getInt("ano_Fundacao")));
        }
        return porto;
    }
    
    public ArrayList<Viagem> buscaViagem() throws SQLException{
        return viagem;
    }
    
}
