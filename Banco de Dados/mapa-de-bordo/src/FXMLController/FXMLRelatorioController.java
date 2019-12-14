/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import MapaDeBordo.MapaDeBordoFormJavaFX;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author Gusta
 */
public class FXMLRelatorioController implements Initializable {

    
    /*---Menu--*/   
    @FXML
	void telaEmbarcacao(ActionEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLEmbarcacao.fxml"));
			MapaDeBordoFormJavaFX.scene.setRoot(root);
		} catch (IOException e) {
                    System.out.println(e);
		}
	}
        
    @FXML
        void telaPorto(ActionEvent event){
            Parent root;
            try{
                root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLPorto.fxml"));
                MapaDeBordoFormJavaFX.scene.setRoot(root);
            }catch(IOException e){
                System.out.println(e);
            }                    
        }
        
    @FXML
        void telaViagem(ActionEvent event){
            Parent root;
            try{
                root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLViagem.fxml"));
                MapaDeBordoFormJavaFX.scene.setRoot(root);
            }catch(IOException e){
                System.out.println(e);
            }                   
        }
    
    @FXML
        void telaEspecie (ActionEvent event){
            Parent root;
            try{
                root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLEspecie.fxml"));
                MapaDeBordoFormJavaFX.scene.setRoot(root);
            }catch(IOException e){
                System.out.println(e);
            } 
        }
    
    @FXML
        void telaRelatorio (ActionEvent event){
            Parent root;
            try{
                root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLRelatorio.fxml"));
                MapaDeBordoFormJavaFX.scene.setRoot(root);
            }catch(IOException e){
                System.out.println(e);
            }
        }
    /*------------------------------------------------------------*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
