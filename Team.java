// imports needed java packages
import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Team here.
 * 
 * @author Christopher Lindblom
 * @version 2012-10-21
 */
public class Team
{
    // instance variables - replace the example below with your own
    private RuleBook mRuleBook;
    private ArrayList<Player> mPlayers;
    private int mWeeks;

    /**
     * Main contructor for objects of class Team
     */
    public Team()
    {
        // initialise instance variables
        mRuleBook = new RuleBook();
        mPlayers = new ArrayList<Player>();
        
        loadInitialRules();
        
        String[] initialPlayerNames = { "Anders Andersson", "Karl Svensson", "Anton Viktorsson",
            "Frej Henriksson", "Greger Sivander", "Carl Alivio", "David Jakrén", "Algot Elvin",
            "Botvid Arg", "Sassi Frizon" };
           
        loadInitialPlayers(initialPlayerNames);
    }
    
    /**
     * A loader method that takes a string array of player names and adds them as players.
     * 
     * @param   string array of player names 
     */    
    private void loadInitialPlayers(String[] inPlayerNames)
    {
        // iterate over player names and add them to mPlayers
        for (String name : inPlayerNames)
        {
            mPlayers.add(new Player(name));
        }
    }
    
    /**
     * A loader method for loading initial rules for the team.
     */
    private void loadInitialRules()
    {
        // add initial rules one-by-one
        mRuleBook.add(new Rule("Sen ankomst träning", 50));
        mRuleBook.add(new Rule("Sen ankomst match", 100));
        mRuleBook.add(new Rule("Mobil som ringer under samling/genomgång", 50));
        mRuleBook.add(new Rule("Glömd utrustning till bortamatch", 100));
        mRuleBook.add(new Rule("Oreda på platsen", 50));
        mRuleBook.add(new Rule("10 min misconduct", 100));
        mRuleBook.add(new Rule("Matchstraff för snack", 200));
        mRuleBook.add(new Rule("Hångel på lokal", 50));
        mRuleBook.add(new Rule("Ta över någons ex", 300));
        mRuleBook.add(new Rule("Avslagen klubba", 500));
        mRuleBook.add(new Rule("Bild i tidningen:", 20));
        mRuleBook.add(new Rule("Ramla på matchvärmning", 20));
    }
    
    /**
     * Adds a player to the collection of players and returns a message.
     * 
     * @param   the players full name
     * @return  a message reporting that the player was added
     */
    public String addPlayer(String inName)
    {
        mPlayers.add(new Player(inName));
        return "Spelaren " + inName + " är nu en i laget!";
    }
    
    /**
     * Removes a player from the collection of players and returns a report message
     * 
     * @param   full name of the player to be removed
     * @return  report message
     */
    public String removePlayer(String inName)
    {
        // sets playerToRemove to null
        Player playerToRemove = null;
        String returnMessage = "";
        
        // iterate over players to find one with the desired name
        for(Player player : mPlayers)
        {
            
            if(player.toString().equalsIgnoreCase(inName))
            {
                // sets playerToRemove to the found player
                playerToRemove = player;
            }
        }
        
        // if the player isn't still null
        if(playerToRemove != null)
        {
            // we remove the player and print out a message about it
            mPlayers.remove(playerToRemove);
            returnMessage = "Spelaren " + playerToRemove + " är nu borttagen ur laget!";
        }
        else
        {
            // otherwise we print out a message notifying that we didn't fint the player
            returnMessage = "Det fanns ingen spelare vid namn " + inName + " i laget!";
        }
        
        return returnMessage;
    }
  
    /**
     * Adds a rule to the collection of rules and return a message.
     * 
     * @param   the description of the rule
     * @param   the fine you'll have to pay if you break it
     * @return  a summary of the new rule
     */
    public String addRule(String inRule, int inFine)
    {
        return mRuleBook.add(new Rule(inRule, inFine));
    }
    
