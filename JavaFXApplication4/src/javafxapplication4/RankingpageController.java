/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
//Student Class
 

public class RankingpageController implements Initializable {

    @FXML
    private TextField searchBox;
    @FXML
    private Text foundText;
    @FXML
    private Label playernameLabel;
    @FXML
    private Text playerName;
    @FXML
    private Label scoreLabel;
    @FXML
    private Text scoreText;
    @FXML
    private Label postionLabel;
    @FXML
    private Text positionText;


    /**
     * Initializes the controller class.
     */
     @FXML
    public void changeScreenButtonPushed1(ActionEvent event) throws IOException
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
     public void searchButtonPushed(ActionEvent event) throws IOException
    {   String s1=searchBox.getText();
        int position=0;
        boolean found=false;
       Scanner s = new Scanner(new File("ranking.txt"));
       while (s.hasNext())
        {  position++;     
           String name = s.next();
           int scores = s.nextInt();
           if(s1.equalsIgnoreCase(name))
           {
           found=true;
           foundText.setFill(Color.GREEN);
           foundText.setText("NAME FOUND!!");
           String score=Integer.toString(scores);
           String pos=Integer.toString(position);
           playernameLabel.setText("PLAYER NAME:");
           playerName.setText(name);
           scoreLabel.setText("Number Of moves:");
           scoreText.setText(score);
           postionLabel.setText("POSITION:");
           positionText.setText(pos+"/20");
           
           break;
           }
        }
       if(found==false)
       {    foundText.setFill(Color.RED);
           foundText.setText("NAME NOT FOUND");
           playernameLabel.setText("");
           playerName.setText("");
           scoreLabel.setText("");
           scoreText.setText("");
           postionLabel.setText("");
           positionText.setText("");
       }
       s.close();
    }
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changeScreenButtonPushed(ScrollEvent event) {
    }
}

