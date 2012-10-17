// imports needed java packages
import java.util.Scanner;

/**
 * This is the RuleBreaker class that handles the players and the rules.
 * 
 * @author Christopher Lindblom
 * @version 2012-10-12
 */
public class RuleBreaker
{
    // instance variables - replace the example below with your own
    private Team mTeam;
    private Scanner mScanner;

    /**
     * Constructor for objects of class RuleBreaker
     */
    public RuleBreaker()
    {   
        // save inital players names in a string array for later use
        String[] playerNames = { "Anders Andersson", "Karl Svensson", "Anton Viktorsson",
            "Frej Henriksson", "Greger Sivander", "Carl Alivio", "David Jakrén", "Algot Elvin",
            "Botvid Arg", "Sassi Frizon" };
        
        mTeam = new Team(playerNames);
        
        // add initial rules one-by-one
        mTeam.addRuleWithoutPrint("Sen ankomst träning", 50);
        mTeam.addRuleWithoutPrint("Sen ankomst match", 100);
        mTeam.addRuleWithoutPrint("Mobil som ringer under samling/genomgång", 50);
        mTeam.addRuleWithoutPrint("Glömd utrustning till bortamatch", 100);
        mTeam.addRuleWithoutPrint("Oreda på platsen", 50);
        mTeam.addRuleWithoutPrint("10 min misconduct", 100);
        mTeam.addRuleWithoutPrint("Matchstraff för snack", 200);
        mTeam.addRuleWithoutPrint("Hångel på lokal", 50);
        mTeam.addRuleWithoutPrint("Ta över någons ex", 300);
        mTeam.addRuleWithoutPrint("Avslagen klubba", 500);
        mTeam.addRuleWithoutPrint("Bild i tidningen:", 20);
        mTeam.addRuleWithoutPrint("Ramla på matchvärmning", 20);
        
        mScanner = new Scanner(System.in);
    }
    
    /**
     * The main menu and the entry point for the UI.
     */
    public void mainMenu()
    {
        // print the main menu
        System.out.println("-------------------------------------------");
        System.out.println("Välkommen till RuleBreaker!");
        System.out.println("Här administreras lagets spelregler med böter");
        System.out.println("Meny");
        System.out.println("1. Kör slumpning");
        System.out.println("2. Listor");
        System.out.println("3. Hantera spelare/regler\n");
        System.out.println("9. Avsluta\n");
        System.out.println("Vad vill du göra?");
        System.out.println("-------------------------------------------");
        
        // ask the user for its input
        System.out.print("> ");
        int choice = mScanner.nextInt();
        
        // handle the input from the user
        switch (choice)
        {
            case 1:
                    // ask the user how many weeks to simulate
                    System.out.print("Hur många veckor vill du slumpa fram? (1-24 veckor): ");
                    // run the simulator for the number of weeks the user asked for
                    simulatePlaying(mScanner.nextInt());
                    // show main menu again
                    mainMenu();
                    break;
            case 2: 
                    // show list menu
                    listMenu();
                    break;
            case 3:
                    // show management menu
                    managementMenu();
                    break;
            case 9: 
                    // exit program without any errors
                    System.exit(0);
                    break;
            default:
                    // if the user has entered something else
                    System.out.println("Ogiltigt alternativ.\n");
                    mainMenu();
        }
    }
    
    /**
     * The IU for showing lists.
     */
    private void listMenu()
    {
        // print the list menu
        System.out.println("ListMeny");
        System.out.println("1. Lista spelare");
        System.out.println("2. Lista regler\n");
        System.out.println("9. Åter huvudmeny\n");
        System.out.println("Vad vill du göra?");
        System.out.println("-------------------------------------------");
        
        // get input from user
        System.out.print("> ");
        int choice = mScanner.nextInt();
        
        // handle the users input
        switch (choice)
        {
            case 1:
                    // prints the players in the team
                    System.out.println("Samtliga spelare i laget:");
                    mTeam.printPlayers();
                    // shows this menu again
                    listMenu();
                    break;
            case 2: 
                    // prints the rules for the team
                    System.out.println("Samtliga regler för laget:");
                    mTeam.printRules();
                    // show this menu again
                    listMenu();
                    break;
            case 9: 
                    // go back to main menu
                    mainMenu();
                    break;
            default:
                    // if the user has entered something else
                    System.out.println("Ogiltigt alternativ.\n");
                    listMenu();
        }
    }
    
    /**
     * The IU for players and rules management.
     */
    private void managementMenu()
    {
        // prints the management menu
        System.out.println("Administrationsmeny\n");
        System.out.println("1. Lägg till spelare");
        System.out.println("2. Ta bort spelare");
        System.out.println("3. Lägg till regel\n");
        System.out.println("9. Åter huvudmeny\n");
        System.out.println("Vad vill du göra?");
        System.out.println("-------------------------------------------");
        
        // gets the user input
        System.out.print("> ");
        int choice = mScanner.nextInt();
        
        // handles the user input
        switch (choice)
        {
            case 1:
                    // asks the user for the new players name
                    System.out.print("Namn på den nya spelaren: ");
                    String newPlayer = mScanner.next();
                    // adds the user entered player name
                    addPlayer(newPlayer);
                    // shows this menu again
                    managementMenu();
                    break;
                    
            case 2: 
                    // asks the user for the name of the player to remove
                    System.out.print("Namn på spelaren som skall tas bort: ");
                    String playerToRemove = mScanner.next();
                    // removes the player
                    removePlayer(playerToRemove);
                    // shows this menu again
                    managementMenu();
                    break;
                    
            case 3: 
                    // asks the user what rule it wants to add
                    System.out.print("Regeln du vill lägga till: ");
                    String newRule = mScanner.next();
                    // asks the user for the fine to be set on the new rule
                    System.out.print("Bötesbeloppet på regeln (i kronor): ");
                    int newRuleFine = mScanner.nextInt();
                    // adds the new rule
                    addRule(newRule, newRuleFine);
                    // shows this menu again
                    managementMenu();
                    break;
                    
            case 9: 
                    // jump back to the main menu
                    mainMenu();
                    break;
                    
            default:
                    // if the user has entered something else
                    System.out.println("Ogiltigt alternativ.\n");
                    managementMenu();
        }
    }
    
    /**
     * Tell the team to add a player and print out a message.
     * 
     * @param   the players full name
     */
    public void addPlayer(String inName)
    {
        mTeam.addPlayer(inName);
    }
    
    /**
     * Tell the team to remove a player and print out a message.
     * 
     * @param   the full name of the player to be removed
     */
    public void removePlayer(String inName)
    {
        mTeam.removePlayer(inName);
    }
    
    /**
     * Tell the team to add a rule and print out a message.
     * 
     * @param   the description of the rule
     * @param   the fine you'll have to pay if you break it
     */
    public void addRule(String inRule, int inFine)
    {
        mTeam.addRule(inRule, inFine);
    }
    
    /**
     * Tell the team to simulate x number of weeks of playing and prints out a summary.
     * 
     * @param   the number of weeks (must be between 1 and 24)
     */
    public void simulatePlaying(int inWeeks)
    {
        mTeam.simulatePlaying(inWeeks);
    }
}
