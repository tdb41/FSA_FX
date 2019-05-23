/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3fx;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 *
 * @author thear
 */
public class BeepBoop {
        
    
    
 // Used to autofill the lisp program generated into xlisp   
    public void BeepBoop() throws IOException,
                           AWTException, InterruptedException
    {
        String command = "xlwin32.exe";
        Runtime run = Runtime.getRuntime();
        run.exec(command);


            Thread.sleep(100);
 
 

        Robot robot = new Robot();
    // Input for xlisp 
        robot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_9);
        Thread.sleep(25);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_L);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_O);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_A);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_D);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_SPACE);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_QUOTE);
        Thread.sleep(25);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_O);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_U);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_T);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_PERIOD);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_L);        
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_S);        
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_P);        
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_QUOTE);
        Thread.sleep(25);
        robot.keyPress(KeyEvent.VK_0);
        Thread.sleep(25);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(25);        
        robot.keyPress(KeyEvent.VK_ENTER);

    
}
    
}
