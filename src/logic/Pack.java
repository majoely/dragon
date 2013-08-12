package logic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Joel Compton
 */
public class Pack {
    
    private int gold;
    private ArrayList<Item> items; 
    
    /**
     * Constructor to make pack for player to hold their items
     * 
     * @param gold The initial gold for the player
     */ 
    public Pack(int gold)
    {
        this.gold = gold;
        this.items = new ArrayList<>();
    }
    
    /**
     * The method to get the number of gold that is currently in the pack
     * 
     * @return int The amount of gold in the pack
     */ 
    public int getGold()
    {
        return this.gold;
    }
    
    /**
     * Method to buy an item.
     * Will first get the value of the item 
     * Then will reduce the gold by that amount
     * Then will add the item to the list
     * 
     * @param item Item to be added to the Pack
     */ 
    public void buyItem(Item item)
    {
        double value = item.getValue() * 1.2;
        this.gold -= value;
        items.add(item);
    }
    
    /**
     * Method to sell an item.
     * Will first get the value of the item
     * Then will increase the gold by that amount
     * Then will remove the item to the list
     * 
     * @param item Item to be removed to the Pack
     */ 
    public void sellItem(Item item)
    {
        double value = item.getValue() * 0.8;
        this.gold += value;
        items.remove(item);
    }
    
    /**
     * Method to use when an item is being used
     * eg. potion, food
     * THe method will remove the item and then return it
     * 
     * @return item The item to be returned.
     */ 
    public boolean useItem(Item item)
    {
        boolean sucess = items.remove(item);
        return sucess;
    }
    
    /**
     * Method to add gold when you get it from a fight or challenge
     * 
     * @param gold Gold to add to the pack.
     */ 
    public void addGold(int gold)
    {
        this.gold += gold;
    }
    
    /**
     * Method to add item when you get it from a fight or challenge
     * 
     * @param item Item to be added
     */ 
    public void addItem(Item item)
    {
        this.items.add(item);
    }
 
    /*
     * Method to get the names of the items the player currently caries
     * 
     * @return String[] Array of names
     */
    public String[] getInventoryNames(){
        String[] names = new String[items.size()];
        for(int x = 0; x < items.size(); x++ ){
            Item temp = items.get(x);
            names[x] = temp.getName();
        }
        return names;
    }
    
    public Item selectItem(String name){
        Item item = null;
        boolean found = false;
        Iterator it = this.items.iterator();
        while(it.hasNext() && !found){
            item = (Item) it.next();
            if(name.equals(item.getName())){
                found = true;
            }
        }
        return item;
    }
    
}
