/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexoesDB;

import Objetos.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class exclusoesBd {
    
    
    ConexaoDB conexao = new ConexaoDB();
    
    public int excluirPorto(Porto porto) throws SQLException{
        String sql = "DELETE FROM porto WHERE id ="+porto.getCodigo();
        PreparedStatement stmt = conexao.conecta().prepareStatement(sql);
        return stmt.executeUpdate(); 
    }
    
    public int excluirEspecie(Especie especie) throws SQLException{
        String sql = "DELETE FROM especie WHERE id ="+especie.getCodigo();
        PreparedStatement stmt = conexao.conecta().prepareStatement(sql);
        return stmt.executeUpdate();            
    }
    
    public int excluirEmbarcacao(Embarcacao embarcacao) throws SQLException{
        String sql = "DELETE FROM embarcacao WHERE id ="+embarcacao.getCodigo();
        PreparedStatement stmt = conexao.conecta().prepareStatement(sql);
        return stmt.executeUpdate();           
    }
}
