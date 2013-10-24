package tests;

import logic.Dragon;
import logic.Fight;
import logic.Enemy;
import logic.Pack;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DragonTest{
    
    public Dragon dTest;
    public Fight fTest;
    public Enemy eTest;
    public Pack bpTest;
    
        
    /** First test file for dragon class
     * Includes some tests for Enemy, Fight and Quest due to the reliance of a Dragon Object.
    * 
    * List of tests completed
    * - fightDamage
    * - basicAttack
    * - AdvancedAttack
    * - enemyBasicAttack
    * - enemyAdvancedAttack
    * - 
    * 
    */
    
    @Before
    public void setUp(){
        dTest = new Dragon("DemoD");
        eTest = new Enemy("Enemy 1", 10, 20);
        fTest = new Fight(dTest, eTest, bpTest);
        bpTest = new Pack(20);
    }
    
    @After
    public void tearDown(){
        dTest = null;
        eTest = null;
        fTest = null;
        bpTest = null;
    }

    @Test
    public void testDragonLeveling(){
        dTest.addExp(10);
        assertEquals(1, dTest.getLevel());
    }
    
    @Test
    public void testDragonFightTakeDmg(){
        dTest.takeDmg(5);
        assertEquals(96, dTest.getHealth());    
    }
    
    @Test
    public void testDragonDamage(){
        assertEquals(dTest.giveDmg(), 5);
    }
    
    @Test
    public void testFightBasicAttack(){
        fTest.basicAttack();
        assertEquals(eTest.getHealth(), 15);
    }
    
    @Test
    public void testFightAdvancedAttack(){
        fTest.addEnergy();
        fTest.advancedAttack();
        assertEquals(eTest.getHealth(), 5);
    }
    
    @Test
    public void testEnemyAdvanced(){
        fTest.addBadEnergy();
        fTest.enemyAttack();
        assertEquals(dTest.getHealth(), 94);
    }
    
    @Test
    public void testEnemyBasicAttack(){
        fTest.enemyAttack();
        assertEquals(dTest.getHealth(), 99);
    }
}