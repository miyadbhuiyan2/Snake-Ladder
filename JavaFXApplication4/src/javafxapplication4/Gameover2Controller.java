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
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Asus
 */
class Player
{
    String name;
     
    int scores;
     
    public Player(String name, int scores) 
    {
        this.name = name;
         
        this.scores = scores;
    }
}
  
//scoresCompare Class to compare the marks
 
class scoresCompare implements Comparator<Player>
{
    @Override
    public int compare(Player s1, Player s2)
    {
        return s1.scores - s2.scores;
    }
}
 

public class Gameover2Controller implements Initializable {

    @FXML
    private Text winner;
    @FXML
    private Text movNumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setData(String s1,int score) throws IOException
   {    
       
       String Winner=s1;
       String result=Integer.toString(score);
       this.winner.setText(Winner);
       this.movNumber.setText(result);
       
      Scanner s = new Scanner(new File("ranking.txt"));
        //Creating ArrayList to hold Player objects
        boolean exist=false; 
        ArrayList<Player> playerRecords = new ArrayList<Player>();
       
        //Reading Student records one by one
        while (s.hasNext())
        {       
           String name = s.next();
           int scores = s.nextInt();
           //Creating Player object for every player record and adding it to ArrayList
           if(name.equalsIgnoreCase(Winner))
           {exist=true;
            playerRecords.add(new Player(Winner,score));
           }
           else
           {
           playerRecords.add(new Player(name,scores));
           }
        }
        if(exist==false){
             playerRecords.add(new Player(Winner,score)); 
        }
        //Sorting ArrayList playerRecords based on scores
         
        Collections.sort(playerRecords, new scoresCompare());
        s.close();
       //Creating BufferedWriter object to write into output text file
         
        BufferedWriter writer = new BufferedWriter(new FileWriter("ranking.txt"));
         
        //Writing every playerRecords into output text file
         int topper=0;
        for (Player player : playerRecords) 
        {   topper++;
            writer.write(player.name);
            writer.write(" "+player.scores);
            writer.newLine();
            if(topper>=20)
                break;
        }
         
        //Closing the resources
        writer.close();
   }
      
}
