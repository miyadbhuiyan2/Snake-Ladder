/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CreditpageController implements Initializable {

    /**
     * Initializes the controller class.
     */
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
