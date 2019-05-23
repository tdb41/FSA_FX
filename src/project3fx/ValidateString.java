/*
 * tdb41
 * 970390758
 */
package project3fx;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author thear
 */

// Get's Test String
public class ValidateString {
    
    public String TestString;
    public String Testable; 
    
    
    
    ValidateString(String TestString)
    {
        Testable = ""; 
        this.TestString = TestString;        
    }
    
 
public void Instructions() throws FileNotFoundException 
{
    

    
      Scanner scanner; 
            scanner = new Scanner(new File(TestString)); 
            
      while(scanner.hasNext())
      {        
          Testable = scanner.next();
      }

}    
    
    
    
    
    
    
    
public String getTestString()
{
    return Testable;    
}
    
    
    
    
    
}
