
package project3fx;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author thear
 */

public class Instructions
{
// Instructions in FSA file
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String FSA;
        int counter = 0;
            
 Instructions(String FSA)
         {
         this.FSA = FSA; 
         a = "";     
         b = ""; 
         c = "";
         d = "";
         e = "";
         counter = 0;        
         }
        
        
public void Instructions() throws FileNotFoundException 
{
    

    // Subdivides them based on semicolons
      Scanner scanner; 
            scanner = new Scanner(new File(FSA));
        scanner.useDelimiter(";");
      
      while(scanner.hasNext())
      {
          
          a = scanner.next();
          counter++;
          b = scanner.next();
          counter++;
          c = scanner.next();
          counter++;
          d = scanner.next();
          counter++;
          e = scanner.next();
          counter++;
      }
    //System.out.println("::" + counter);

}

// Return strings for further use
    public String geta()
    {
      return a;
    }
    
    public String getb()
    {
      return b;
    }
        
    public String getc()
    {
      return c;
    }
        
    public String getd()
    {
      return d;
    }

    public String gete()
    {
      return e;
    }
    
    
    
}

