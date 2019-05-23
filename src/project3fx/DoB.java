
package project3fx;

/**
 *
 * @author thear
 */
public class DoB {
    
        
    String Alphabet;
    String OutputAlphabet;
    
    /**
     *
     * @param b
     */
    DoB(String b)
    {
     OutputAlphabet = "";    
     Alphabet = b;          
    }
   
 // Alphabet of FSA
    public void SplitAlphabet()
{        
    int index; 

    for (index = 0; index < Alphabet.length();index++) 
    {

    char aChar = Alphabet.charAt(index);
    
    if((Character.isLetter(aChar) == true))
            {
            OutputAlphabet += aChar;                          
            }
    
    else
            {
            //Skip
            }    
    }   
    

} 






    
public void OutputAlphabet()
{    
    
   System.out.println("THIS IS FROM DO_A CLASS" + OutputAlphabet);  
    
}  

// The alphabet
String getAlphabet()
{
        return OutputAlphabet;   
}

///TODO 

//RETURN THE STRING OF ALPHABET WITHOUT COMMAS IN IT

    
}
