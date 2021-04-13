/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Asus
 */


public class GameboardController implements Initializable {

    @FXML
    private Button dice2;
    @FXML
    private Button dice1;
    @FXML
    private ImageView coin1;
    @FXML
    private ImageView coin2;
    @FXML
    private Label player1;
    @FXML
    private Label player2;
    
    @FXML
    private ImageView diceValue;
    @FXML
    private Button reset;
    @FXML
    private Text score2;
    @FXML
    private Text score1;
     @FXML
    private ImageView gameboard;
    
      @FXML
    private RadioButton soundOn;
    @FXML
    private RadioButton soundOff;
    @FXML
    private ToggleGroup onOff;
    @FXML
    private ImageView dicevalue2;
   
     
    double[] gameboardX={0,203,265,331,399,470,533,601,667,731,797,
                        797,731,667,601,533,470,399,331,265,203,
                         203,265,331,399,470,533,601,667,731,797,
                         797,731,667,601,533,470,399,331,265,203,
                         203,265,331,399,470,533,601,667,731,797,
                         797,731,667,601,533,470,399,331,265,203,
                         203,265,331,399,470,533,601,667,731,797,
                         797,731,667,601,533,470,399,331,265,203,
                         203,265,331,399,470,533,601,667,731,797,
                         797,731,667,601,533,470,399,331,265,203,
                          };
    double[] gameboardY={0,736,736,736,736,736,736,736,736,736,736,
                         655,655,655,655,655,655,655,655,655,655,
                         571,571,571,571,571,571,571,571,571,571,
                         486,486,486,486,486,486,486,486,486,486,
                         407,407,407,407,407,407,407,407,407,407,
                         326,326,326,326,326,326,326,326,326,326,
                         240,240,240,240,240,240,240,240,240,240,
                         159,159,159,159,159,159,159,159,159,159,
                         74,74,74,74,74,74,74,74,74,74,
                         0,0,0,0,0,0,0,0,0,0};
    
    int[] snakeladder={0,1,2,3,25,5,6,7,8,9,10,
                      11,12,46,14,15,16,17,18,19,20,
                      21,22,23,24,25,26,5,28,29,30,
                      31,32,49,34,35,36,37,38,39,3,
                      41,63,18,44,45,46,47,48,49,69,
                      51,52,53,31,55,56,57,58,59,60,
                      61,81,63,64,65,45,67,68,69,70,
                      71,72,73,92,75,58,77,78,79,80,
                      81,82,83,84,85,86,87,88,53,90,
                      91,92,93,94,95,96,97,98,41,100};
     
      
    int i=0,j=0,k=0,l=0,noOfMoves1=0,noOfMoves2=0,diceturn=1;
    boolean coinmoveStart1=false,musicOn=true;
   
             AudioClip diceThrow=new AudioClip(this.getClass().getResource("dice_throw.wav").toString());
             AudioClip ladderPick=new AudioClip(this.getClass().getResource("ladder_pick.wav").toString());
             AudioClip snakeBite=new AudioClip(this.getClass().getResource("snake_bite.wav").toString());
             AudioClip gameOver=new AudioClip(this.getClass().getResource("game_over.wav").toString());
    
   Image image1=new Image("/javafxapplication4/1.png");  
   Image image2=new Image("/javafxapplication4/2.png");
   Image image3=new Image("/javafxapplication4/3.png"); 
    Image image4=new Image("/javafxapplication4/4.png");       
    Image image5=new Image("/javafxapplication4/5.png");       
    Image image6=new Image("/javafxapplication4/6.png"); 
    
    String sc1,sc2;
    
   
   
    
     @FXML
    public void dice1rotation(ActionEvent event) throws IOException 
    {  
     if(diceturn==1)    
    {  dicevalue2.setImage(null);
        if(musicOn==true)   
        {diceThrow.play();}
        diceturn=2;
        noOfMoves1++; 
       sc1=Integer.toString(noOfMoves1);
       score1.setText(sc1);
        double num1;
        double num2;
        int index1;
        
     Random rand = new Random(); 
     int value = rand.nextInt((6-1)+1)+1; 
     if(value==1)
     {
     
     diceValue.setImage(image1);
     }
     else if(value==2)
     {
     diceValue.setImage(image2);
     }
     else if(value==3)
     {        
     diceValue.setImage(image3);
     }
     else if(value==4)
     {
      
     diceValue.setImage(image4);
     }
     else if(value==5)
     {
       
     diceValue.setImage(image5);
     }
     else if(value==6)
     {
      
     diceValue.setImage(image6);
     }
     
     if(value==1)
     {coinmoveStart1=true;}
     int coinmove1;
     int range1=i+value;
     if(range1<=100 && coinmoveStart1==true)
     {    
     for(coinmove1=0;coinmove1<value;coinmove1++)
     {
      num1=gameboardX[++i];
      num2=gameboardY[++j];
     coin1.setLayoutX(num1);
     coin1.setLayoutY(num2);
     
     }
     if(i!=snakeladder[i])
     {
       if(i<snakeladder[i]&&musicOn==true)
       {ladderPick.play();}
       else if(i>snakeladder[i]&&musicOn==true)
       {snakeBite.play();}
     i=snakeladder[i];
     j=i;
     num1=gameboardX[i];
      num2=gameboardY[j];
     coin1.setLayoutX(num1);
     coin1.setLayoutY(num2);
     }
     }
     if(i==100)
     {
     if(musicOn==true)    
     {gameOver.play();}
     Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
     window.close();
     FXMLLoader Loader=new FXMLLoader();
       Loader.setLocation(getClass().getResource("gameover2.fxml"));
       try{
       Loader.load();
       }catch (IOException ex)
       {
       Logger.getLogger(NamingpageController.class.getName()).log(Level.SEVERE,null,ex);
       }
       Gameover2Controller gmo=Loader.getController();
       gmo.setData(P1,noOfMoves1);
       Parent p=Loader.getRoot();
       Stage stage=new Stage();
       stage.setScene(new Scene(p));
       stage.show();
     }
    }
    }
    boolean coinmoveStart2=false;
    
