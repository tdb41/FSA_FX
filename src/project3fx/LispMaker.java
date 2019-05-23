/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3fx;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thear
 */
public class LispMaker {
    
private final String NumStates;
private final String Input; 
private final String Transition;
private final String State; 
private final String AcceptStates;
    
    
LispMaker(String NumStates, String State, String Transition, 
        String Input, String AcceptStates)  
{        
    
 this.NumStates = NumStates;
 this.Input = Input;
 this.Transition = Transition;
 this.State = State; 
 this.AcceptStates = AcceptStates;
        
    
}




public void MakeAFile()
{
   int i = 0;
   int j = 0;
   
   
   // Write the lisp program to file
    try {    
        PrintWriter pw = new PrintWriter(new FileWriter("out.lsp"));
        
    
    // Introduction part    
        pw.println("(defun demo()");
        pw.println("(setq fp (open \"theString.txt\" :direction :input))");
        pw.println("(setq x (read fp \"done\"))");
        pw.println("(State_0 x)");
        pw.println(")");

        
    // Overall loop for reptition part
        while( i < Integer.parseInt(NumStates))
        {
            // Increment function names and start the conditional statement
            pw.println("(defun State_" + i + "(x)");
            pw.println(" (COND");
            
            
            // Covers every kind of state change and accept state case for the body of each function
            while ((j < State.length()) && (i == Character.getNumericValue(State.charAt(j))))
            {
                

   
              if( true == AcceptStates.contains(Character.toString(State.charAt(j))))                  
              { 
                  
                if(State.charAt(j) == State.charAt(j-1))
                {
                    //Skip
                }
                
                else
                {                    
                pw.println("((ATOM x) T)");                    
                }

              }
                
              
                
                
              if(Transition.charAt(j) == State.charAt(j))
              {
                pw.println("((EQUAL '" + Input.charAt(j) + " (CAR x)) " + "(State_" + i + "(CDR x)))");

              }
              
              else
              {
                pw.println("((EQUAL '" + Input.charAt(j) + " (CAR x)) " + "(State_" + Transition.charAt(j) + "(CDR x)))");   
                  
              }
                
             j++;   
                
            }
            
            pw.println(" )");
            pw.println(")");
            pw.println("");
            
            
            // Loop to add several functions in a row based on number of states
            i++;
        }
        pw.close();
    } 
    
    catch (IOException ex) 
    {
        Logger.getLogger(LispMaker.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    
    
}



}
