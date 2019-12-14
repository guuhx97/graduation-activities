/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapaDeBordo;

import ConexoesDB.ConexaoDB;
import FXMLController.FXMLCadastroViagemController;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.NativeDebug;
/**
 *
 * @author Gusta
 */
public class MapaDeBordoFormJavaFX extends Application {
  
    public static Scene scene;
    @Override
    public void start(Stage stage) throws Exception {     
        Parent root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLPrincipal.fxml"));      
        scene = new Scene(root);        
        stage.getIcons().add(new Image("/Imagens/icon.png"));
        stage.setTitle("Extriti Map of Maple");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException { 
        
          launch(args); 

       
//        ConexaoDB db = new ConexaoDB();
//        db.conecta();
    }
    
}
