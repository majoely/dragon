package cli;

import java.util.Scanner;
import logic.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author joel
 */
public class PlayerCLI {

    private Player p;    
    private String[] commands;

    @SuppressWarnings("empty-statement")
    public PlayerCLI(Player p) throws FileNotFoundException
    {
        this.p = p;
        String[] com = {"help", "name", "pack", "dragon", "quests", "save", "exit"};
        this.commands = com;
        File file = new File("src/main/playerTutorial");
        Scanner out = new Scanner(file);
        while (out.hasNext())
        {
            
            System.out.println(out.nextLine());
            try {
                Thread.sleep(400);
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
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
                case "addgold" : p.getPack().addGold(20);
                        break;
                case "tutorial" : try {
                                        showTutorial();
                                    } catch (FileNotFoundException ex) {
                                        ex.printStackTrace();
                                    }
                        break;
                case "save" : try {
                                    save();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
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
        QuestLedgerCLI ql = new QuestLedgerCLI(p.getQuestLedger());
        ql = null;
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
            p.stop();
            exit = true;
        }
        return exit;
    }
    
    private void showTutorial() throws FileNotFoundException{
        File file = new File("src/main/playerTutorial");
        Scanner out = new Scanner(file);
        while (out.hasNext())
        {
            System.out.println(out.nextLine());
        }
    }
    
    private void save() throws FileNotFoundException
    {
        String save = "" + System.currentTimeMillis() + "\n";
        save += this.p.toString();
        save += this.p.getDragon().toString();
        //save += this.p.getQuestLedger().toString();
        save += this.p.getPack().toString();
        System.out.println(save);
        PrintWriter pw = new PrintWriter(new FileOutputStream("src/main/save"));
        pw.println(save);
        pw.close();
    }
}
