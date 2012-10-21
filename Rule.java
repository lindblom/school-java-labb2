/**
 * This is the Rule class, representing a rule.
 * 
 * @author Christopher Lindblom
 * @version 2012-10-21
 */
public class Rule
{
    // instance variables
    private String mRule;
    private int mFine;

    /**
     * Constructor for objects of class Rule
     * 
     * @param   the description of the rule
     * @param   the fine you have to pay if you break the rule
     */
    public Rule(String inRule, int inFine)
    {
        // initialise instance variables
        mFine = inFine;
        mRule = inRule;
    }
    
    /**
     * Get method for the fine
     * 
     * @return  returns the fine for the rule
     */
    public int getFine()
    {
        return mFine;
    }
    
    /**
     * Overridden toString method
     * 
     * @return  a string that consists of the rule and fine
     */
    public String toString()
    {
        return mRule + " – bötesbelopp: " + mFine + " kr";
    }
}
