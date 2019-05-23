
package project3fx;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Handler {

public String FSA;
public String TestString;
int check1; 
int check2;
    
Handler(String FSA, String TestString)
{
    
 this.FSA = FSA; 
 this.TestString = TestString;
    
}
    
 /// Organizes how everything runs   
    
    public void Handler()  {
                
        Instructions obj = new Instructions(FSA);
        ValidateString objS = new ValidateString(TestString);

// Splits the instructions read from FSA string and divides them amongst subclasses        
        try 
        {
            obj.Instructions();
                        
        DoA obja = new DoA(obj.geta());
        DoB objb = new DoB(obj.getb());
        DoC objc = new DoC(obj.getc());        
        
        // This isn't really used because an initial state check is handled by validator
        // But it's here for future purposes and structural ones
        DoD objd = new DoD(obj.getd());
        DoE obje = new DoE(obj.gete());
                                
 
    // Do the prep work
        objb.SplitAlphabet();
        objc.SplitInstructions(); 
        obje.SplitAcceptState();
        objS.Instructions();
    
    // the classes that utilize the prep work just done    
        Validator objV = new Validator(objc.GetState(),objc.GetTransition(),
                objc.GetInput(),objS.getTestString(),obje.getOutputAcceptState());
        
    // the FSA drawing window    
        SecondWindow popup = new SecondWindow(objc.GetState(), 
                obja.getInstructions(), objc.IsLooped(), objc.LoopInput(), 
                objc.NextState(), objc.NextStateOutput(), objc.JumpState(), 
                objc.JumpTrans(), objc.JumpInput()); 
        
    //variables given to menu window for output    
        check1 = objV.Validate();
        check2 = objV.AcceptStateEnd();
        
        
        
       
               
    // The Draw Screen    
        popup.showLoginScreen();
                       
        } 
                
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
            

        }
        
       
        public int getCheck1()
        {
            
          return check1;                          
        }

        public int getCheck2()
        {
            
          return check2;                          
        }
    
    
    
    }