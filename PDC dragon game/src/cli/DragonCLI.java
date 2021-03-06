/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import logic.*;

/**
 *
 * @author joel
 */
public class DragonCLI {
    // hi
    // good morrow
    private Dragon d;
    private Pack p;
    private String[] commands;
    
    public DragonCLI(Dragon d, Pack p) throws FileNotFoundException
    {
        this.d = d;
        this.p = p;
        String[] com = {"help", "feed", "play", "train", "info", "player"};
        this.commands = com;
        /*
        File file = new File("src/file/tutorial/dragonTutorial");
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
            ResultSet tut = stmt.executeQuery("select * from PDC.TUTORIAL where ID = 0");
            tut.next();
            System.out.print(tut.getString("tutor").replaceAll("\\\\n", "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.commandInterface();
    }

    private void commandInterface() {
        Scanner in = new Scanner(System.in);
        this.printCommands();        
        String input = null;
        boolean exit = false;
        while(!exit)
        {
            System.out.print("Dragon: ");
            input = in.nextLine();
            switch(input)
            {
                case "help" : this.printCommands();
                                break;
                case "feed" : this.feed();
                                break;
                case "play" : this.play();
                                break;
                case "train" : this.train();
                                break;
                case "info" : this.getInfo();
                                break;
                case "player" : exit = true;
                                break;
                case "addExp" : d.addExp(80);
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

    private void feed() {
        String output = "";
        Item i = p.selectItem("Food");
        if (i != null)
        {
            output += "You try to feed " + d.getName() + "\n";
            p.useItem(i);
            output += d.addExp(3);
            output += d.addHealth(5);
        } else
        {
            output += "You do not have any food to feed " + d.getName() + "\n";
            output += "You have to buy some from the pack menu\n";
        }
        System.out.print(output);
    }

    private void play() {
       String output = "";
        if (d.getLevel() > 0)
        {
            int xp = 5;
            Item i = p.selectItem("Toy");
            if (i != null)
            {
                xp += 3;
            }
            output += "You try to play " + d.getName() + "\n";
            output += d.addExp(xp);
        } else
        {
            output += d.getName() + "is not a high enough level for you to play\n";
            output += "Try again when you are level 1 or above\n";
        }
        System.out.print(output);
    }

    private void train() {
        String output = "";
        if (d.getLevel() > 2)
        {
            int xp = 8;
            Item i = p.selectItem("Chestplate");
            if (i != null)
            {
                xp += 6;
            }
            output += "You try to train " + d.getName() + "\n";
            output += d.addExp(xp);
        } else
        {
            output += d.getName() + "is not a high enough level for you to train\n";
            output += "Try again when you are level 3 or above\n";
        }
        System.out.print(output);
    }

    private void getInfo() {
        String output = "";
        output += "Name: " + d.getName() + "\n";
        output += "Health: " + d.getHealth() + "/" + d.getMaxHealth() + "\n";
        output += "Level: " + d.getLevel() + "\n";
        output += "Exp: " + d.getExp() + "\n";
        System.out.print(output);
    }
    
}
