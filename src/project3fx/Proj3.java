
package project3fx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Proj3 extends Application {
   private Label FSALabel; 
   private Label STRINGLabel; 
   private TextField STRINGField;  
   private TextField FSAField; 
   private Button calcButton;   
   private TextField OUTPUTField;
   private Button lispButton;
   private Button prologButton;
   
   @Override
   public void start(Stage applicationStage) {
      Scene scene = null;       
      GridPane gridPane = null;  
      
      gridPane = new GridPane();  
      scene = new Scene(gridPane); 
      

      
      /* Sets up menu*/
      FSALabel = new Label("FSA:");
      STRINGLabel = new Label("TestString:");
      
      FSAField = new TextField(); 
      FSAField.setPrefColumnCount(15);
      FSAField.setEditable(true);
      FSAField.setText("fsa1.txt");

      
      OUTPUTField = new TextField(); 
      OUTPUTField.setPrefColumnCount(15);
      OUTPUTField.setEditable(false);
      OUTPUTField.setText("?");
      
      
      STRINGField = new TextField(); 
      STRINGField.setPrefColumnCount(15);
      STRINGField.setEditable(true);
      STRINGField.setText("legal1.txt");

      
      // Create a "Calculate" button
      calcButton = new Button("String Check");
      lispButton = new Button("Create LISP Prog");
      prologButton = new Button("Create Prolog Prog");
      
      gridPane.setPadding(new Insets(20, 20, 20, 20)); 
      gridPane.setHgap(10);                            
      gridPane.setVgap(15);                 
      
      gridPane.add(FSALabel, 0, 0);  
      gridPane.add(FSAField, 1, 0);  
      gridPane.add(STRINGLabel, 0, 1);   
      gridPane.add(STRINGField, 1, 1);  
      gridPane.add(calcButton, 0, 2); 
      gridPane.add(OUTPUTField, 1, 3); 
      gridPane.add(lispButton, 1, 2);
      gridPane.add(prologButton, 1, 4); 

      




 // Even New Button!     
    /* Ties all Project5 functionality together, and utilizes the 
    simplistic menu setup of project 3 */  
    prologButton.setOnAction(new EventHandler<ActionEvent>() { 
 
         @Override
         public void handle(ActionEvent event) {
         String PROLOGfsa;  
         
         PROLOGfsa = FSAField.getText(); 
         
         
        // Make sure the FSA field is filled     
            if("".equals(PROLOGfsa))
            {
                OUTPUTField.setText("Field required");  
                return;
            }
            
            
            
            CoPHandler copobjHandler = new CoPHandler(PROLOGfsa); 
         
        // Start the show    
            copobjHandler.CoPHanlder();
            
        // Tell the user the file has been created    
            OUTPUTField.setText("File created");
         }        
        

    });












      
 // New Button!     
    /* Ties all Project4 functionality together, and utilizes the 
    simplistic menu setup of project 3 */  
    lispButton.setOnAction(new EventHandler<ActionEvent>() { 
 
         @Override
         public void handle(ActionEvent event) {
         String LISPfsa;  
         
         LISPfsa = FSAField.getText(); 
         
         
        // Make sure the FSA field is filled     
            if("".equals(LISPfsa))
            {
                OUTPUTField.setText("Field required");  
                return;
            }
            
            
            
            CoHandler cobjHandler = new CoHandler(LISPfsa); 
         
        // Start the show    
            cobjHandler.CoHanlder();
            
            
            
         }        
        
        
    });    
    
      
      
      
      
      

      calcButton.setOnAction(new EventHandler<ActionEvent>() {
         /* The button that handles everything*/
         @Override
         public void handle(ActionEvent event) {
            String FSA; 
            String TestString;    


            FSA = FSAField.getText();
            TestString = STRINGField.getText();
        /* If there's no input it returns with an error*/    
            if("".equals(TestString) || "".equals(FSA))
            {
                OUTPUTField.setText("Both fields required");  
                return;
            }

        Handler objHandler = new Handler(FSA, TestString);
        
            objHandler.Handler();
            
            int sum;
            int check = objHandler.getCheck1(); 
            int check2 = objHandler.getCheck2();
            
            sum = check + check2;
               
            if(sum == 2)
            {
                OUTPUTField.setText("Valid!");                
            }
            else
            {
                OUTPUTField.setText("Invalid!");                
            }    
                       
         } 
      });

      applicationStage.setScene(scene);    // Set window's scene  
      applicationStage.setTitle("Project 3 FSA"); // Set window's title
      applicationStage.show();             // Display window
   }
   
   public static void main(String [] args) {
      launch(args); // Launch application
   }
}