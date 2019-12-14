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
/**
 * FXML Controller class
 *
 * @author Gusta
 */
public class FXMLEspecieController implements Initializable {
    
    
    
    @FXML
        private Button adicionarEspecie;
    @FXML
        private Button btRemoverEspecie;
    @FXML
        private TableView<Especie> tabelaEspecie;
    @FXML
        private TableColumn<Especie, String> colunaCodigo;
    @FXML
        private TableColumn<Especie, String> colunaNome;
    @FXML
        private TableColumn<Especie, String> colunaProfMax;
    @FXML
        private TableColumn<Especie, String> colunaProfMin;
    @FXML
        private ImageView ivFotoUm;
   
        private ObservableList<Especie> oLlistaEspecie;
    
        buscaBd busca = new buscaBd();
    
        exclusoesBd delete = new exclusoesBd();
    
        Stage telaCadastroEspecie = new Stage();
        
        ArrayList<Fotografia> listaFotografia = new ArrayList<>();
        
        String caminhoSistema = "H:\\MapaDeBordoFormJavaFX\\src\\Fotos\\";
        
        String caminhoSistemaDois = "H:\\MapaDeBordoFormJavaFX\\src\\Imagens\\";
        
            private BufferedImage bufferedImage;
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
            Parent root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLCadastroEspecie.fxml"));      
            Scene scene = new Scene(root);        
            telaCadastroEspecie.setScene(scene);
            telaCadastroEspecie.getIcons().add(new Image("/Imagens/Porto.png"));
            telaCadastroEspecie.setTitle("Register Harbor");
            telaCadastroEspecie.show();            
        } 
    @FXML
        void carregarListaPortos() throws SQLException{            
            tabelaEspecie.getItems().clear();
            colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colunaProfMax.setCellValueFactory(new PropertyValueFactory<>("profund_max"));
            colunaProfMin.setCellValueFactory(new PropertyValueFactory<>("profund_min"));         
            oLlistaEspecie = FXCollections.observableArrayList(busca.buscaEspecie());
            tabelaEspecie.setItems(oLlistaEspecie);
        }       
        
    @FXML
        void carregarListaFotografias() throws SQLException{
            listaFotografia = busca.buscaFotografia();
        }
    
    @FXML
        void removerDaListaPorto(ActionEvent event) throws IOException, SQLException{
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
               Especie Especie = tabelaEspecie.getSelectionModel().getSelectedItem();
                tabelaEspecie.getItems().remove(Especie);
                if(delete.excluirEspecie(Especie) == 1){
                    JOptionPane.showMessageDialog(null, "Item Excluido com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Ops!!! Aconteceu algum problema");
                }
            }
        }
        public void clickItem(MouseEvent event){
            tabelaEspecie.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
                public void handle(MouseEvent event){
                    Especie especie = tabelaEspecie.getSelectionModel().getSelectedItem();               
                    for (Fotografia fotografia : listaFotografia) {                      
                        if(especie.getCodigo() == fotografia.getCodigoEspecie()){
                            File t = new File(caminhoSistema+fotografia.getCaminhoFoto());
                            try {
                                bufferedImage = ImageIO.read(t);
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLEspecieController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                            ivFotoUm.setImage(image);
                             break;
                        }else{
                            File t = new File(caminhoSistemaDois+"semImagem.png");
                            try {
                                bufferedImage = ImageIO.read(t);
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLEspecieController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                            ivFotoUm.setImage(image);                            
                        }
                       
                    }
                    
                }    
            });

        }
        
        
        

    public void initialize(URL url, ResourceBundle rb) {          
        try {
            carregarListaPortos();
            carregarListaFotografias();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLEspecieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
