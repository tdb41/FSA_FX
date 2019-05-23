/*
 * tdb41
 * 970390758
 */
package project3fx;

/**
 *
 * @author thear
 */
public class DoD {
    
        
    String InitState; 
    
    /**
     *
     * @param a
     */
    DoD(String d)
    {
        
     InitState = d;          
    }
   
// Test method     
public void Output()
{    
    
   System.out.println("THIS IS FROM DO_D CLASS" + InitState);  
    
}

String getInitState()
{
        return InitState;   
}

// THIS IS THE INITIAL STATE 
// Not used in current iteration of program

    
}

