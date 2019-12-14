/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import ConexoesDB.insereBd;
import MapaDeBordo.MapaDeBordoFormJavaFX;
import Objetos.Embarcacao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Gusta
 */
public class FXMLCadastroEmbarcacaoController implements Initializable {
    
    
    
    @FXML
        private Button btCadastrar;
    @FXML
        private TextField taNomeEmbarcacao;
    @FXML
        private MaskTextField taTamanho;
        
        private insereBd insere = new insereBd();

         
    
    @FXML
    void adicionarListaEmbarcacao(ActionEvent event) throws SQLException, IOException {
          Embarcacao embarcacao = new Embarcacao();
        final String cssDefault = "-fx-border-color: red;-fx-border-width: 1;";         
         if(taNomeEmbarcacao.getText().equals("")){         
            taNomeEmbarcacao.setStyle(cssDefault);
            return;
         }else if(taTamanho.getText().equals("")){
             taTamanho.setStyle(cssDefault);
            return;
         };
        embarcacao.setNome(taNomeEmbarcacao.getText());
        embarcacao.setTamanho(Double.parseDouble(taTamanho.getText()));
        if(!insere.insereEmbarcacao(embarcacao)){
          JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso!");         
          Stage stage = (Stage) btCadastrar.getScene().getWindow(); 
          stage.close();         
          MapaDeBordoFormJavaFX.scene.setRoot(FXMLLoader.load(getClass().getResource("/FXMLView/FXMLEmbarcacao.fxml"))); 
     }else{
            JOptionPane.showMessageDialog(null, "Opss!! Algo de errado aconteceu.");
        }        
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       taTamanho.setMask("NNN.NN");
    }    
    
}
