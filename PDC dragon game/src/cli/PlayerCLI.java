package cli;

import java.util.Scanner;
import logic.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String[] com = {"help", "name", "pack", "dragon", "quest", "save", "exit"};
        this.commands = com;
        /*
        File file = new File("src/file/tutorial/playerTutorial");
        Scanner out = new Scanner(file);
        while (out.hasNext())
        {
            
            System.out.println(out.nextLine());
            try {
                Thread.sleep(0);
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }*/
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dragon", "pdc", "pdc");
            Statement stmt = con.createStatement();
            ResultSet tut = stmt.executeQuery("select * from PDC.TUTORIAL where ID = 2");
            tut.next();
            System.out.print(tut.getString("tutor").replaceAll("\\\\n", "\n"));
        } catch (Exception e) {
            e.printStackTrace();
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
                case "quest" : goToQuestLedger();
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
                case "save" : this.p.save();
                                
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
        PackCLI pack;
        try {
            pack = new PackCLI(p.getPack());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        pack = null;
    }

    private void goToDragon() {
        DragonCLI drag;
        try {
            drag = new DragonCLI(p.getDragon(), p.getPack());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        drag = null;
    }
 
    private void goToQuestLedger() {
        if(p.getDragon().getLevel() > 4)
        {
            QuestLedgerCLI ql = new QuestLedgerCLI(p.getQuestLedger());
            ql = null;
        } else
        {
            System.out.println(p.getDragon().getName() + " is not old enough to go questing yet");
            System.out.println("Try again when you are level 5 or above");
        }
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
    
    private void showTutorial() throws FileNotFoundException{
        File file = new File("src/main/playerTutorial");
        Scanner out = new Scanner(file);
        while (out.hasNext())
        {
            System.out.println(out.nextLine());
        }
    }
}
