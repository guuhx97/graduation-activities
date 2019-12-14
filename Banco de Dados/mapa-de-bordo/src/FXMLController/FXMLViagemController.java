/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import ConexoesDB.buscaBd;
import ConexoesDB.exclusoesBd;
import MapaDeBordo.MapaDeBordoFormJavaFX;
import Objetos.Porto;
import Objetos.Viagem;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * @author Gusta
 */
public class FXMLViagemController implements Initializable {   
    
    @FXML
        private Button btAdicionar;
    @FXML
        private Button btRemober;
    @FXML
        private TableView tabelaViagem;
    @FXML
        private TableColumn colunaCodigo;
    @FXML
        private TableColumn colunaEmbarcacao;
    @FXML
        private TableColumn colunaPortoSaida;
    @FXML
        private TableColumn colunaPortoChegada;
    
        private ObservableList<Viagem> oLlistaViagem;
    
        private buscaBd busca = new buscaBd();
    
        private exclusoesBd delete = new exclusoesBd();
        
         private Stage abrirTelaLance = new Stage();
    
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

    @FXML
        void abrirCadastroViagem(ActionEvent event) throws IOException{          
            Parent root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLCadastroViagem.fxml"));      
            Scene scene = new Scene(root);        
            abrirTelaLance.setScene(scene);
            abrirTelaLance.show();            
        }    
           
    @FXML
        void carregarListaPortos() throws SQLException{            
            tabelaViagem.getItems().clear();
            colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            colunaEmbarcacao.setCellValueFactory(new PropertyValueFactory<>("embarcacao"));
            colunaPortoSaida.setCellValueFactory(new PropertyValueFactory<>("porto_saida"));
            colunaPortoChegada.setCellValueFactory(new PropertyValueFactory<>("porto_chegada"));         
            oLlistaViagem = FXCollections.observableArrayList(busca.buscaViagem());
            tabelaViagem.setItems(oLlistaViagem);
        }  
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarListaPortos();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLViagemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
