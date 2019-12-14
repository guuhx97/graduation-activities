package ConexoesDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gusta
 */
public class ConexaoDB {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/MapaDeBordoForm";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";
    
    public static Connection conecta(){
       try{
           Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
           //JOptionPane.showMessageDialog(null, "Conectou!!");
           return con; //DriverManager.getConnection(URL,USER,PASSWORD);
       }catch(SQLException err){
           JOptionPane.showMessageDialog(null,"Nao foi possivel conectar-se ao Banco de Dados, Contate o ADM");
            err.printStackTrace();
            return null;
       }
    }
}
