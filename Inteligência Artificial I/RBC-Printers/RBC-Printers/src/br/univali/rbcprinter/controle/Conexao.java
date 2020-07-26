
package br.univali.rbcprinter.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Conexao {
    private final String JDBC     = "postgresql";
    private final String HOST     = "localhost";
    private final String PORT     = "5432";
    private final String DATABASE = "postgres";
    private final String USER     = "postgres";
    private final String PASSWORD = "123456";
    private final String DRIVER   = "org.postgresql.Driver";
    private String url;
    private Connection conexao;
    private PreparedStatement pStatement;
    private Statement statement;

    public Conexao() {
        try {
            url = "jdbc:" + JDBC + "://" + HOST + ":" + PORT + "/" + DATABASE;
            Properties prop = new Properties();
            prop.setProperty("user", USER);
            prop.setProperty("password", PASSWORD);
            prop.setProperty("ssl", "false");
            prop.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
            conexao = DriverManager.getConnection(url, prop);
            statement = conexao.createStatement();
            System.out.println("Conexao estabelecida;");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com banco. " + url);
            e.printStackTrace();
        }
    }
    
    public void encerrarConexao() {
        try {
            conexao.close();
            System.out.println("Conexão encerrada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet consultaCaso() {
        String sql = "SELECT id, tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao FROM caso";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar caso.");
            e.printStackTrace();
        }        
        return rs;
    }
    
    public ResultSet consultaCasoOrdenado() {
        String sql = "SELECT id, tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao, ROUND(AVG(similaridade)::numeric,2) FROM caso GROUP BY id ORDER BY similaridade DESC";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar caso.");
            e.printStackTrace();
        }
        return rs;
    }
    
    public void inserirCaso(String tipo, String cabo, String fonte, String ledPower, String ledEthernet, String ledProcess, String iluminador, String imprimindo, String escaneando, String alimentador, String estufa, String tonner, String solucao) {
        String sql = "INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pStatement = conexao.prepareStatement(sql);
            pStatement.setString(1, tipo);
            pStatement.setString(2, cabo);
            pStatement.setString(3, fonte);
            pStatement.setString(4, ledPower);
            pStatement.setString(5, ledEthernet);
            pStatement.setString(6, ledProcess);
            pStatement.setString(7, iluminador);
            pStatement.setString(8, imprimindo);
            pStatement.setString(9, escaneando);
            pStatement.setString(10, alimentador);
            pStatement.setString(11, estufa);
            pStatement.setString(12, tonner);
            pStatement.setString(13, solucao);
            pStatement.executeUpdate();
            System.out.println("Caso inserido;");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir novo caso.");
            e.printStackTrace();
        }
    }
    
    public void alterarSimilaridade(int id, double similaridade) {
        String sql = "UPDATE caso SET similaridade = ? WHERE id = ?";
        try {
            pStatement = conexao.prepareStatement(sql);
            pStatement.setDouble(1, similaridade);
            pStatement.setInt(2, id);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar similaridade.");
            e.printStackTrace();
        }
    }
}
