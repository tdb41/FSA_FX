/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class CoPHandler {
    
    public String FSA;    
    
CoPHandler(String FSA)
{
    
 this.FSA = FSA; 
    
}   

// Handles all the functionality needed for the generation of lisp programs

/* I realize there is some repition here but it was more for the sake of 
 seperating this functionality entirely from everything that was done in Project 
3 to allow for possible expansion in the future*/
    public void CoPHanlder()
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
            
    // Actual Project5 code so I'll only comment through this

        
        // Build the Prolog program                
        PrologMaker plgobj = new PrologMaker(objc.GetState(), objc.GetTransition(), objc.GetInput(), obje.getOutputAcceptState(), objc.BadString());
        
        plgobj.MakeAFile();
        
            // use the autofill after the prolog program has been created to load into xlisp
            
        }
        
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    
}
    
}
