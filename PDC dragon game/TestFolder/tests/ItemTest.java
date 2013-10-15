package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logic.Item;
import logic.Potion;
import logic.Pack;
import logic.Food;
import logic.Weapon;

public class ItemTest{
    
    /**
     * List of completed tests for the Item Class and it's sub classes. Also some tests for Shop included.
     * 
     * Pack Tests:
     * - testAddItems
     * - testSellItems
     * - testGetGold
     * - testSelectedItem
     * 
     * Item super and subclass tests:
     * - Food: getFeedValue
     * - Weapon: attackValue
     * - Item: getGoldValue
     * 
     */
     
     public Item iTest;
     public Item fTest;
     public Item pTest;
     public Item wTest;
     public Pack bpTest;
     
     @Before
     public void setUp(){
         iTest = new Item("Super Item", "Test Item 1: Super", 20, 1);
         bpTest = new Pack(50);
         fTest = new Food("Food Item", "Test Food Item", 20, 2);
         wTest = new Weapon("Weapon Item", "Test Weapon Item", 20 , 3);
     }
     
     @After
     public void tearDown(){
         iTest = null;
         bpTest = null;
         fTest = null;
         wTest = null;
     }
     
     @Test
     public void testAddItems(){
         bpTest.addItem(iTest);
         bpTest.addItem(fTest);
         String[] itemNames = bpTest.getInventoryNames();
         assertEquals(itemNames[0], "Super Item");
         assertEquals(itemNames[1], "Food Item");
     }
     
     @Test
     public void testSellItems(){
         bpTest.addItem(iTest);
         bpTest.addItem(fTest);
         bpTest.sellItem(iTest);
         String[] itemNames = bpTest.getInventoryNames();
         assertEquals(itemNames[0], "Food Item");
         assertEquals(bpTest.getGold(), 66);
     }
     
     @Test
     public void testSelectItem(){
         bpTest.addItem(iTest);
         assertEquals(bpTest.selectItem("Super Item"), iTest);
     }
     
     @Test
     public void testGetGold(){
         assertEquals(bpTest.getGold(), 50);
     }
     
     @Test
     public void testFoodFeedValue(){
         assertEquals(((Food)fTest).getFeedValue(), 2);
     }
     
     @Test
     public void testWeaponAttackValue(){
         assertEquals(((Weapon)wTest).getAttackValue(), 3);
     }
     
     @Test
     public void getGoldValues(){
         assertEquals(iTest.getValue(), 20);
     }
}