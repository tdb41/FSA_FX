/*
 * tdb41
 * 970390758
 */
package project3fx;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thear
 */
public class CoHandler {
    
public String FSA;    
    
CoHandler(String FSA)
{
    
 this.FSA = FSA; 
    
}   

// Handles all the functionality needed for the generation of lisp programs

/* I realize there is some repition here but it was more for the sake of 
 seperating this functionality entirely from everything that was done in Project 
3 to allow for possible expansion in the future*/
    public void CoHanlder()
    {
    
        Instructions obj = new Instructions(FSA); 
        
        
        try 
        {
            obj.Instructions();
                        
        DoA obja = new DoA(obj.geta());
        DoB objb = new DoB(obj.getb());
        DoC objc = new DoC(obj.getc());        
        

        DoD objd = new DoD(obj.getd());
        DoE obje = new DoE(obj.gete());
                                
 
        objb.SplitAlphabet();
        objc.SplitInstructions(); 
        obje.SplitAcceptState();

    
    // Actuall Project4 code so I'll only comment through this

        // Autofill
        BeepBoop bb = new BeepBoop(); 
        
        // Build the LISP program                
        LispMaker lspobj = new LispMaker(obja.getInstructions(), objc.GetState(), objc.GetTransition(), objc.GetInput(), obje.getOutputAcceptState());
        
        lspobj.MakeAFile();
        
            // use the autofill after the lisp program has been created to load into xlisp
            try 
            {
                bb.BeepBoop();
            } 
                        
            catch (IOException | AWTException | InterruptedException ex) {
                Logger.getLogger(CoHandler.class.getName()).log(Level.SEVERE, null, ex);
            }        
               
        
        }
        
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    
    }
    
    
    
    
}
