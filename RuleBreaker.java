
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
    private InputHandler mInput;

    /**
     * Constructor for objects of class RuleBreaker
     */
    public RuleBreaker()
    {    
        mTeam = new Team();
        mInput = new InputHandler();
    }
    
    /**
     * The main menu and the entry point for the UI.
     */
    public void mainMenu()
    {
        // print the main menu
        ScreenPrinter.print("-------------------------------------------");
        ScreenPrinter.print("Välkommen till RuleBreaker!");
        ScreenPrinter.print("Här administreras lagets spelregler med böter");
        ScreenPrinter.print("Meny");
        ScreenPrinter.print("1. Kör slumpning");
        ScreenPrinter.print("2. Listor");
        ScreenPrinter.print("3. Hantera spelare/regler\n");
        ScreenPrinter.print("9. Avsluta\n");
        ScreenPrinter.print("Vad vill du göra?");
        ScreenPrinter.print("-------------------------------------------");
        
        // ask the user for its input
        ScreenPrinter.printCarrot();
        
        int choice = mInput.inputInt();
        
        // handle the input from the user
        switch (choice)
        {
            case 1:
                    // ask the user how many weeks to simulate
                    ScreenPrinter.print("Hur många veckor vill du slumpa fram? (1-24 veckor): ");
                    ScreenPrinter.printCarrot();
                    
                    // run the simulator for the number of weeks the user asked for
                    ScreenPrinter.print(mTeam.simulatePlaying(mInput.inputInt()));
                    
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
                    ScreenPrinter.print("Ogiltigt alternativ.\n");
                    mainMenu();
        }
    }
    
    /**
     * The IU for showing lists.
     */
    private void listMenu()
    {
        // print the list menu
        ScreenPrinter.print("ListMeny");
        ScreenPrinter.print("1. Lista spelare");
        ScreenPrinter.print("2. Lista regler\n");
        ScreenPrinter.print("9. Åter huvudmeny\n");
        ScreenPrinter.print("Vad vill du göra?");
        ScreenPrinter.print("-------------------------------------------");
        
        // get input from user
        ScreenPrinter.printCarrot();
        int choice = mInput.inputInt();
        
        // handle the users input
        switch (choice)
        {
            case 1:
                    // prints the players in the team
                    ScreenPrinter.print("Samtliga spelare i laget:");
                    ScreenPrinter.print(mTeam.playerNames());
                    ScreenPrinter.print("");
                    // shows this menu again
                    listMenu();
                    break;
            case 2: 
                    // prints the rules for the team
                    ScreenPrinter.print("Samtliga regler för laget:");
                    ScreenPrinter.print(mTeam.teamRules());
                    ScreenPrinter.print("");
                    // show this menu again
                    listMenu();
                    break;
            case 9: 
                    // go back to main menu
                    mainMenu();
                    break;
            default:
                    // if the user has entered something else
                    ScreenPrinter.print("Ogiltigt alternativ.\n");
                    listMenu();
        }
    }
    
    /**
     * The IU for players and rules management.
     */
    private void managementMenu()
    {
        // prints the management menu
        ScreenPrinter.print("Administrationsmeny\n");
        ScreenPrinter.print("1. Lägg till spelare");
        ScreenPrinter.print("2. Ta bort spelare");
        ScreenPrinter.print("3. Lägg till regel\n");
        ScreenPrinter.print("9. Åter huvudmeny\n");
        ScreenPrinter.print("Vad vill du göra?");
        ScreenPrinter.print("-------------------------------------------");
        
        // gets the user input
        ScreenPrinter.printCarrot();
        int choice = mInput.inputInt();
        
        // handles the user input
        switch (choice)
        {
            case 1:
                    // asks the user for the new players name
                    System.out.print("Namn på den nya spelaren: ");
                    ScreenPrinter.printCarrot();
                    
                    String newPlayer = mInput.inputString();
                    // adds the user entered player name
                    ScreenPrinter.print(mTeam.addPlayer(newPlayer));
                    // shows this menu again
                    managementMenu();
                    break;
                    
            case 2: 
                    // asks the user for the name of the player to remove
                    ScreenPrinter.print("Namn på spelaren som skall tas bort: ");
                    String playerToRemove = mInput.inputString();
                    // removes the player
                    ScreenPrinter.print(mTeam.removePlayer(playerToRemove));
                    // shows this menu again
                    managementMenu();
                    break;
                    
            case 3: 
                    // asks the user what rule it wants to add
                    ScreenPrinter.print("Regeln du vill lägga till: ");
                    String newRule = mInput.inputString();
                    // asks the user for the fine to be set on the new rule
                    ScreenPrinter.print("Bötesbeloppet på regeln (i kronor): ");
                    ScreenPrinter.printCarrot();
                    int newRuleFine = mInput.inputInt();
                    // adds the new rule
                    ScreenPrinter.print(mTeam.addRule(newRule, newRuleFine));
                    // shows this menu again
                    managementMenu();
                    break;
                    
            case 9: 
                    // jump back to the main menu
                    mainMenu();
                    break;
                    
            default:
                    // if the user has entered something else
                    ScreenPrinter.print("Ogiltigt alternativ.\n");
                    managementMenu();
        }
    }
}
