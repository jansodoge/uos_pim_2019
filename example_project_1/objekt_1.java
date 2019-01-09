import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import utilspim.MMColorGrid; 
import utilspim.EasySliderPanel; 
import utilspim.EasyBarChartPanel; 
import utilspim.EasyChartPanel; 
import java.util.Random;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * Beschreibung
 *
 * @version 2.0 vom 7.01.2019
 * @author Jan Sodoge
 */


public class objekt_1 extends JFrame {
  
  
  //Create the grid on which ants are able to move 
  private MMColorGrid mMColorGrid1 = new MMColorGrid();

	//we use these 2-d arrays to store the number of ants and the pheromons on the 2-d grid
  double[][] multi_ameise = new double[30][30];
  int[][] multi_spuren = new int[30][30];
  
 
  public objekt_1() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 997; 
    int frameHeight = 657;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("ant_project");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    //if using the hardcoding to setBounds, paramters are as follows for this method setBounds(upper_left_x, upper_left_y, x_length, y_length)
    mMColorGrid1.setBounds(50, 50, 500, 500);
    //this part is important to determine the size of the grid
    mMColorGrid1.setXYcells(30,30); 
    
    //to color fields within the grid, this one is a nice method to convert a RGB to an int to store certain colors for fast access
    
    int ameise=mMColorGrid1.rgbToInt(0,255,0);
  	
    
   //this part shows by an example how cells can be colored within a model
   
    for (int i = 0;i <30 ;i++) {
      for (int j = 0;j <30 ;j++) {
          multi_ameise[i][j] = 0.0;
          multi_spuren[i][j] = 0;
          //the set color method has both x,y coordinates as well as the liked color as an argument
          mMColorGrid1.setColor(i,j, mMColorGrid1.rgbToInt(0,0,0));
      } 
      
    } 
    
    //Make sure the GUI/display is updated and changes are shown: mMColorGrid1.repaint();
    
    //to enable a fast access among your agents, it is helpful to store yours in a datastructure e.g. a linked list
  
    LinkedList<ameise> linkedlist = new LinkedList<ameise>();
    //in the process of this model, the for loop below indicates by each iteration one time step. Let´ use as a premise of this model
    // that in each timestep an agent will be born
    for (int index = 1 ; index < 1000; index++) {
      
        ameise ant = new ameise(index);
        linkedlist.add(ant);
      
      for (int i = 0; i < linkedlist.size(); i++) {
      
        ameise stake = linkedlist.get(i);
        stake.move();
        
        //especially when dealing with larger number of agents, it is important to integrate a delete-function for these agents as soon as
        //these are unimportant for your model to reduce computation time
        if(stake.sterben_lassen) {
          //in this case it might be possible to delete the agents from the linkedlist as soon as they e.g. leave the borders of the grid
          linkedlist.remove(stake);
          
        }   
        
        
      }
      //we use this part to slow down the movement of agents so we can analyze the model on a visual level
      //watch out for the catch-block though
      try {
        Thread.sleep(1);
      } catch(Exception e) {
        
      } finally {
        
      } 
      
    //as already pointed out in the 'exponential growth example' add changes and make them visible  
    cp.add(mMColorGrid1);
    setVisible(true);                                                             
  }    
  } 
  
  //just for the purpose of this basic model, a method would be necessary to edit the level of pheromones
  public void spurenabbau(){
    for (int x = 0;x < 30 ;x++ ) {
      for (int y = 0;y < 30 ;y++ ) {
    
    }
    }
  }
  

public class ameise{


private int y_coordinate;
private int x_coordinate; 
private boolean food_reached;
public boolean sterben_lassen; 
//it can be helpful to get your agents an ID so in case you either want to do advanced, agent-personalized analytics or track agents down for checking your model 
private double id;
   
    

public ameise(int id_identifier){
      
this.food_reached = false;
this.sterben_lassen = false;     
    

this.id = id_identifier;      
multi_ameise[x_coordinate][y_coordinate] = id_identifier;     
      
  }
  
    


public void move(){
//now this is open to your ideas to move the agents                 
        }  
  }  
  
  //finally, execute the model
  public static void main(String[] args) {
    new objekt_1();   
  } 
  
  

}
