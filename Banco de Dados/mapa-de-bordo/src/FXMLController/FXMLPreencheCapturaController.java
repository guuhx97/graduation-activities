/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import ConexoesDB.buscaBd;
import Objetos.Captura;
import Objetos.Especie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class FXMLPreencheCapturaController implements Initializable {

    
    @FXML
        private Button btCadastrar;
    @FXML
        private ComboBox cbxEspecie;
    @FXML
        private TextField taPeso;
    
        
    
        private buscaBd bd = new buscaBd();
    
    @FXML
        public void carregarComboBoxEspecie() throws SQLException{                                
            cbxEspecie.setItems(FXCollections.observableArrayList(bd.buscaEspecie()));
        }
    @FXML
        void cadastrarCaptura(ActionEvent event) throws IOException{
            Captura captura = new Captura();           
            captura.setEspecie((Especie) cbxEspecie.getSelectionModel().getSelectedItem());
            captura.setPeso(Double.parseDouble(taPeso.getText()));
            FXMLCadastroCapturaController fx = new FXMLCadastroCapturaController();
            fx.setCapturas(captura);           
            Stage stage = (Stage) btCadastrar.getScene().getWindow(); 
            stage.close();
            FXMLTesteLance.scene.setRoot(FXMLLoader.load(getClass().getResource("/FXMLView/FXMLCadastroCaptura.fxml")));
        }
       
       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarComboBoxEspecie();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLPreencheCapturaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
