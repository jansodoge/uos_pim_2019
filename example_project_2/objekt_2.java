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
 * @version 2.1 vom 7.01.2019
 * @author Jan Sodoge
 *in this version, further graphics will be included in basic style and thereby, hopefully, explained
 */


public class objekt_2 extends JFrame {
  
  
  //Create the grid on which ants are able to move 
  private MMColorGrid mMColorGrid1 = new MMColorGrid();
  
  private EasyBarChartPanel balkendiagramm = new EasyBarChartPanel();
  private DefaultCategoryDataset barpanel = new DefaultCategoryDataset();

  //in this simple example, we want to evaluate how many ants are successfull in finding the 
  //food source, instead of really generating results, here, some fake results are directly generated
  private int class_1_100 = 5;
  private int class_101_200 = 25;
  private int class_201_300 = 50;          
  private int class_301_400 = 100;
  private int class_401_500 = 120;
  private int class_501_600 = 125;
  private int class_601_700 = 100;
  private int class_701_800 = 50;
  private int class_801_900 = 25;
  private int class_901_1000 = 5;	



	//we use these 2-d arrays to store the number of ants and the pheromons on the 2-d grid
  double[][] multi_ameise = new double[30][30];
  int[][] multi_spuren = new int[30][30];
  
 
  public objekt_2() { 
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
    
    //set labels for balkendiagramm
    balkendiagramm.setLabels("Effizienz der Futtersuche", "Ameisengruppe [-]", "Ameisen [-]");


	barpanel.addValue(class_101_200,  "1",  "1");
    barpanel.addValue(class_201_300,  "1",  "2");  
    barpanel.addValue(class_301_400,  "1",  "3");
    barpanel.addValue(class_401_500,  "1",  "4");
    barpanel.addValue(class_501_600,  "1",  "5");
    barpanel.addValue(class_601_700,  "1",  "6");
    barpanel.addValue(class_701_800,  "1",  "7");
    barpanel.addValue(class_801_900,  "1",  "8");  
    balkendiagramm.updateChart(barpanel);
    
    balkendiagramm.setBounds(616, 24, 265, 457);
    cp.add(balkendiagramm);
    
    
    
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
    new objekt_2();   
  } 
  
  

}
