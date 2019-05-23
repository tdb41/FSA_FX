/*
 * tdb41
 * 970390758
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
public class PrologMaker {
    
private final String Input; 
private final String Transition;
private final String State; 
private final String AcceptStates;
private final String BadString;
    
    
PrologMaker(String State, String Transition, 
        String Input, String AcceptStates, String BadString)  
{        
    
 this.Input = Input;
 this.Transition = Transition;
 this.State = State; 
 this.AcceptStates = AcceptStates;
 this.BadString = BadString;
        
    
}




public void MakeAFile()
{
   int i = 0;
   int j = 0;
   int k = 0;
   int m = 0;
   
   
   // Write the lisp program to file
    try {    
        PrintWriter pw = new PrintWriter(new FileWriter("out.pl"));
        
    
    // Start and Accept States    
        
        pw.println("start(0).");
        // This one can be assumed and therefore printed always

    while( i < AcceptStates.length())
    {
        pw.println("accept(" + AcceptStates.charAt(i) + ").");
        i++;
    }    
       
        pw.println("");
        
    // Representing the FSA in prolog
        while( j < State.length())
        {
            pw.println("move(" + State.charAt(j) + "," + Transition.charAt(j) + "," + Input.charAt(j) + ").");
            j++;
        }

        pw.println("");
        pw.println("");        
     
    // Recurse through the given list    
        pw.println("recog(State,[]) :-");
        pw.println("accept(State).");
        pw.println("");        
        pw.println("recog(State1,String) :-");
        pw.println("move(State1,State2,Letter),");
        pw.println("step(Letter,String,NewString),");
        pw.println("recog(State2,NewString).");
        pw.println("");
        pw.println("step(Letter,[Letter|TString],TString).");
        pw.println(""); 
        pw.println("");        
        pw.println("fsa(TString) :-");
        pw.println("start(State),");
        pw.println("recog(State,TString).");
        pw.println("");
        pw.println("");


        
        
        
    // Deals with giving the program good and bad strings to call    
        pw.print("good :- fsa([");         
        while(k < Input.length()-2)
        {
            pw.print(Input.charAt(k) + ",");
            k++;
        }
        
        int lastchar = Input.length(); 
        
        pw.print(Input.charAt(lastchar-1) + "]).");
        pw.println("");
        
        
        pw.print("bad :- fsa([");         
        while(m < BadString.length()-2)
        {
            pw.print(BadString.charAt(k) + ",");
            m++;
        }
        
        int lastchr = BadString.length(); 
        
        pw.print(BadString.charAt(lastchr-1) + "]).");
        pw.println("");        

        
        pw.close();
    } 
    
    catch (IOException ex) 
    {
        Logger.getLogger(LispMaker.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    
    
}
    
    
    
    
}
