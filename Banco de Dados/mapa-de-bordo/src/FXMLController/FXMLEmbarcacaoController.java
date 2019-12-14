/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import ConexoesDB.buscaBd;
import ConexoesDB.exclusoesBd;
import MapaDeBordo.MapaDeBordoFormJavaFX;
import Objetos.*;
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
public class FXMLEmbarcacaoController implements Initializable {
    
    
    
    @FXML
        private Button btAdicionarEmbarcacao;
    @FXML
        private Button btRemoverEmbarcacao;
    @FXML
        private TableView tabelaEmbarcacao;
    @FXML
        private TableColumn<Embarcacao, String> colunaCodigo;
    @FXML
        private TableColumn<Embarcacao, String> colunaNome;
    @FXML
        private TableColumn<Embarcacao, String> colunaTamanho;
    
    
        private ObservableList<Embarcacao> oLlistaEmbarcacao;

        buscaBd busca = new buscaBd();

        exclusoesBd delete = new exclusoesBd();
    
        Stage telaCadastroEmbarcacao = new Stage();
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
        void abrirCadastroEmbarcacao(ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLCadastroEmbarcacao.fxml"));      
            Scene scene = new Scene(root);
            telaCadastroEmbarcacao.getIcons().add(new Image("/Imagens/Embarcacao.png"));
            telaCadastroEmbarcacao.setTitle("Register Ship");
            telaCadastroEmbarcacao.setScene(scene);
            telaCadastroEmbarcacao.show();            
        }
        
    @FXML
        void removerDaListaEmbarcacao(ActionEvent event) throws IOException, SQLException{
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {              
                Embarcacao embarcacao = (Embarcacao) tabelaEmbarcacao.getSelectionModel().getSelectedItem();
                tabelaEmbarcacao.getItems().remove(embarcacao);
                if(delete.excluirEmbarcacao(embarcacao) == 1){
                    JOptionPane.showMessageDialog(null, "Item Excluido com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Ops!!! Aconteceu algum problema");
                }
            }
        }
    @FXML
        void carregarListaEmbarcacao() throws SQLException{            
            tabelaEmbarcacao.getItems().clear();
            colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colunaTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));                     
            oLlistaEmbarcacao = FXCollections.observableArrayList(busca.buscaEmbarcacao());
            tabelaEmbarcacao.setItems(oLlistaEmbarcacao);
        }           
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarListaEmbarcacao();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLEmbarcacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
