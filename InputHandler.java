
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
        mScanner = new Scanner(System.in);
    }

    /**
     * Gets a string form the user
     * 
     * @return  a string from the user
     */
    public String inputString()
    {
        String result = "";
        
        while(mScanner.hasNext())
        {
            result += mScanner.next();
        }
        
        return result;
    }
    
    /**
     * Gets an integer from the user
     * 
     * @return  the integer from the user (returns -1 if user didn't input an integer)
     */
    public int inputInt()
    {
        int result = -1;
        
        result = mScanner.nextInt();
        
        // discard everything else
        while(mScanner.hasNext())
        {
            mScanner.next();
        }
        
        return result;
    }
}