    @FXML
     public void dice2rotation(ActionEvent event) throws IOException  
    {  if(diceturn==2)
    {   diceValue.setImage(null);
        if(musicOn==true)
            {diceThrow.play();}
        diceturn=1;
        noOfMoves2++; 
        sc2=Integer.toString(noOfMoves2);
       score2.setText(sc2);
       double num3,num4;
        int index2;
     Random rand = new Random(); 
     int value = rand.nextInt((6-1)+1)+1; 
     if(value==1)
     {
      
     dicevalue2.setImage(image1);
     }
     else if(value==2)
     {
      
     dicevalue2.setImage(image2);
     }
     else if(value==3)
     {
     
     dicevalue2.setImage(image3);
     }
     else if(value==4)
     {
       
     dicevalue2.setImage(image4);
     }
     else if(value==5)
     {
      
     dicevalue2.setImage(image5);
     }
     else if(value==6)
     {
     
     dicevalue2.setImage(image6);
     }
        int coinmove2;
        int range2=k+value;
     
     if(value==1)
     {coinmoveStart2=true;}
        
     if(range2<=100&&coinmoveStart2==true)
     {
     for(coinmove2=0;coinmove2<value;coinmove2++)
     {
      num3=gameboardX[++k];
      num4=gameboardY[++l];
     coin2.setLayoutX(num3);
     coin2.setLayoutY(num4);
     
     }
     if(k!=snakeladder[k])
     {
         if(k<snakeladder[k]&&musicOn==true)
       {ladderPick.play();}
         else if(k>snakeladder[k]&&musicOn==true)
       {snakeBite.play();}
      
      k=snakeladder[k];
     l=k;
     num3=gameboardX[k];
      num4=gameboardY[l];
     coin2.setLayoutX(num3);
     coin2.setLayoutY(num4);
     }
     }
      if(k==100)
     {  if(musicOn==true)
            {gameOver.play();}
     Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
     window.close();
     FXMLLoader Loader=new FXMLLoader();
       Loader.setLocation(getClass().getResource("gameover2.fxml"));
       try{
       Loader.load();
       }catch (IOException ex)
       {
       Logger.getLogger(NamingpageController.class.getName()).log(Level.SEVERE,null,ex);
       }
       Gameover2Controller gmo=Loader.getController();
       gmo.setData(P2,noOfMoves2);
       Parent p=Loader.getRoot();
       Stage stage=new Stage();
       stage.setScene(new Scene(p));
       stage.show();
     }
    }
    }
     @FXML
     public void resetbutton(ActionEvent event)
     {
         i=0;
         j=0;
         k=0;
         l=0;
     coinmoveStart1=false;
     coinmoveStart2=false;
     diceturn=1;
     noOfMoves1=0;
     noOfMoves2=0;
     sc1=Integer.toString(noOfMoves1);
       score1.setText(sc1);
       sc2=Integer.toString(noOfMoves2);
       score2.setText(sc2);
     coin1.setLayoutX(34.0);
     coin1.setLayoutY(556.0);
     coin2.setLayoutX(927.0);
     coin2.setLayoutY(556.0);  
     diceValue.setImage(null);
     
     }
     
     @FXML
     public void radiobuttonOn(ActionEvent event)
     {
     musicOn=true;
     
     }
     @FXML
     public void radiobuttonOff(ActionEvent event)
     {
     musicOn=false;
     
     }

    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    } 
     
    String P1,P2;
     public void setText(String s1,String s2)
   {    
       P1=s1;
       P2=s2;
       this.player1.setText(s1);
       this.player2.setText(s2);
     
   }
   
}
