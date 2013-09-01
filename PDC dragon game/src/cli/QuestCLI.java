package cli;

import java.util.ArrayList;
import logic.*;
import java.util.Scanner;

public class QuestCLI {
    
    private Quest q;
    private String[] comands;
    
    public QuestCLI(Quest q)
    {
        this.q = q;
        String[] com = {"help", "fight", "cancel"};
        this.commands = com;
        this.commandInterface();
    }
    
     private void commandInterface(){
        Scanner in = new Scanner(System.in);
        System.out.println(q.getName());
        System.out.println(q.getDescription());
        this.printCommands();
        String input = null;
        boolean exit = false;
        while(!exit){
            System.out.print("Quest: ");
            input = in.nextLine();
            switch(input){
                case "help" : printCommands();
                break;
                case "fight" : exit = conductFight();
                break;
                case "cancel" : exit = true;
                break;
                default : System.out.println("invalid command");
                System.out.println("enter help to see commands");
                break;
            }
        }
    }
    
    /**
     * Method for printing all of the commands available in the Quest Ledger menu
     */
    private void printCommands(){
        System.out.print("Commands: ");
        for(int i = 0; i < this.commands.length; i++){
            System.out.print(this.commands[i] + " ");
        }
        System.out.print("\n");
    }
    
    private boolean conductFight()
    {
        this.q.mission();
    }
    
}