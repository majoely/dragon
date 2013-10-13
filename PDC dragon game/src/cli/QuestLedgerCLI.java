package cli;

import java.util.ArrayList;
import logic.*;
import java.util.Scanner;

public class QuestLedgerCLI{
    
    private QuestLedger questLog;
    private String[] commands;
    
    @SuppressWarnings("empty-statement")
    public QuestLedgerCLI(QuestLedger questLog){
        this.questLog = questLog;
        String[] com = {"help", "start", "current", "completed", "player"};
        this.commands = com;
        this.commandInterface();
    }
    
     private void commandInterface(){
        Scanner in = new Scanner(System.in);
        this.printCommands();
        String input = null;
        boolean exit = false;
        while(!exit){
            System.out.print("Quest Ledger: ");
            input = in.nextLine();
            switch(input){
                case "help" : printCommands();
                break;
                case "start" : startQuest();
                break;
                case "current" : listCurrent();
                break;
                case "completed" : listCompleted();
                break;
                case "player" : exit = true;
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
            System.out.print(this.commands[i] + "  ");
        }
        System.out.print("\n");
    }
    
    /**
     * allows the player to go on quests.
     * Prompt the player for the index number of the quest to find and start it
     */
     private void startQuest(){
        Quest q = questLog.goToQuest();
        QuestCLI qcli = new QuestCLI(q);
        if (q.isComplete())
        {
            questLog.popNext();
        }
     }
    
    /**
     * Lists the quests currently active for the player
     */
    private void listCurrent(){
        System.out.println(this.questLog.goToQuest().getName());
        System.out.println(this.questLog.goToQuest().getDescription());
    }
    
    /**
     * method lists the current Quests completed by the player
     */
    private void listCompleted(){
        String[] tempFin = questLog.listCompleted();
        if(tempFin.length == 0){
            System.out.println("You haven't finished any quests yet!");
        }
        else{
            for (int i = 0; i < tempFin.length; i++){
            System.out.println(i+1 + ": " + tempFin[i]);
            }
        }
    }
    
}