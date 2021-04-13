/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class WelcomePageController implements Initializable {

    @FXML
    private ProgressBar progressBar;
    @FXML
    private AnchorPane rootpane;
    /**
     * Initializes the controller class.
     */
   
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        new LoadingScreen().start();
    }    
   class LoadingScreen extends Thread{
   @Override
   public void run(){
   
   try {    
   for(int i=0;i<100;i++)
   {
           progressBar.setProgress(i/100.0);
           Thread.sleep(100);
   }
   Platform.runLater(new Runnable() {
       @Override
       public void run() {
          Parent root=null;
           try {
               root = FXMLLoader.load(getClass().getResource("menu.fxml"));
           } catch (IOException ex) {
               Logger.getLogger(WelcomePageController.class.getName()).log(Level.SEVERE, null, ex);
           }
           Scene scene = new Scene(root);
           Stage stage=new Stage();
            stage.getIcons().add(new Image("/javafxapplication4/logo.jpg"));
        stage.setTitle("MENU");
           stage.setScene(scene);
           stage.show();
           
           rootpane.getScene().getWindow().hide();
       }
   });
       } catch (InterruptedException ex) {
           Logger.getLogger(WelcomePageController.class.getName()).log(Level.SEVERE, null, ex);
       }
   
       
      
        
   }
   
   }
}
