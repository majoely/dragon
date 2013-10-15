package tests;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logic.Player;
import logic.Pack;
import logic.Dragon;
import logic.QuestLedger;
import logic.Quest;
import logic.Fight;
import logic.Enemy;

public class PlayerTest{

    /**
     * This file includes tests for Player, Quest and QuestLedger
     * Compressed them together because of their reliance on a player object and it's requirement for them to be present in the constructor.
     * Completed Tests
     * 
     * Player:
     * - getNames
     * 
     */

    public Player pTest;
    public Pack bpTest;
    public Dragon dTest;
    public QuestLedger qlTest;
    public ArrayList<Fight> listFight = new ArrayList<>();
    public ArrayList <Quest> listQuest = new ArrayList<>();
    public Quest qTest;
    public Fight fTest;
    public Enemy eTest;
    
    @Before
    public void setUp(){
        bpTest = new Pack(20);
        dTest = new Dragon("DemoD");
        
        eTest = new Enemy("Enemy 1", 10, 20);
        fTest = new Fight(dTest, eTest, bpTest);
        listFight.add(fTest);
        qTest = new Quest("Quest 1", "This is the first Test Quest", listFight);
        listQuest.add(qTest);
        qlTest = new QuestLedger(listQuest);
        
        pTest = new Player("Player", bpTest, dTest, qlTest);
    }
    
    @After
    public void tearDown(){
        pTest = null;
        dTest = null;
        qlTest = null;
        bpTest = null;
        listFight = null;
        listQuest = null;
        fTest = null;
        qTest = null;
        eTest = null;
    }
    
    @Test
    public void testNames(){
        assertEquals("Player", pTest.getName());
        assertEquals("DemoD", pTest.getDragon().getName());
    }
  
    
    @Test
    public void testWinFight(){
        //Code winning a fight and testing that
        //Can test finishing a quest this way too
    }
    
    @Test
    public void testQuestLedgerLists(){
        //Code to test moving quest from one array to another
    }
}