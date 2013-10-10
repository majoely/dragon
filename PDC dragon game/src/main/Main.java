/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import logic.*;
import cli.*;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

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
            /*
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
            int dHunger = out.nextInt();
            int pacGold = out.nextInt();
            out.nextLine();
            ArrayList<Item> item = new ArrayList<>();
            while (out.hasNext())
            {
                String temp = out.nextLine();
                switch (temp)
                {
                    case "Food" : item.add(new Item("Food", "Top grade dragon food", 10));
                       break;
                    case "Chestplate" : item.add(new Item("Chestplate", "Better than nothing ... slightly", 20));
                       break;
                    case "Toy" : item.add(new Item("Toy", "To play with your dragon", 25));
                       break;
                }
            }*/
            //connect to database
            try {
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dragon", "pdc", "pdc");
                Statement stmt = con.createStatement();

                //pull out the saved data
                ResultSet save = stmt.executeQuery("select * from PDC.SAVE where id = 1");
                save.next();
                String dName = save.getString("pName");
                int dHealth = save.getInt("health");
                int dMax = save.getInt("mhealth");
                int dDefense = save.getInt("defense");
                int dAttack = save.getInt("attack");
                int dExperience = save.getInt("exp");
                int dLevel = save.getInt("level");
                int dHunger = save.getInt("hunger");
                int pacGold = save.getInt("gold");
                String pName = save.getString("pname");
                String tempItem = save.getString("items");
                StringTokenizer st = new StringTokenizer(tempItem, ",");
                ArrayList<Item> item = new ArrayList<>();
                while (st.hasMoreElements()) {
                    ResultSet sqlItem = stmt.executeQuery("select * from PDC.ITEM where id = " + st.nextToken());
                    sqlItem.next();
                    item.add(new Item(sqlItem.getString("name"), sqlItem.getString("descript"), sqlItem.getInt("gold")));
                }
                
                Dragon dra = new Dragon(dName, dHealth, dMax, dDefense, dAttack, dExperience, dLevel, dHunger);
                Pack pack = new Pack(pacGold, item);
                Player pla = new Player(pName, pack, dra);
                Thread t = new Thread(pla);
                t.start();
                PlayerCLI pcli = new PlayerCLI(pla);
                t.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else
        {
            /*
            File file = new File("src/file/intro/intro");
            Scanner out = new Scanner(file);
            while (out.hasNext())
            {
                System.out.println(out.nextLine());
                try {
                    Thread.sleep(0);
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
                    Thread.sleep(0);
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
                    Thread.sleep(0);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            Pack pac = new Pack(40);
            for (int i = 0; i < 3; i++) {
                Item f = new Item("food", "used to feed dragon", 10);
                pac.addItem(f);
            }
            //To create and import the quests from the files
            QuestLedger ql = null;
            ArrayList<Quest> quests = new ArrayList<>();
            boolean finished = false;
            for(int i = 1; i < 9 && !finished; i++)
            {
                //System.out.println("in the loop");
                File fq = new File("src/file/quests/quest" + i);
                if (!fq.exists())
                {
                    ql = new QuestLedger(quests);
                    finished = true;
                    //System.out.println("now should finish");
                    
                } else
                {
                    //System.out.println("getting the quests");
                    Scanner inQuest = new Scanner(fq);
                    String qName = inQuest.nextLine();
                    String qDescription = inQuest.nextLine();
                    ArrayList<Fight> qFights = new ArrayList<>();
                    while (inQuest.hasNext())
                    {
                        //System.out.println("then the badquys");
                        File fbg = new File("src/file/quests/badguy/" + inQuest.nextLine());
                        Scanner inBadGuy = new Scanner(fbg);
                        //System.out.println("1");
                        String bgName = inBadGuy.nextLine();
                        //System.out.println("2");
                        int bgGold = inBadGuy.nextInt();
                        //System.out.println("3");
                        int bgExp = inBadGuy.nextInt();
                        //System.out.println("4");
                        Enemy en = null;
                        if (inBadGuy.hasNext())
                        {
                            inBadGuy.nextLine();
                            File fItem = new File("src/file/item/" + inBadGuy.nextLine());
                            Scanner inItem = new Scanner(fItem);
                            String iName = inItem.nextLine();
                            String iDescript =  inItem.nextLine();
                            int iValue = inItem.nextInt();
                            Item bgItem = new Item(iName, iDescript, iValue);
                            en = new Enemy(bgName, bgGold, bgExp, bgItem);
                            //System.out.println("item");
                        } else
                        {
                            en = new Enemy(bgName, bgGold, bgExp);
                            //System.out.println("no item");
                        }
                        qFights.add(new Fight(dra, en, pac));
                        //System.out.println("new fight");
                    }
                    quests.add(new Quest(qName, qDescription, qFights));
                    //System.out.println("new quest");
                }
            }
            * */
            
            //Variables for inside the try/catch loop.
            
            
            //Trying to import data from javadb
            try {
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dragon", "pdc", "pdc");
                Statement stmt = con.createStatement();
                //game introduction
                ResultSet intro = stmt.executeQuery("select INTRO from PDC.INTRO");
                intro.next();
                System.out.print((intro.getString("intro")).replaceAll("\\\\n", "\n"));
                intro.next();
                //get name
                String pName = in.nextLine();
                System.out.println("Oh yes of course " + pName + "!");
                //dragon introduction
                System.out.print(intro.getString("intro").replaceAll("\\\\n", "\n"));
                intro.next();
                String dName = in.nextLine();
                Dragon dra = new Dragon(dName);
                //final introduction
                System.out.print(intro.getString("intro").replaceAll("\\\\n", "\n"));
                intro = null;
                //create pack
                Pack pac = new Pack(40);
                ResultSet item = stmt.executeQuery("select * from PDC.ITEM where ID = 0");
                item.next();
                for (int i = 0; i < 3; i++) {
                    //create food and put in pack
                    Item f = new Item(item.getString("name"), item.getString("descript"), item.getInt("gold"));
                    pac.addItem(f);
                }
                item = null;
                //create the ql, the quests and the fights with the bad guys. 
                QuestLedger ql = null;
                ArrayList<Quest> quests = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    ResultSet quest = stmt.executeQuery("select * from PDC.QUEST where id = " + i);
                    quest.next();
                    System.out.println("quest loop");
                    String qName = quest.getString("name");
                    String qDesc = quest.getString("descript");
                    String badGuys = quest.getString("badguy");
                    ArrayList<Fight> qFight = new ArrayList<>();
                    StringTokenizer st = new StringTokenizer(badGuys, ",");
                    //get the badguys
                    while (st.hasMoreElements()) {
                        System.out.println("toker loop");
                        Enemy en = null;
                        ResultSet bg = stmt.executeQuery("select * from PDC.BADGUY where ID = " + st.nextToken());
                        bg.next();
                        String bgName = bg.getString("name");
                        int bgGold = bg.getInt("gold");
                        int bgExp = bg.getInt("exp");
                        String tempItem = bg.getString("item");
                        //if they have an item
                        if (tempItem != null) {
                            ResultSet sqlItem = stmt.executeQuery("select * from PDC.ITEM where ID = " + tempItem);
                            sqlItem.next();
                            Item bgItem = new Item(sqlItem.getString("name"), sqlItem.getString("descript"), sqlItem.getInt("gold")); 
                            en = new Enemy(bgName, bgGold, bgExp, bgItem);
                        } else {
                            en = new Enemy(bgName, bgGold, bgExp);
                        }
                        //create and add a fight
                        qFight.add(new Fight(dra, en, pac));
                    }
                    //create and add a quest
                    quests.add(new Quest(qName, qDesc, qFight));
                }
                ql = new QuestLedger(quests);
                //create player and start
                Player pla = new Player(pName, pac, dra, ql);
                Thread t = new Thread(pla);
                t.start();
                PlayerCLI pcli = new PlayerCLI(pla);
                t.stop();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            //End import of the quests
           
        }
    }
    
}
