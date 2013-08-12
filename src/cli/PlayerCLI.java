/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cli;

import java.util.Scanner;
import logic.*;

/**
 *
 * @author joel
 */
public class PlayerCLI {

    private Player p;    
    private String[] commands;

    @SuppressWarnings("empty-statement")
    public PlayerCLI(Player p)
    {
        this.p = p;
        String[] com = {"help", "name", "pack", "dragon", "quests", "exit"};
        this.commands = com;
        //System.out.println("created player interface");
        this.commandInterface();
    }

    private void commandInterface()
    {
        Scanner in = new Scanner(System.in);
        this.printCommands();
        String input = null;
        boolean exit = false;
        while (!exit)
        {
            System.out.print("Player: ");
            input = in.nextLine();
            switch(input)
            {
                case "help" : printCommands();
                        break;
                case "name" : System.out.println(p.getName());
                        break;
                case "pack" : goToPack();
                        break;
                case "dragon" : goToDragon();
                        break;
                case "quests" : goToQuestLedger();
                        break;
                case "exit" : exit = goToExit();
                        break;
                default : System.out.println("Invalid command");
                        System.out.println("enter help to see commands");
                        break;
                
            }
            
        }
    }

    private void printCommands() {
        System.out.print("Commands: ");
        for (int i = 0; i < this.commands.length; i++) {
            System.out.print(this.commands[i] + "  ");
        }
        System.out.print("\n");
    }

    private void goToPack() {
        PackCLI pack = new PackCLI(p.getPack());
        pack = null;
    }

    private void goToDragon() {
        DragonCLI drag = new DragonCLI(p.getDragon(), p.getPack());
        drag = null;
    }

    private void goToQuestLedger() {
        System.out.println("This feature is not available yet");
        //QuestLedgerCLI ql = new QuestLedgerCLI(p.getQuestLedger());
        //ql = null;
    }

    private boolean goToExit() {
        System.out.println("If you quit you will loose your current progress");
        System.out.println("Are you sure you would like to quit? ('yes' or 'no')");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        boolean exit = false;
        while(!input.equals("yes") && !input.equals("no"))
        {
            System.out.println("Incorrect answer ('yes' or 'no'");
            input = in.nextLine();
        }
        if(input.equals("yes"))
        {
            exit = true;
        }
        return exit;
    }
}
