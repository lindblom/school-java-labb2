import java.util.ArrayList;
import java.util.Random;

/**
 * RuleBook is a class that handles a collection of Rules.
 * 
 * @author Christopher Lindblom
 * @version 2012-10-21
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
     * Returns all the rules as a string array.
     * 
     * @return  an array of strings with the description of the rules 
     */
    public String[] rules()
    {
        ArrayList<String> response = new ArrayList<String>();
        
        for(Rule rule : mRules)
        {
            // add the rule by using the overridden toString method
            response.add(rule.toString());
        }
        
        // converts the ArrayList to an Array of Objects.
        // the, casts them to be Strings (as we know they are).
        return response.toArray(new String[response.size()]);
    }
    
    /**
     * Adds a rule to the collection of rules and returns a message.
     * 
     * @param   the rule to be added
     * @return  a message saying that the rules has been added
     */
    public String add(Rule inRule)
    {
        mRules.add(inRule);
        return "Ny regel tillagd: " + inRule;
    }
    
    /**
     * The sum of the fees of all the rules
     * 
     * @return  the sum
     */
    public int sum()
    {
        int sum = 0;
        
        for(Rule rule : mRules)
        {
            sum += rule.getFine();
        }
        
        return sum;
    }
    
    /**
     * Check the number of rules in the rule book.
     * 
     * @return  the number of rules
     */
    public int size()
    {
        return mRules.size();
    }
    
    /**
     * Returns a random rule from the rule book
     * 
     * @return  a random rule
     */
    public Rule randomRule()
    {
        return mRules.get(new Random().nextInt(mRules.size()));
    }
}
