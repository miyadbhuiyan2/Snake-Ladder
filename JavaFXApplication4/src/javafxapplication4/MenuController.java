/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JButton;

/**
 * FXML Controller class
 *
 * @author Asus
 */

public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {   
         Parent namingpageParent = FXMLLoader.load(getClass().getResource("namingpage.fxml"));
        Scene namingpageScene = new Scene(namingpageParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.getIcons().add(new Image("/javafxapplication4/logo.jpg"));
        window.setTitle("Set Name");
        window.setScene(namingpageScene);
        window.show();
       
    }
    public void changeScreenButtonPushed2(ActionEvent event) throws IOException
    {
    Parent aboutpageParent = FXMLLoader.load(getClass().getResource("aboutpage.fxml"));
        Scene namingpageScene = new Scene(aboutpageParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
            window.getIcons().add(new Image("/javafxapplication4/logo.jpg"));
        window.setTitle("About The Game");
        window.setScene(namingpageScene);
        window.show();
    }
    public void changeScreenButtonPushed3(ActionEvent event) throws IOException
    {
    Parent creditpageParent = FXMLLoader.load(getClass().getResource("creditpage.fxml"));
        Scene creditpageScene = new Scene(creditpageParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
            window.getIcons().add(new Image("/javafxapplication4/logo.jpg"));
        window.setTitle("Credit Page");
        window.setScene(creditpageScene);
        window.show();
    }
    public void changeScreenButtonPushed4(ActionEvent event) throws IOException
    {
    Parent rankingpageParent = FXMLLoader.load(getClass().getResource("rankingpage.fxml"));
        Scene rankingpageScene = new Scene(rankingpageParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
            window.getIcons().add(new Image("/javafxapplication4/logo.jpg"));
        window.setTitle("Ranking");
        window.setScene(rankingpageScene);
        window.show();
    }
    public void changeScreenButtonPushed5(ActionEvent event) throws IOException
    {
    
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
