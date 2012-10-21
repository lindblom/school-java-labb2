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
     * 
     * @return  an array of strings with the description of the rules 
     */
    public String[] printRules()
    {
        ArrayList<String> response = new ArrayList<String>();
        
        for(Rule rule : mRules)
        {
            // add the rule by using the overridden toString method
            response.add(rule);
        }
        
        // converts the ArrayList to an Array.
        return response.toArray();
    }
    
    /**
     * Adds a rule to the collection of rules and prints out a message.
     * 
     * @param   the description of the rule
     * @param   the fine you'll have to pay if you break it
     */
    public String addRule(String inRule, int inFine)
    {
        Rule newRule = new Rule(inRule, inFine);
        mRules.add(newRule);
        return "Ny regel tillagd: " + newRule;
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
