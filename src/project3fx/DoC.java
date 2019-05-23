
package project3fx;

/**
 *
 * @author thear
 */
public class DoC {
    
    String State = "";
    String Transition ="";
    String Input = "";     
    
        
    String Instructions; 
    
    /**
     *
     * @param a
     */
    DoC(String c)
    {
        
     Instructions = c;          
    }
   
// Largest set of Instructions for actual drawing use    
public void SplitInstructions()
{        
    int stateCounter = 0;
    int index; 
    int transitionCounter = 0;

    for (index = 0; index < Instructions.length();index++) 
    {

    char aChar = Instructions.charAt(index);

    if ((Character.isDigit(aChar) == true)&&(stateCounter == 0)) 
    {
       State += aChar;
       stateCounter = 1;
       transitionCounter = 0;       
    }
    
    else if((Character.isDigit(aChar) == true) && (stateCounter == 1))
            {
            Transition += aChar;  
            transitionCounter = 1; 
            stateCounter = 1; 
        
            }
    
    else if((Character.isLetter(aChar) == true) && (stateCounter == 1) && (transitionCounter == 1))
            {
            Input += aChar; 
            stateCounter = 0;
            transitionCounter = 0;                           
            }
    
    else
            {
            //Skip
            }    
    }   
    

} 


String GetState()
{
        return State;   
}

String GetTransition()
{
        return Transition;   
}

String GetInput()
{
        return Input;   
}



String getInstructions()
{
        return Instructions;   
}

// The following methods are exclusively used for drawing the FSA
public String IsLooped()
{
    int counter = 0;
    String IsLooped ="";
    
    
   
    
  while(counter < State.length())
  {
     
    char aChar = State.charAt(counter); 

    if(Transition.charAt(counter) == State.charAt(counter))
    {
     
     IsLooped += aChar;    
        
    }
        counter++;
  }
    
return IsLooped;     
}


public String LoopInput()
{
    int counter = 0;
    String LoopInput ="";
    
    
   
    
  while(counter < State.length())
  {
     
    char aChar = Input.charAt(counter); 

    if(Transition.charAt(counter) == State.charAt(counter))
    {
     
     LoopInput += aChar;    
        
    }
        counter++;
  }
    
return LoopInput;     
}


public String NextState()
{
    int counter = 0;
    String NextState ="";
    

    
  while(counter < State.length())
  {
      // covers everything but last node state
        char aChar = State.charAt(counter);
        char bChar = Transition.charAt(counter);  

        
        int a = Character.getNumericValue(aChar);
        int b = Character.getNumericValue(bChar); 
   

    if(a == b)
    {
       
    }
    
    else if((a+1) == b)
    {
    NextState += aChar;    
    }
    
    else
    {
        
    }
    
        counter++;
        
        
  
  
  }
  
  
    
return NextState;     
}


public String NextStateOutput()
{
    int counter = 0;
    String NextStateOutput ="";
    
    
   
    
  while(counter < State.length())
  {
        char aChar = State.charAt(counter);
        char bChar = Transition.charAt(counter);
        char cChar = Input.charAt(counter); 

        
        int a = Character.getNumericValue(aChar);
        int b = Character.getNumericValue(bChar);


    if(a == b)
    {
       
    }
    
    else if((a+1) == b)
    {
    NextStateOutput += cChar;    
    }
    
    else
    {
        
    }
    
        counter++;
  }
    
return NextStateOutput;     
}




public String JumpState()
        
{
    String JumpState = "";
    int counter = 0;

    
    while (counter < State.length())
    {
        
        char aChar = State.charAt(counter);
        char bChar = Transition.charAt(counter);  

        
        int a = Character.getNumericValue(aChar);
        int b = Character.getNumericValue(bChar);

          
        if(a == b)
        {
                       
            
        }
        
        else if((a + 1) == (b))
        {
                        
        }
        else
        {            
         JumpState +=aChar;            
        }
                
        counter++;
    }

    return JumpState; 
}
    
    
public String JumpTrans()
        
{
    String JumpTrans = "";
    int counter = 0;

    
    while (counter < State.length())
    {
        
        char aChar = State.charAt(counter);
        char bChar = Transition.charAt(counter);  

        
        int a = Character.getNumericValue(aChar);
        int b = Character.getNumericValue(bChar);

          
        if(a == b)
        {
                       
            
        }
        
        else if((a + 1) == (b))
        {
                        
        }
        else
        {            
         JumpTrans +=bChar;            
        }
                
        counter++;
    }    
    
    
    
    
    return JumpTrans; 
}


public String JumpInput()
        
{
    String JumpInput = "";
    int counter = 0;

    
    while (counter < State.length())
    {
        
        char aChar = State.charAt(counter);
        char bChar = Transition.charAt(counter);  
        char cChar = Input.charAt(counter); 
        
        int a = Character.getNumericValue(aChar);
        int b = Character.getNumericValue(bChar);
          
        if(a == b)
        {
                       
            
        }
        
        else if((a + 1) == (b))
        {
                        
        }
        else
        {            
         JumpInput +=cChar;
            
        }
                
        counter++;
    }    
    
    
    
    
    return JumpInput; 
}







//Creates bad String
public String BadString()
{

    String BadString = "";    
    int counter = 0;
    
    while (counter < Input.length())
    {
        char c = Input.charAt(counter);
        BadString = BadString + c + c + c;
    
    counter++;
    }
    
       
    return BadString;
}






    
}