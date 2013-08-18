package logic;

import java.util.ArrayList;
import java.util.Iterator;

public class Shop{
    
    /**
     * Temporary shop setup at the moment for testing purposes.
     * Could be used as a permanent replacement though. Use a contrustructor
     * that takes an integer which would be the dragons level to create a 
     * shop with an inventory based on the level. Could be an easier solution than
     * reading from a text file
     */
     
     private ArrayList<Item> shopInventory;
     
     
     public Shop(int level){
         if(level == 1){
             addItem(new Item("Copper Chestplate", "Better than nothing... slightly", 20));
         }
         addItem(new Item("Food", "Top grade Dragon food", 10));
     }
     
     public void addItem(Item item){
         shopInventory.add(item);
     }
     
    public Item findItem(String name){
        Item item = null;
        //System.out.println("select");
        boolean found = false;
        Iterator it = this.shopInventory.iterator();
        while(it.hasNext() && !found){
            item = (Item) it.next();
            //System.out.println("Iterate");
            if(name.equals(item.getName())){
                found = true;
                //System.out.println("found");
            }
        }
        return item;
    }
    
    public String[] getInventoryNames(){
        String[] names = new String[items.size()];
        for(int x = 0; x < items.size(); x++ ){
            Item temp = items.get(x);
            names[x] = temp.getName();
        }
        return names;
    }
    
}