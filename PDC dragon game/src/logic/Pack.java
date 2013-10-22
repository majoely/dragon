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
    private int itemNum;
    
    /**
     * Constructor to make pack for player to hold their items
     * 
     * @param gold The initial gold for the player
     */ 
    public Pack(int gold)
    {
        this.itemNum = 0;
        this.gold = gold;
        this.items = new ArrayList<>();
    }
    
    public Pack(int gold, ArrayList<Item> items)
    {
        this.itemNum = 0;
        this.gold = gold;
        this.items = items;
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
    
    public String getItemNumNoBo() {
        return this.items.get(itemNum).getName();
    }
    
    public String getItemNum(boolean fore) {
        String ans = "";
        if (fore) {
            this.itemNum += 1;
            ans += this.items.get(itemNum).getName();
        } else {
            this.itemNum -= 1;
            System.out.println("num: " + itemNum);
            if (itemNum < 0)
                this.itemNum = this.items.size();
            ans += this.items.get(itemNum).getName();
        }
        return ans;
    }
    
    public Item selectItem(String name){
        //System.out.println("select");
        Iterator it = this.items.iterator();
        while(it.hasNext()){
            Item item = (Item) it.next();
            //System.out.println("Iterate");
            if(name.equals(item.getName())){
                return item;
                //System.out.println("found");
            }
        }
        return null;
    }
    
    @Override
    public String toString()
    {
        String save = " , gold = " + this.gold;
        save += " , items = \'";
        for (Item item : items) {
            save += item.getID() + ",";
        }
        return save.substring(0, save.length()-1) + "\'";
    }
}
