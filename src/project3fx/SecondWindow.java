/*
 * tdb41
 * 970390758
 */
package project3fx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author thear
 */
public class SecondWindow {
    
 
    private final String State; 
    private final String NumStates; 
    private TextField StateField;
    private final int ZERO = 0;
    private final String IsLooped;
    private final String LoopInput;
    private final String NextState;
    private final String NextStateOutput;
    private final String JumpState;
    private final String JumpTrans;
    private final String JumpInput; 
    
    SecondWindow(String State, String NumStates, String IsLooped, String LoopInput, 
            String NextState, String NextStateOutput, String JumpState, String JumpTrans, String JumpInput)
    {
      this.State = State;
      this.NumStates = NumStates;
      this.IsLooped = IsLooped;
      this.LoopInput = LoopInput;
      this.NextState = NextState;
      this.NextStateOutput = NextStateOutput;
      this.JumpState = JumpState;
      this.JumpTrans = JumpTrans;
      this.JumpInput = JumpInput;
    }
    
    
    
    
    
    
       
 /* Really large ugly method. I didn't see many ways to split this that would
    have made it less complicated than it already is so I'll do my best to explain it*/ 

    public void showLoginScreen() {
        Stage stage = new Stage();
                
      Scene scene = null;         
      GridPane gridPane = null;   
      
      gridPane = new GridPane();   
      scene = new Scene(gridPane);
      

     
        VBox box = new VBox();

        box.setPadding(new Insets(10));


        box.setAlignment(Pos.CENTER);
  
      
        
      gridPane.setPadding(new Insets(20, 20, 20, 20)); 
      gridPane.setHgap(1);                            
      gridPane.setVgap(1);
      
 
 
 
         int nStates = Integer.parseInt(NumStates); 
         Circle circle = null;         
         int j = 2;
         int i = 0;
         int stringCounter;
         int nsCounter = 0;
         int isLoopedCounter = 0;
         
         
         for(stringCounter = 0; stringCounter < State.length(); stringCounter++)
         {
             
             
            /* Draws lines to next state*/  
            Line line = new Line(); 
            line.setStartX(10); 
            line.setStartY(10+j); 
            line.setEndX(10); 
            line.setEndY(50+j); 
            line.setStrokeLineCap(StrokeLineCap.ROUND);              
            gridPane.add(line, 4, j-2);

            
            /* Draws the input that leads to next state*/
            if(NextState.contains(Integer.toString(i)))
            {                 
            char NSch = NextStateOutput.charAt(nsCounter); 
            String NSstring = Character.toString(NSch);                        
            Label NSLabel = new Label(NSstring);
            NSLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 11));            
            gridPane.add(NSLabel, 3, j+1);
            nsCounter++;   
            } 
                              
            /* Draws the triangles for arrows*/           
            Polygon triangle = new Polygon(); 
            triangle.getPoints().setAll(
            5.0, 0.0,
            0.0, 10.0,
            10.0, 10.0
                );
            triangle.setRotate(180);  
            gridPane.add(triangle, 4, j-1);
            /* Draws state circles*/
            circle = new Circle(15);
            circle.setFill(Color.TRANSPARENT);
            circle.setStroke(Color.BLACK);
            gridPane.add(circle, 4, j);
            /* Labels state circles*/
            Label StateLabel = new Label(Integer.toString(i));
            StateLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
            gridPane.add(StateLabel, 3, j);

                        
            /* Draws loop criteria*/
            if(IsLooped.contains(Integer.toString(i)))  
            {

    
            Ellipse ellipse = new Ellipse( 20, 10);
            ellipse.setFill(Color.TRANSPARENT);
            ellipse.setStroke(Color.BLACK);
            gridPane.add(ellipse, 5, j);
    
            char ch = LoopInput.charAt(isLoopedCounter); 
            String string = Character.toString(ch); 
    
            Label LoopLabel = new Label(string);
            LoopLabel.setFont(Font.font("Verdana", 14));
            gridPane.add(LoopLabel, 6, j);
            isLoopedCounter++;
            }
   

            if(JumpState.contains(Integer.toString(i)))
            {
            /* Hands transition cases that different then state+1*/
            int Jcounter = 0;

    
            char jChars = JumpState.charAt(Jcounter);
            char jChart = JumpTrans.charAt(Jcounter);
            char jChari = JumpInput.charAt(Jcounter);
    
            String JString = Character.toString(jChari);
                int jsInt = Character.getNumericValue(jChars);
                int jtInt = Character.getNumericValue(jChart);  
          
            Line jline = new Line(); 
            jline.setStartX(10+j); 
            jline.setStartY(10); 
            jline.setEndX(45+j); 
            jline.setEndY(10); 
            jline.setStrokeLineCap(StrokeLineCap.ROUND);
            jline.getStrokeDashArray().addAll(2d, 5d);
            gridPane.add(jline, 2, j);
            
            Polygon jtriangle = new Polygon(); 
            jtriangle.getPoints().setAll(
            5.0, 0.0,
            0.0, 10.0,
            10.0, 10.0
                );
            jtriangle.setRotate(270);  
            gridPane.add(jtriangle, 1, j);
            
            /* Draws labels for input and State changeto*/
            Label jiLabel = new Label(JString);
            jiLabel.setFont(Font.font("Verdana",FontWeight.BOLD, 11));
            gridPane.add(jiLabel, 2, j);
        
            Label jtLabel = new Label(Integer.toString(jtInt));
            jtLabel.setFont(Font.font("Verdana",FontWeight.BOLD, 16));
            gridPane.add(jtLabel, 0, j);
               
    
}
                               
            stringCounter++;
            j += 3;    // spacing counter
            i++;       // state counter
         }
         
        stage.setScene(scene);
        stage.show();
    }














}








    
    
    
