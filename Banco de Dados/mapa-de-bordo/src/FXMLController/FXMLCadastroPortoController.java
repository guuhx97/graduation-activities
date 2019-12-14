/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import ConexoesDB.insereBd;
import MapaDeBordo.MapaDeBordoFormJavaFX;
import Objetos.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Gusta
 */
public class FXMLCadastroPortoController implements Initializable {

    
    @FXML
         private Button btCadastrar;
    @FXML
         private ComboBox<String> cbxAdministracao;
    @FXML
         private TextField taNomePorto;
    @FXML
         private MaskTextField tfFundacao;
    
    private final ArrayList<String> alListaAdm = new ArrayList<>();
    
    private ObservableList<String> olListaAdm;
    
    private insereBd insere = new insereBd();
   
    
    @FXML
    void adicionarListaPorto(ActionEvent event) throws SQLException, IOException{
        Porto porto = new Porto(); 
        final String cssDefault = "-fx-border-color: red;-fx-border-width: 1;";  
       
         if(taNomePorto.getText().equals("")){         
            taNomePorto.setStyle(cssDefault);
            return;
         }else if(cbxAdministracao.getSelectionModel().getSelectedItem() == null){         
            cbxAdministracao.setStyle(cssDefault);
            return;
         }else if(tfFundacao.getText().equals("") || Integer.parseInt(tfFundacao.getText()) > 2017){;
             tfFundacao.setStyle(cssDefault);
             return;
         }
        porto.setNome(taNomePorto.getText());
        porto.setTipoDeAdministraçao(cbxAdministracao.getSelectionModel().getSelectedItem());
        porto.setAnoFundacao(Integer.parseInt(tfFundacao.getText()));
        if(!insere.inserePorto(porto)){
            JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso!");         
            Stage stage = (Stage) btCadastrar.getScene().getWindow(); 
            stage.close();         
            MapaDeBordoFormJavaFX.scene.setRoot(FXMLLoader.load(getClass().getResource("/FXMLView/FXMLPorto.fxml"))); 
        }else{
            JOptionPane.showMessageDialog(null, "Opss!! Algo de errado aconteceu.");
        }        
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alListaAdm.add("Publica");
        alListaAdm.add("Privada");
        olListaAdm = FXCollections.observableArrayList(alListaAdm);
        cbxAdministracao.setItems(olListaAdm);
        tfFundacao.setMask("NNNN");
       
    }    
    
}
