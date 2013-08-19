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
public class DragonCLI {
    // hi
    private Dragon d;
    private Pack p;
    private String[] commands;
    
    public DragonCLI(Dragon d, Pack p)
    {
        this.d = d;
        this.p = p;
        String[] com = {"help", "feed", "play", "train", "info", "player"};
        this.commands = com;
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
        Item i = p.selectItem("food");
        if (i != null)
        {
            output += "You try to feed " + d.getName() + "\n";
            p.useItem(i);
            output += d.addExp(3);
        } else
        {
            output += "You do not have any food to feed " + d.getName() + "\n";
            output += "You have to buy some from the pack menu\n";
        }
        System.out.print(output);
    }

    private void play() {
       String output = "";
        if (d.getLevel() > 2)
        {
            int xp = 5;
            Item i = p.selectItem("toy");
            if (i != null)
            {
                xp += 3;
            }
            output += "You try to play " + d.getName() + "\n";
            output += d.addExp(xp);
        } else
        {
            output += d.getName() + "is not a high enough level for you to play\n";
            output += "Try again when you are level 3 or above\n";
        }
        System.out.print(output);
    }

    private void train() {
        String output = "";
        if (d.getLevel() > 4)
        {
            int xp = 8;
            Item i = p.selectItem("toy");
            if (i != null)
            {
                xp += 6;
            }
            output += "You try to train " + d.getName() + "\n";
            output += d.addExp(xp);
        } else
        {
            output += d.getName() + "is not a high enough level for you to train\n";
            output += "Try again when you are level 5 or above\n";
        }
        System.out.print(output);
    }

    private void getInfo() {
        String output = "";
        output += "Name: " + d.getName() + "\n";
        output += "Level: " + d.getLevel() + "\n";
        System.out.print(output);
    }
    
}
