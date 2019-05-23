
package project3fx;

/**
 *
 * @author thear
 */
public class Validator {
    
    private final String State; 
    private final String Transition;
    private final String Input; 
    private final String Validate; 
    private final String AcceptStateOutput;
    
// Checks whether the test string is valid  
    
    Validator(String State, String Transition, String Input, String Validate, String AcceptStateOutput)
    {
      this.State = State;
      this.Transition = Transition;
      this.Input = Input; 
      this.Validate = Validate;  
      this.AcceptStateOutput = AcceptStateOutput;
        
    }
    

// Main validate function
// Logic will be explained due to some ambiguousness    
    public int Validate()
    {
     // Iterator variables i for our test string and j for our FSA strings
     int i = 0;
     int j = 0;
     
     /* The while loop makes sure the main iterator doesn't go past the 
     strings outter bounds. The greater if statement checks if the character 
     in the validate string is in the expected input string, if it is, and if
     the state and transition state at the same index are equal we move the 
     test string counter forward, if it isn't move both counteters forward*/
     while (i < Validate.length())
     {
      if(Validate.charAt(i) == Input.charAt(j))
      {
        if(Transition.charAt(j) == State.charAt(j))
        {
            i++;
        }
        else 
        {
            i++;
            j++;
        }
          
      }
      
      
      
      /* If the outermost if statement isn't true move the expected input 
      counter forward, check if they are equal now, if they are (do the earlier
      check of state versus transition and adjust counters accordingly), if 
      the check again is unequal this is an error because the expected char does
      not equal the char in the test string (for a variety of error)*/
      
      else
      {
        j++;
        //System.out.println("Look at this:::::::: " + i);
        if(Validate.charAt(i) == Input.charAt(j))
        {
            if(Transition.charAt(j) == State.charAt(j))
            {
                i++;                
            }
            
            else
            {
                i++;
                j++;
            }

        }
        
        else
        {
            System.out.println("DANGER DANGER HIGH VOLTAGE");
            return -1; 
                        
        }
          
      }
         
         
         
     }
        
     
            return 1;      
    }
    
    // Check if the last char in test string ends on an accept state
         
     public int AcceptStateEnd()
     {
      int endState;
      char endCh;
      int checkIndex;
      int counter = 0;
      
      endState = Validate.length(); 
      
      endCh = Validate.charAt(endState-1); 
      
      checkIndex = Input.lastIndexOf(endCh);
      
      while(counter < AcceptStateOutput.length())
      {
          if(Transition.charAt(checkIndex) == AcceptStateOutput.charAt(counter))
          {
              return 1;              
          }
          
       counter ++;   
      }

      
      
      
      return -1; 
     }
     


    
}
