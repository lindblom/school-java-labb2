
// imports needed java packages
import java.util.Scanner;

/**
 * Handles user input.
 * 
 * @author Christopher Lindblom
 * @version 2012-10-21
 */
public class InputHandler
{
    // instance variables - replace the example below with your own
    private Scanner mScanner;

    /**
     * Constructor for objects of class InputHandler
     */
    public InputHandler()
    {
        // initialise instance variables
        mScanner = new Scanner(System.io);
    }

    /**
     * Get a string form the user
     * 
     * @return  a string from the user
     */
    public String stringInput()
    {
        String result = "";
        
        while(mScanner.hasNext())
        {
            result += mScanner.next();
        }
        
        return result;
    }
}
