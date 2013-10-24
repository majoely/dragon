/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import logic.Dragon;
import logic.Enemy;
import logic.Fight;
import logic.Item;
import logic.Pack;
import logic.Player;
import logic.Quest;
import logic.QuestLedger;


/**
 *
 * @author msg8758
 */
public class Container extends JPanel {
    
    private JPanel layout;
    private int x;
    private Player pla;
    private Statement stmt;
    private String dragonHelp;
    private String packmHelp;
    private String packsHelp;
    private String questHelp;
    
    public Container() {
        setLayout(new GroupLayout(this));
        createPlayer();
        x = 0;
        layoutSwitch();
    }

    public void layoutSwitch() {
        removeAll();
        switch(x++) {
            case 0 : switch0();
                break;
            case 1 : switch1();
                break;
            case 2 : switch2();
                break;
            case 3 : switch3();
                break;
            case 4 : switch4();
                break;
            case 5 : switch5();
        }
        add(layout);
        repaint();
        revalidate();
    }
    
    public void layoutNum(int x) {
        this.x = x;
        layoutSwitch();
    }
    
    private void switch0() {
        try {
            System.out.println("Switch 0");
            ResultSet intro = stmt.executeQuery("select INTRO from PDC.INTRO where id = 0");
            intro.next();
            layout = new Info(intro.getString("intro").replaceAll("\\\\n", "\n"), "Next");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void switch1() {
        System.out.println("Switch 1");
        layout = new PName("What was your name?", "Next");
    }
    
    private void switch2() {
        try {
            System.out.println("Switch 2");
            ResultSet intro = stmt.executeQuery("select INTRO from PDC.INTRO where id = 1");
            intro.next();
            layout = new Info(intro.getString("intro").replaceAll("\\\\n", "\n"), "Next");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void switch3() {
        System.out.println("Switch 3");
        layout = new DName("What would you like to call your dragon? ", "Next");
    }
    
    private void switch4() {
        try {
            System.out.println("Switch 4");
            ResultSet intro = stmt.executeQuery("select INTRO from PDC.INTRO where id = 2");
            intro.next();
            layout = new Info(intro.getString("intro").replaceAll("\\\\n", "\n"), "Next");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void switch5() {
        System.out.println("Switch 5");
        System.out.println(pla.getName());
        System.out.println(pla.getDragon().getName());
        layout = new DragonUI(pla.getDragon(), pla.getPack());
    }
    
    public Player getPlayer() {
        return pla;
    }
    
    private void createPlayer() {
        
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dragon", "pdc", "pdc");
            stmt = con.createStatement();
            ResultSet help = stmt.executeQuery("select * from PDC.GHELP");
            help.next();
            dragonHelp = help.getString("tutorial");
            help.next();
            packmHelp = help.getString("tutorial");
            help.next();
            packsHelp = help.getString("tutorial");
            help.next();
            questHelp = help.getString("tutorial");
            Dragon dra = new Dragon();
            Pack pac = new Pack(40);
                ResultSet item = stmt.executeQuery("select * from PDC.ITEM where ID = 0");
                item.next();
                for (int i = 0; i < 3; i++) {
                    //create food and put in pack
                    Item f = new Item(item.getString("name"), item.getString("descript"), item.getInt("gold"), item.getInt("id"));
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
                            Item bgItem = new Item(sqlItem.getString("name"), sqlItem.getString("descript"), sqlItem.getInt("gold"), sqlItem.getInt("id")); 
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
                if (ql == null)
                    System.out.println("quest ledger is null");
                //create player and start
                pla = new Player(pac, dra, ql);
        } catch (Exception ex) {
            Logger.getLogger(Container.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void playSwitch(int n) {
        layout = null;
        removeAll();
        switch(n) {
            case 0 : pSwitch0();
                break;
            case 1 : pSwitch1();
                break;
            case 2 : pSwitch2();
                break;
            case 3 : pSwitch3();
                break;
            case 4 : pSwitch4();
                break;
            case 5 : pSwitch5();
        }
        add(layout);
        repaint();
        revalidate();
    }

    private void pSwitch0() {
        layout = new DragonUI(pla.getDragon(), pla.getPack());
    }

    private void pSwitch1() {
         layout = new PackMain(pla.getPack());
    }

    private void pSwitch2() {
        layout = new QuestMain(pla.getQuestLedger());
    }

    private void pSwitch3() {
        layout = new PackShop(pla.getPack(), pla.getDragon().getLevel());
    }

    private void pSwitch4() {
        layout = new QuestOver(pla.getQuestLedger().goToQuest(), pla.getDragon().getLevel());
    }

    private void pSwitch5() {
        layout = new FightUI(pla.getQuestLedger().goToQuest(), pla.getQuestLedger());
    }
    
}
