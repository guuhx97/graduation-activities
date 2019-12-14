/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import MapaDeBordo.MapaDeBordoFormJavaFX;
import Objetos.Lance;
import Objetos.Porto;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class FXMLPreencheLance implements Initializable {

    @FXML
        private DatePicker dpData;
    @FXML
        private TextField taHoraInicial;
    @FXML
        private TextField taHoraFinal;
    @FXML
        private TextField taProfundidade;
    @FXML
        private TextField taLatitude;
    @FXML
        private TextField taLongitude;
    @FXML
        private TextField taCompRede;
    @FXML
        private TextField taMalhaRede;
    @FXML
        private TextField taAlturaRede;
    @FXML
        private Button btCadastrar;

    
 
    @FXML
        void jogarPraLancePraLista(ActionEvent event) throws IOException{
            final String cssDefault = "-fx-border-color: red;-fx-border-width: 1;"; 
            if(dpData.getValue() == null){
                dpData.setStyle(cssDefault);
                return;
            }
            if(taHoraInicial.getText().equals("")){
                taHoraInicial.setStyle(cssDefault);
                return;
            }
            if(taHoraFinal.getText().equals("")){
                taHoraFinal.setStyle(cssDefault);
                return;
            }
            if(taProfundidade.getText().equals("")){
                taProfundidade.setStyle(cssDefault);
                return;
            }
            if(taMalhaRede.getText().equals("")){
                taMalhaRede.setStyle(cssDefault);
                return;
            }
            if(taAlturaRede.getText().equals("")){
                taAlturaRede.setStyle(cssDefault);
                return;
            }
            if(taCompRede.getText().equals("")){
                taMalhaRede.setStyle(cssDefault);
                return;
            }
            if(taLatitude.getText().equals("")){
                taLatitude.setStyle(cssDefault);
                return;
            }
            if(taLongitude.getText().equals("")){
                taLongitude.setStyle(cssDefault);
                return;
            }
            
            Lance lance = new Lance();
            
            lance.setDataLance(dpData.getValue());
            lance.setAlturaRede(Double.parseDouble(taAlturaRede.getText()));
            lance.setCompRede(Double.parseDouble(taCompRede.getText()));
//            lance.setHora_final_lance(Time.valueOf(taHoraFinal.getText()));
//            lance.setHora_inicial_lance(Time.valueOf(taHoraInicial.getText()));
            lance.setLatitude(Double.parseDouble(taLatitude.getText()));
            lance.setLongitude(Double.parseDouble(taLongitude.getText()));           
            lance.setTamanhoMalha(Double.parseDouble(taMalhaRede.getText()));
            lance.setProfundidade(12.4);
            FXMLTesteLance fx = new FXMLTesteLance();
            fx.addTeste(lance);
            
            Stage stage = (Stage) btCadastrar.getScene().getWindow(); 
            stage.close(); 
            FXMLCadastroViagemController.scene.setRoot(FXMLLoader.load(getClass().getResource("/FXMLView/FXMLTesteLance.fxml"))); 
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
