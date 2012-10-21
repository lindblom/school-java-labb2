
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
        return mScanner.nextLine();
    }
    
    /**
     * Gets an integer from the user
     * 
     * @return  the integer from the user
     */
    public int inputInt()
    {
        int result = mScanner.nextInt();
        mScanner.nextLine();
        return result;
    }
}
