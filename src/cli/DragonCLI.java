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
    
    private Dragon d;
    private Pack p;
    private String[] commands;
    
    public DragonCLI(Dragon d, Pack p)
    {
        this.d = d;
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
        Item i = null;
        try {
            i = p.selectItem("food");
        } catch (Exception e)
        {
            
        }
        if (i != null)
        {
            output += "You try to feed " + d.getName() + "\n";
            output += d.addExp(3);
        } else
        {
            output += "You do not have any food to feed " + d.getName() + "\n";
            output += "You have to buy some from the pack menu";
        }
        System.out.println(output);
    }

    private void play() {
       String output = "";
        if (d.getLevel() > 2)
        {
            output += "You try to play " + d.getName() + "\n";
            output += d.addExp(5);
        } else
        {
            output += d.getName() + "is not a high enough level for you to play\n";
            output += "Try again when you are level 3 or above";
        }
        System.out.println(output);
    }

    private void train() {
        String output = "";
        if (d.getLevel() > 4)
        {
            output += "You try to train " + d.getName() + "\n";
            output += d.addExp(8);
        } else
        {
            output += d.getName() + "is not a high enough level for you to train\n";
            output += "Try again when you are level 5 or above";
        }
        System.out.println(output);
    }

    private void getInfo() {
        String output = "";
        output += "Name: " + d.getName() + "\n";
        output += "Level: " + d.getLevel() + "\n";
        System.out.println(output);
    }
    
}
