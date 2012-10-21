// imports needed java packages
import java.util.ArrayList;

/**
 * The Player class, representing a player.
 * 
 * @author Christopher Lindblom
 * @version 2012-10-14
 */
public class Player
{
    // instance variables
    private String mName;
    private RuleBook mBrokenRules;

    /**
     * Constructor for objects of class Player
     * 
     * @param   the name of the player
     */
    public Player(String inName)
    {
        // initialise instance variables
        mName = inName;
        mBrokenRules = new RuleBook();
    }
    
    /**
     * Adds a rule to the ArrayList of broken rules
     * 
     * @param   the broken rule to be added
     * @return  a message about the rule being added
     */
    public String addBrokenRule(Rule inBrokenRule)
    {
        return mBrokenRules.add(inBrokenRule);
    }
    
    /**
     * Returns the number of rules the player has broken
     * 
     * @return  number of rules the player has broken
     */
    public int numberOfBrokenRules()
    {
        return mBrokenRules.size();
    }
    
    /**
     * The total amount of the fines the player as collected
     * 
     * @return  the total amount if the fines
     */
    public int fineAmountOfBrokenRules()
    {
        return mBrokenRules.sum();
    }
    
    /**
     * A summary of the player
     * 
     * @return  a string with the player summary
     */
    public String summary()
    {
        String summary = mName;
        
        if(isARuleBreaker())
        {
            summary += " – " + numberOfBrokenRules() + " st regelbrott, " + fineAmountOfBrokenRules() + " kronor";
        }
        else
        {
            summary += " – INGA regelbrott!";
        }
        
        return summary;
    }
    
    /**
     * Checks if the player has broken any rules
     * 
     * @return  true if the player has broken any rules
     */
    public boolean isARuleBreaker()
    {
        return mBrokenRules.size() > 0;
    }
    
    /**
     * Overridden toString method
     * 
     * @return  a string that consists of the players name
     */
    public String toString()
    {
        return mName;
    }
}
