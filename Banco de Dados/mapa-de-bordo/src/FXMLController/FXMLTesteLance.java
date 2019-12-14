/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import ConexoesDB.*;
import MapaDeBordo.MapaDeBordoFormJavaFX;
import Objetos.Especie;
import Objetos.Fotografia;
import Objetos.Lance;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Gusta
 */
public class FXMLTesteLance implements Initializable {
    
    
    
    @FXML
        private Button btNovoLance;
    @FXML
        private Button btCaptura;
    @FXML
        private Button btCancelar;
    @FXML
        private Button btFinalizar;
    @FXML
        private Button btRemoverEspecie;
    @FXML
        private TableView<Lance> tabelaEspecie;  
    @FXML
        private TableColumn<Lance, String> colunaNome;
    @FXML
        private TableColumn<Lance, String> colunaProfMax;
    @FXML
        private TableColumn<Lance, String> colunaProfMin;
    @FXML
        private TableColumn<Lance, String> colunaProfundidade;
      @FXML
        private TableColumn<Lance, String> colunaLatitude;
    @FXML
        private TableColumn<Lance, String> colunaLongitude;
    @FXML
        private ImageView ivFotoUm;
   
        private ObservableList<Lance> oLlistaEspecie;
        
        private static ArrayList<Lance> teste = new ArrayList<>();
        
        public static Scene scene;
    
        buscaBd busca = new buscaBd();
    
        exclusoesBd delete = new exclusoesBd();
    
        Stage telaCadastroLance = new Stage();

        private ObservableList<Lance> oLlistaLance;
        
        Lance lanceFinal = new Lance();
         
    @FXML
        public void addTeste(Lance lance){
            teste.add(lance);
        }
        
    @FXML
        void novoLance(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLPreencheLance.fxml"));      
            Scene scene = new Scene(root);        
            telaCadastroLance.setScene(scene);
            telaCadastroLance.getIcons().add(new Image("/Imagens/Viagem.png"));
            telaCadastroLance.setTitle("Travel");
            telaCadastroLance.show();  
    }
    
    @FXML
        void capturaCadastro(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLCadastroCaptura.fxml"));      
            scene = new Scene(root);        
            telaCadastroLance.setScene(scene);
            telaCadastroLance.getIcons().add(new Image("/Imagens/Viagem.png"));
            telaCadastroLance.setTitle("Travel");
            telaCadastroLance.show();  
    }
  
    @FXML
        void finalizaOuCancela(ActionEvent event){
            FXMLCadastroViagemController fx = new FXMLCadastroViagemController();
            fx.viagemFinal.setLance(teste);
            Stage stage = (Stage) btFinalizar.getScene().getWindow(); 
            stage.close(); 
        }    
 
    @FXML
        void carregarListaPortos(){
            if(teste.size() != 0){
                System.out.println(teste.get(0).getCompRede());
        }
            tabelaEspecie.getItems().clear();
            colunaNome.setCellValueFactory(new PropertyValueFactory<>("compRede"));
            colunaProfMax.setCellValueFactory(new PropertyValueFactory<>("alturaRede"));
            colunaProfMin.setCellValueFactory(new PropertyValueFactory<>("tamanhoMalha")); 
            colunaProfundidade.setCellValueFactory(new PropertyValueFactory<>("profundidade")); 
            colunaLatitude.setCellValueFactory(new PropertyValueFactory<>("latitude"));
            colunaLongitude.setCellValueFactory(new PropertyValueFactory<>("longitude"));
            oLlistaEspecie = FXCollections.observableArrayList(teste);
            tabelaEspecie.setItems(oLlistaEspecie);
        }       

        
     public void clickItem(MouseEvent event){
            tabelaEspecie.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
                public void handle(MouseEvent event){
                   btCaptura.setDisable(false);
                    lanceFinal = tabelaEspecie.getSelectionModel().getSelectedItem();
                    
                }    
            });

        }
     
     
    public void initialize(URL url, ResourceBundle rb) {    
        btCaptura.setDisable(true);
        carregarListaPortos();
    }    
    
}
