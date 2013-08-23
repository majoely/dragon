package cli;

import java.util.ArrayList;
import logic.*;
import java.util.Scanner;

public class QuestLedgerCLI{
    
    private QuestLedger questLog;
    String[] commands;
    
    @SuppressWarnings("empty-statement")
    public QuestLedgerCLI(QuestLedger questLog){
        this.questLog = questLog;
        String[] com = {"help", "current", "completed"};
        this.commands = com;
        this.commandInterface();
    }
    
     private void commandInterface(){
        Scanner in = new Scanner(System.in);
        this.printCommands();
        String input = null;
        boolean exit = false;
        while(!exit){
            System.out.print("Quest: ");
            input = in.nextLine();
            switch(input){
                case "help" : printCommands();
                break;
                case "current" : listCurrent();
                break;
                case "completed" : questlog.listCompletedQuests();
                break;
                default : System.out.println("invalid command");
                System.out.println("enter help to see commands");
                break;
            }
        }
    }
    
    /*
     * Method for printing all of the commands available in the Quest Ledger menu
     */
    private void printCommands(){
        System.out.print("Commands: ");
        for(int i = 0; i < this.commands.length; i++){
            System.out.print(this.commands[i] + " ");
        }
        System.out.print("\n");
    }
    
    /*
     * 
     */
    private void listCurrent(){
        
    }
    
    /*
     * 
     */
    private void listCompleted(){
        String[] tempFin = questLog.getCompletedQuests();
        if(tempFin.length == 0){
            System.out.println("You haven't finished any quests yet!");
        }
        else{
            for (int i = 0; i < tempFin.length; i++){
            System.out.println(i + ": " + tempFin[i]);
            }
        }
    }
    
}