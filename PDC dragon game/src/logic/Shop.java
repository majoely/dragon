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
         for(int i = 0; i <= level; i++) {
             try {
             File f = new File("src/main/item" + i);
             Scanner in = new Scanner(f);
             String name = in.nextLine();
             String descript = in.nextLine();
             int value = Integer.parseInt(in.nextLine());
             addItem(new Item(name, descript, value));
             in.close();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
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
        String[] names = new String[this.shopInventory.size()];
        for(int x = 0; x < this.shopInventory.size(); x++ ){
            Item temp = this.shopInventory.get(x);
            names[x] = temp.getName();
        }
        return names;
    }
    
}