    /**
     * Simulate playing x number of weeks and prints out a summary.
     * 
     * @param   the number of weeks (must be between 1 and 24)
     * @return  a summary of what happend
     */
    public String simulatePlaying(int inWeeks)
    {
        // sets inWeeks to 0 unless its within the allowed rage
        if(inWeeks < 1 || inWeeks > 24)
        {
            inWeeks = 0;
        }
        
        // every week
        for(int week = 1; week <= inWeeks; week++)
        {
            // randomize a number of broken rules between 0 and the total number of rules
            int brokenRulesThisWeek = new Random().nextInt(mRuleBook.size() + 1);
            
            // for every broken rule this week
            for(int i = 0; i < brokenRulesThisWeek; i++)
            {
                // and added to a random player
                addBrokenRuleToRandomPlayer(mRuleBook.randomRule());
            }
        }
        
        String returnMessage = "";
        
        // if a valid value was given for inWeeks
        if(inWeeks != 0)
        {
            // add weeks and print the summary
            mWeeks += inWeeks;
            returnMessage = simulationSummary();
        }
        else
        {
            // otherwise print a message telling the user that the input was invalid
            returnMessage = "Antalet veckor att simulera måste vara mellan 1 och 24.";
        }
        
        return returnMessage;
    }
    
    /**
     * Returns a summary of the simulated weeks.
     * 
     * @return a summary
     */
    private String simulationSummary()
    {
        String returnString = "";
        returnString += "Antal veckor: " + mWeeks + " veckor\n";
        returnString += "Totalt antal spelare som brutit mot regler: " + playersWithBrokenRules() + " st\n";
        returnString += "Totalt antal spelregler som brutits: " + numberOfBrokenRules() +" st\n\n";
        
        returnString += "Total summa till laget: " + fineAmountOfBrokenRules() + " kronor\n\n";
        
        // add the player summary for every player
        for(Player player : mPlayers)
        {
            returnString += player.summary() + "\n";
        }
        
        return returnString;
    }
    
    /**
     * Adds a broken rule to a random player.
     * 
     * @param   the rule that has been broken
     */
    private void addBrokenRuleToRandomPlayer(Rule brokenRule)
    {
        // randomly select a player
        Player randomPlayer = mPlayers.get(new Random().nextInt(mPlayers.size()));
        
        // add the broken rule to the player
        randomPlayer.addBrokenRule(brokenRule);
    }
    
    /**
     * Counts the number of players that has broken atleast one rule
     * 
     * @return   the number of players with broken rules
     */
    private int playersWithBrokenRules()
    {
        int ruleBreakers = 0;
        
        // checks every player for broken rules and adds one to the count of rules breakers if they are
        for(Player player : mPlayers)
        {
            if(player.isARuleBreaker())
            {
                ruleBreakers++;
            }
        }
        
        return ruleBreakers;
    }
    
    /**
     * Counts the total number misdeeds committed by the players
     * 
     * @return   the number of broken rules
     */
    private int numberOfBrokenRules()
    {
        int brokenRules = 0;
        
        // adds every players number of broken rules to the broken rules count
        for(Player player : mPlayers)
        {
            brokenRules += player.numberOfBrokenRules();
        }
        
        return brokenRules;
    }
    
    /**
     * Adds up the total amount of all the players fines
     * 
     * @return   the total fine amount for the team
     */
    private int fineAmountOfBrokenRules()
    {
        int sum = 0;
        
        // adds the total fine amount for every player to the sum of the team
        for(Player player : mPlayers)
        {
            sum += player.fineAmountOfBrokenRules();
        }
        
        return sum;
    }
    
    /**
     * The Team rules as a String array.
     * 
     * @return team rules
     */
    public String[] teamRules()
    {
        return mRuleBook.rules();
    }
    
    /**
     * Player names as a String array.
     * 
     * @return player names
     */
    public String[] playerNames()
    {
        ArrayList<String> playerNames = new ArrayList<String>();
        
        for(Player player : mPlayers)
        {
            // prints the player by using the overridden toString method
            playerNames.add(player.toString());
        }
        
        return playerNames.toArray(new String[playerNames.size()]);
    }
}
