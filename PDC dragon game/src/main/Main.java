/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import logic.*;
import cli.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joel
 */ 
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to load your game?");
        String ans = "";
        while (!ans.equals("yes") && !ans.equals("no"))
        {
            System.out.println("yes or no");
            ans = in.nextLine();
        }
        if (ans.equals("yes"))
        {
            File file = new File("src/main/save");
            Scanner out = new Scanner(file);
            long time = out.nextLong();
            out.nextLine();
            String pName = out.nextLine();
            String dName = out.nextLine();
            int dExperience = out.nextInt();
            int dLevel = out.nextInt();
            int dMax = out.nextInt();
            int dHealth = out.nextInt();
            int dAttack = out.nextInt();
            int dDefense = out.nextInt();
            double dHunger = out.nextDouble();
            int pacGold = out.nextInt();
            out.nextLine();
            ArrayList<Item> item = new ArrayList<>();
            while (out.hasNext())
            {
                String temp = out.nextLine();
                switch (temp)
                {
                    case "food" : item.add(new Item("food", "used to feed dragon", 10));
                       break;
                    case "toy" : item.add(new Item("toy", "used to play with dragon", 35));
                       break;
                    case "equip" : item.add(new Item("equip", "used to train dragon", 80));
                       break;
                }
            }
            Dragon dra = new Dragon(dName, dHealth, dMax, dDefense, dAttack, dExperience, dLevel, dHunger);
            Pack pack = new Pack(pacGold, item);
            Player pla = new Player(pName, pack, dra);
            Thread t = new Thread(pla);
            t.start();
            PlayerCLI pcli = new PlayerCLI(pla);
            
        } else
        {
            File file = new File("src/main/intro");
            Scanner out = new Scanner(file);
            while (out.hasNext())
            {
                System.out.println(out.nextLine());
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String pName = in.nextLine();
            System.out.println("Oh yes of course " + pName + "!");
            file = new File("src/main/dragon");
            out = new Scanner(file);
            while (out.hasNext())
            {
                System.out.println(out.nextLine());
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String dName = in.nextLine();
            Dragon dra = new Dragon(dName);
            System.out.println(dName + " is a good name for a dragon");
            file = new File("src/main/dragon2");
            out = new Scanner(file);
            while (out.hasNext())
            {
                System.out.println(out.nextLine());
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Pack pac = new Pack(40);
            Item f = new Item("food", "used to feed dragon", 10);
            pac.addItem(f);
            Player pla = new Player(pName, pac, dra);
            Thread t = new Thread(pla);
            t.start();
            PlayerCLI pcli = new PlayerCLI(pla);
        
        }
    }
    
}
