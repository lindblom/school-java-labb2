import java.util.ArrayList;
import java.util.Random;

/**
 * RuleBook is a class that handles a collection of Rules.
 * 
 * @author Christopher Lindblom
 * @version 2012-10-17
 */
public class RuleBook
{
    // instance variables - replace the example below with your own
    private ArrayList<Rule> mRules;
    private Random mRandom;

    /**
     * Constructor for objects of class RuleBook
     */
    public RuleBook()
    {
        mRules = new ArrayList<Rule>();
    }
    
    /**
     * Prints all the rules as a list.
     */
    public void printRules()
    {
        for(Rule rule : mRules)
        {
            // prints the rule by using the overridden toString method
            System.out.println(rule);
        }
    }
    
    /**
     * Returns a random rule from the rule book
     * @return  a random rule
     */
    public Rule randomRule()
    {
        return mRules.get(new Random().nextInt(mRules.size()));
    }
}
