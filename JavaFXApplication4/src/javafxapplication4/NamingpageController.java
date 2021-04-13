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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JTextField;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class NamingpageController implements Initializable {

    @FXML
    private TextField textfield1;
    @FXML
    private TextField textfield2;

    /**
     * Initializes the controller class.
     */
  
    
    @FXML
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
    Parent menupageParent = FXMLLoader.load(getClass().getResource("menu.fxml"));
        
        Scene menupageScene = new Scene(menupageParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.getIcons().add(new Image("/javafxapplication4/logo.jpg"));
        window.setTitle("MENU");
        window.setScene(menupageScene);
        window.show();
    }
    @FXML
    public void changeScreenButtonPushed2(ActionEvent event) throws IOException //throws IOException
    {
       String S1=textfield1.getText();
       String S2=textfield2.getText();
       FXMLLoader Loader=new FXMLLoader();
       Loader.setLocation(getClass().getResource("gameboard.fxml"));
       try{
       Loader.load();
       }catch (IOException ex)
       {
       Logger.getLogger(NamingpageController.class.getName()).log(Level.SEVERE,null,ex);
       }
       GameboardController gm=Loader.getController();
       gm.setText(S1, S2);
       Parent p=Loader.getRoot();
       Stage stage=new Stage();
       stage.getIcons().add(new Image("/javafxapplication4/logo.jpg"));
       stage.setTitle("GAME BOARD");
       stage.setScene(new Scene(p));
       stage.show();
      
       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
