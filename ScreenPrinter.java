
/**
 * ScreenPrinter is a class that prints strings to screen.
 * 
 * @author Christopher Lindblom 
 * @version 2012-10-21
 */
public class ScreenPrinter
{
    /**
     * Constructor for objects of class ScreenPrinter
     */
    public ScreenPrinter()
    {
    }

    /**
     * Prints string to the console
     * 
     * @param   string  the string to be printed
     */
    public static void print(String string)
    {
        System.out.println(string);
    }
    
    /**
     * Prints an array of strings to the console
     * 
     * @param   stringArray  the array of strings to be printed
     */
    public static void print(String[] stringArray)
    {
        for(String string : stringArray)
        {
            print(string);   
        }
    }
}
