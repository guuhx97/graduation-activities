/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import ConexoesDB.*;
import MapaDeBordo.MapaDeBordoFormJavaFX;
import Objetos.Porto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Gusta
 */
public class FXMLPortoController implements Initializable {
    
    
    
    @FXML
        private Button adicionarPorto;
    @FXML
        private Button btRemoverPorto;
    @FXML
        private TableView<Porto> tabelaPorto;
    @FXML
        private TableColumn<Porto, String> colunaCodigo;
    @FXML
        private TableColumn<Porto, String> colunaNome;
    @FXML
        private TableColumn<Porto, String> colunaFundacao;
    @FXML
        private TableColumn<Porto, String> colunaAdministracao;
    
        private ObservableList<Porto> oLlistaPorto;
    
        buscaBd busca = new buscaBd();
    
        exclusoesBd delete = new exclusoesBd();
    
        Stage telaCadastroPorto = new Stage();

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
        void abrirCadastroPorto(ActionEvent event) throws IOException{           
            Parent root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLCadastroPorto.fxml"));      
            Scene scene = new Scene(root);        
            telaCadastroPorto.setScene(scene);
            telaCadastroPorto.getIcons().add(new Image("/Imagens/Porto.png"));
            telaCadastroPorto.setTitle("Register Harbor");
            telaCadastroPorto.show();            
        } 
    @FXML
        void carregarListaPortos() throws SQLException{            
            tabelaPorto.getItems().clear();
            colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colunaFundacao.setCellValueFactory(new PropertyValueFactory<>("anoFundacao"));
            colunaAdministracao.setCellValueFactory(new PropertyValueFactory<>("tipoDeAdministraçao"));         
            oLlistaPorto = FXCollections.observableArrayList(busca.buscaPorto());
            tabelaPorto.setItems(oLlistaPorto);
        }       
    @FXML
        void removerDaListaPorto(ActionEvent event) throws IOException, SQLException{
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
               Porto porto = tabelaPorto.getSelectionModel().getSelectedItem();
                tabelaPorto.getItems().remove(porto);
                if(delete.excluirPorto(porto) == 1){
                    JOptionPane.showMessageDialog(null, "Item Excluido com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Ops!!! Aconteceu algum problema");
                }
            }
        }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarListaPortos();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLPortoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
