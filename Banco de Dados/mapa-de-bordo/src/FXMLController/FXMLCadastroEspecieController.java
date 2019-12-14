/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLController;

import ConexoesDB.insereBd;
import MapaDeBordo.MapaDeBordoFormJavaFX;
import Objetos.Especie;
import Objetos.Fotografia;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gusta
 */
public class FXMLCadastroEspecieController implements Initializable {
    
@FXML
    private TextField taNomeEspecie;
@FXML
    private MaskTextField taProfMin;
@FXML
    private MaskTextField taProfMax;
@FXML
    private ImageView ivFotoUm;
@FXML
    private ImageView ivFotoDois;
@FXML
    private ImageView ivFotoTres;
@FXML
    private ImageView ivFotoQuatro;
@FXML
    private ImageView ivFotoCinco;
@FXML
    private Button btFotoUm;
@FXML
    private Button btFotoDois;
@FXML
    private Button btFotoTres;
@FXML
    private Button btFotoQuatro;
@FXML
    private Button btFotoCinco;
@FXML
    private Button btCadastrarEspecie;

    private BufferedImage bufferedImage;
    
    private insereBd insere = new insereBd();
    
    private ArrayList<Fotografia> listaImagens = new ArrayList<Fotografia>();
    
    
    @FXML
        void carregarFotoUm(ActionEvent event) throws IOException { 
                FileChooser fileChooser = new FileChooser();       
                fileChooser.setTitle("Open Resource File");
                fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg"));                  
                File selectedFile = fileChooser.showOpenDialog(null);
                if(selectedFile != null) {
                    try{
                        bufferedImage = ImageIO.read(selectedFile);
                        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                        image.getHeight();
                        ivFotoUm.setImage(image);
                        ivFotoUm.fitWidthProperty().set(80);
                        ivFotoUm.fitHeightProperty().set(87);
                        String nomeImagem = System.currentTimeMillis()+ ".jpg";
                        File outputFile = new File("H:\\MapaDeBordoFormJavaFX\\src\\Fotos\\"+nomeImagem);    
                        listaImagens.add(new Fotografia(nomeImagem));
                        ImageIO.write(bufferedImage, "JPG", outputFile);
                        btFotoUm.setDisable(true);
                    }catch(IOException ex){
                        Logger.getLogger(FXMLCadastroEspecieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }else{
                        JOptionPane.showMessageDialog(null,"Ops, você não selecionou nenhum arquivo");
                    } 
            }
    @FXML
        void carregarFotoDois(ActionEvent event){
            FileChooser fileChooser = new FileChooser();       
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg"));                  
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null) {
                try{
                    bufferedImage = ImageIO.read(selectedFile);
                    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                    image.getHeight();
                    ivFotoDois.setImage(image);
                    ivFotoDois.fitWidthProperty().set(80);
                    ivFotoDois.fitHeightProperty().set(87);
                    String nomeImagem = System.currentTimeMillis()+ ".jpg";
                    File outputFile = new File("H:\\MapaDeBordoFormJavaFX\\src\\Fotos\\"+nomeImagem);
                    listaImagens.add(new Fotografia(nomeImagem));
                    ImageIO.write(bufferedImage, "JPG", outputFile);
                    btFotoDois.setDisable(true);
                }catch(IOException ex){
                    Logger.getLogger(FXMLCadastroEspecieController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                    JOptionPane.showMessageDialog(null,"Ops, você não selecionou nenhum arquivo");
                } 
        }
    @FXML
        void carregarFotoTres(ActionEvent event){
            FileChooser fileChooser = new FileChooser();       
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg"));                  
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null) {
                try{
                    bufferedImage = ImageIO.read(selectedFile);
                    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                    image.getHeight();
                    ivFotoTres.setImage(image);
                    ivFotoTres.fitWidthProperty().set(80);
                    ivFotoTres.fitHeightProperty().set(87);
                    String nomeImagem = System.currentTimeMillis()+ ".jpg";
                    File outputFile = new File("H:\\MapaDeBordoFormJavaFX\\src\\Fotos\\"+nomeImagem);  
                    listaImagens.add(new Fotografia(nomeImagem));                   
                    ImageIO.write(bufferedImage, "JPG", outputFile);
                    btFotoTres.setDisable(true);
                }catch(IOException ex){
                    Logger.getLogger(FXMLCadastroEspecieController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                    JOptionPane.showMessageDialog(null,"Ops, você não selecionou nenhum arquivo");
                } 
        }
    @FXML
        void carregarFotoQuatro(ActionEvent event){
            FileChooser fileChooser = new FileChooser();       
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg"));                  
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null) {
                try{
                    bufferedImage = ImageIO.read(selectedFile);
                    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                    image.getHeight();
                    ivFotoQuatro.setImage(image);
                    ivFotoQuatro.fitWidthProperty().set(80);
                    ivFotoQuatro.fitHeightProperty().set(87);
                    String nomeImagem = System.currentTimeMillis()+ ".jpg";
                    File outputFile = new File("H:\\MapaDeBordoFormJavaFX\\src\\Fotos\\"+nomeImagem);
                    listaImagens.add(new Fotografia(nomeImagem));
                    ImageIO.write(bufferedImage, "JPG", outputFile);
                    btFotoQuatro.setDisable(true);
                }catch(IOException ex){
                    Logger.getLogger(FXMLCadastroEspecieController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                    JOptionPane.showMessageDialog(null,"Ops, você não selecionou nenhum arquivo");
                } 
        }
    @FXML
        void carregarFotoCinco(ActionEvent event){
            FileChooser fileChooser = new FileChooser();       
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null) {
                try{
                    bufferedImage = ImageIO.read(selectedFile);
                    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                    image.getHeight();
                    ivFotoCinco.setImage(image);
                    ivFotoCinco.fitWidthProperty().set(80);
                    ivFotoCinco.fitHeightProperty().set(87);
                    String nomeImagem = System.currentTimeMillis()+ ".jpg";
                    File outputFile = new File("H:\\MapaDeBordoFormJavaFX\\src\\Fotos\\"+nomeImagem);
                    listaImagens.add(new Fotografia(nomeImagem));
                    ImageIO.write(bufferedImage, "JPG", outputFile);
                    btFotoCinco.setDisable(true);
                }catch(IOException ex){
                    Logger.getLogger(FXMLCadastroEspecieController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                    JOptionPane.showMessageDialog(null,"Ops, você não selecionou nenhum arquivo");
                } 
        }

    @FXML
        void cadastrarBancoEspecie(ActionEvent event) throws SQLException, IOException{
           Especie especie = new Especie();
           final String cssDefault = "-fx-border-color: red;-fx-border-width: 1;"; 
           if(taNomeEspecie.getText().equals("")){
                taNomeEspecie.setStyle(cssDefault);
                return;
           }
           if(taProfMax.getText().equals("") || taProfMin.getText().equals("")){
               taProfMax.setStyle(cssDefault);
               taProfMin.setStyle(cssDefault);
               return;
           }
           if( Double.parseDouble(taProfMax.getText()) < Double.parseDouble(taProfMin.getText())){
               taProfMax.setStyle(cssDefault);
               taProfMin.setStyle(cssDefault);
               return;
           }
           especie.setNome(taNomeEspecie.getText());
           especie.setProfund_max(Double.parseDouble(taProfMax.getText()));
           especie.setProfund_min(Double.parseDouble(taProfMin.getText()));
           
           if(insere.insereEspecie(especie,listaImagens)){
                //JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso!");         
                Stage stage =  (Stage) taNomeEspecie.getScene().getWindow(); 
                stage.close();         
                MapaDeBordoFormJavaFX.scene.setRoot(FXMLLoader.load(getClass().getResource("/FXMLView/FXMLEspecie.fxml"))); 
            }else{
                JOptionPane.showMessageDialog(null, "Opss!! Algo de errado aconteceu.");
            } 
        }
    
        public void initialize(URL url, ResourceBundle rb) {
            final String cssDefault = "-fx-background-color: #FFFFFF;";
            btFotoUm.setStyle(cssDefault);
            btFotoDois.setStyle(cssDefault);
            btFotoTres.setStyle(cssDefault);
            btFotoQuatro.setStyle(cssDefault);
            btFotoCinco.setStyle(cssDefault);
            taProfMax.setMask("NNNN");
            taProfMin.setMask("NNNN");    
    }    
    
}
