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
            File file = new File("src/file/intro/intro");
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
            file = new File("src/file/intro/dragon");
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
            file = new File("src/file/intro/dragon2");
            out = new Scanner(file);
            while (out.hasNext())
            {
                System.out.println(out.nextLine());
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            Pack pac = new Pack(40);
            Item f = new Item("food", "used to feed dragon", 10);
            pac.addItem(f);
            
            //To create and import the quests from the files
            QuestLedger ql = null;
            ArrayList<Quest> quests = new ArrayList<>();
            boolean finished = false;
            for(int i = 1; i < 9 && !finished; i++)
            {
                File fq = new File("src/file/quests/quest" + i);
                if (fq == null)
                {
                    ql = new QuestLedger(quests);
                    finished = true;
                    
                } else
                {
                    Scanner inQuest = new Scanner(fq);
                    String qName = in.nextLine();
                    String qDescription = in.nextLine();
                    ArrayList<Fight> qFights = new ArrayList<>();
                    while (in.hasNext())
                    {
                        File fbg = new File("src/file/quests/badguy/" + in.nextLine());
                        Scanner inBadGuy = new Scanner(fbg);
                        String bgName = in.nextLine();
                        int bgGold = in.nextInt();
                        int bgExp = in.nextInt();
                        Enemy en = null;
                        if (in.hasNext())
                        {
                            File fItem = new File("src/file/item/" + in.nextLine());
                            Scanner inItem = new Scanner(fItem);
                            String iName = in.nextLine();
                            String iDescript =  in.nextLine();
                            int iValue = in.nextInt();
                            Item bgItem = new Item(iName, iDescript, iValue);
                            en = new Enemy(bgName, bgGold, bgExp, bgItem);
                        } else
                        {
                            en = new Enemy(bgName, bgGold, bgExp);
                        }
                        qFights.add(new Fight(dra, en, pac));
                    }
                    quests.add(new Quest(qName, qDescription, qFights));
                }
            }
            
            //End import of the quests
            
            
            Player pla = new Player(pName, pac, dra, ql);
            Thread t = new Thread(pla);
            t.start();
            PlayerCLI pcli = new PlayerCLI(pla);
        
        }
    }
    
}
