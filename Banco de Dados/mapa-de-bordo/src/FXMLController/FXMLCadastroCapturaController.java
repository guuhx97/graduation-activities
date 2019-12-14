/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import Objetos.Captura;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class FXMLCadastroCapturaController implements Initializable {
    
    
    @FXML
        private Button btFinalizar; 
    @FXML
        private TableView<Captura> tabelaCaptura = new TableView();
    @FXML
        private TableColumn<Captura,String> colunaEspecie = new TableColumn();
    @FXML
        private TableColumn<Captura,String> colunaPeso= new TableColumn();      
    
    @FXML
        private Stage telaCadastroCaptura = new Stage();
        
        private static ArrayList<Captura> capturas = new ArrayList<>();
        
        public Scene scene;
        void setCapturas(Captura captura){
            this.capturas.add(captura);
        }
    
    @FXML
        void finalizarCaptura(ActionEvent event) throws IOException{
            FXMLTesteLance fx = new FXMLTesteLance();
            Stage stage = (Stage) btFinalizar.getScene().getWindow(); 
            stage.close(); 
        }
        
    @FXML
        void inserirCadastro(ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLPreencheCaptura.fxml"));      
                Scene scene = new Scene(root);        
                telaCadastroCaptura.setScene(scene);
                telaCadastroCaptura.getIcons().add(new Image("/Imagens/Viagem.png"));
                telaCadastroCaptura.setTitle("Travel");
                telaCadastroCaptura.show();  
        }
    @FXML
        void carregarLista(){
            tabelaCaptura.getItems().clear();
            colunaEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
            colunaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
            tabelaCaptura.setItems(FXCollections.observableArrayList(capturas));
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarLista();
    }    
    
}
