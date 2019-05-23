
package project3fx;

/**
 *
 * @author thear
 */
public class DoE {
    
        
    String AcceptState;
    String OutputAcceptState;
    
    /**
     *
     * @param b
     */
    DoE(String b)
    {
     OutputAcceptState = "";    
     AcceptState = b;          
    }
   
 //Get the accept states and removes commas
    public void SplitAcceptState()
{        
    int index; 

    for (index = 0; index < AcceptState.length();index++) 
    {

    char aChar = AcceptState.charAt(index);
    
    if((Character.isDigit(aChar) == true))
            {
            OutputAcceptState += aChar;                          
            }
    
    else
            {
            //Skip
            }    
    }   
    

} 






    
public void OutputAcceptState()
{    
    
   System.out.println("THIS IS FROM DO_A CLASS" + OutputAcceptState);  
    
}  

// The alphabet
String getOutputAcceptState()
{
        return OutputAcceptState;   
}

///TODO 

//RETURN THE STRING OF ALPHABET WITHOUT COMMAS IN IT

    
}

