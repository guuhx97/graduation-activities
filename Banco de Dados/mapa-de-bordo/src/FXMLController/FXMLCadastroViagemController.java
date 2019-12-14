/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import ConexoesDB.buscaBd;
import ConexoesDB.insereBd;
import Objetos.Embarcacao;
import Objetos.Porto;
import Objetos.Viagem;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gusta
 */
public class FXMLCadastroViagemController implements Initializable {
    
    
    @FXML
    private buscaBd bd = new buscaBd();
    @FXML
    private Button btEmbarcacao;
    @FXML
    private Button btPorto;
    @FXML
    private Button btViagem;
    @FXML
    private Button btEspecie;
    @FXML
    private Button btRelatorio;
    @FXML
    private Menu mAjuda;
    @FXML
    private Menu mOpcao;
    @FXML
    private Menu mArquivo;
    @FXML
    private MenuItem miCadastrarEmbarcacao;
    @FXML
    private MenuItem miCadastrarEspecie;
    @FXML
    private MenuItem miCadastrarPorto;
    @FXML
    private MenuItem miCadastrarViagem;
    @FXML
    private ComboBox<Embarcacao> cbxEmbarcacao;
    @FXML
    private ComboBox<Porto> cbxPortoSaida;
    @FXML
    private ComboBox<Porto> cbxPortoChegada;
    @FXML
    private DatePicker dpDataSaida;
    @FXML
    private DatePicker dpDataChegada;
    @FXML
    private Button btAvancar;  
    @FXML
    private Button btCancelar;
    @FXML
    private Stage telaCadastroLance = new Stage();
    
    private insereBd insere = new insereBd();
    
    private ObservableList<Embarcacao> oLlistaEmbacacao;
    
    private ObservableList<Porto> oLlistaPorto;
    
    public static Scene scene;
    
    public Viagem viagemFinal = new Viagem();

    @FXML
        public void carregarComboBoxEmbarcacao() throws SQLException{                     
            oLlistaEmbacacao = FXCollections.observableArrayList(bd.buscaEmbarcacao());
            cbxEmbarcacao.setItems(oLlistaEmbacacao);
        }
        
    @FXML
        public void carregarComboBoxPorto() throws SQLException{
            oLlistaPorto = FXCollections.observableArrayList(bd.buscaPorto());
            cbxPortoChegada.setItems(oLlistaPorto);
            cbxPortoSaida.setItems(oLlistaPorto);
        }
        
    @FXML
        void avancarCadastroLance(ActionEvent event) throws IOException{
            final String cssDefault = "-fx-border-color: red;-fx-border-width: 1;"; 
            if(cbxEmbarcacao.getSelectionModel().getSelectedItem() == null){
                cbxEmbarcacao.setStyle(cssDefault);
                return;
            }
            if(cbxPortoChegada.getSelectionModel().getSelectedItem() == null){
                cbxPortoChegada.setStyle(cssDefault);
                return;
            }
            if(cbxPortoSaida.getSelectionModel().getSelectedItem() == null){
                cbxPortoSaida.setStyle(cssDefault);
                return;
            }
            if(dpDataChegada.getValue() == null){
                dpDataChegada.setStyle(cssDefault);
                return;
            }
            if(dpDataSaida.getValue() == null){
                dpDataSaida.setStyle(cssDefault);
                return;
            }
            
            
            cbxEmbarcacao.setDisable(true);
            cbxPortoChegada.setDisable(true);
            cbxPortoSaida.setDisable(true);
            dpDataChegada.setDisable(true);
            dpDataSaida.setDisable(true);
            
            Parent root = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLTesteLance.fxml"));      
            scene = new Scene(root);        
            telaCadastroLance.setScene(scene);
            telaCadastroLance.getIcons().add(new Image("/Imagens/Viagem.png"));
            telaCadastroLance.setTitle("Travel");
            telaCadastroLance.show();    
        }
    @FXML
        void finalizarCadastroViagem(ActionEvent event){
            
            final String cssDefault = "-fx-border-color: red;-fx-border-width: 1;"; 
            if(cbxEmbarcacao.getSelectionModel().getSelectedItem() == null){
                cbxEmbarcacao.setStyle(cssDefault);
                return;
            }
            if(cbxPortoChegada.getSelectionModel().getSelectedItem() == null){
                cbxPortoChegada.setStyle(cssDefault);
                return;
            }
            if(cbxPortoSaida.getSelectionModel().getSelectedItem() == null){
                cbxPortoSaida.setStyle(cssDefault);
                return;
            }
            if(dpDataChegada.getValue() == null){
                dpDataChegada.setStyle(cssDefault);
                return;
            }
            if(dpDataSaida.getValue() == null){
                dpDataSaida.setStyle(cssDefault);
                return;
            }

            Embarcacao embarcacao = cbxEmbarcacao.getSelectionModel().getSelectedItem();
            Porto porto_chegada = cbxPortoChegada.getSelectionModel().getSelectedItem();
            Porto porto_saida = cbxPortoSaida.getSelectionModel().getSelectedItem();
            LocalDate data_chegada = dpDataChegada.getValue();
            LocalDate data_saida = dpDataSaida.getValue();
            
            viagemFinal.setData_chegada(data_chegada);
            viagemFinal.setData_saida(data_saida);
            viagemFinal.setEmbarcacao(embarcacao);
            viagemFinal.setPorto_chegada(porto_chegada);
            viagemFinal.setPorto_saida(porto_saida);
            
            
            insere.insereViagem(viagemFinal);
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarComboBoxEmbarcacao();
            carregarComboBoxPorto();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLCadastroViagemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
