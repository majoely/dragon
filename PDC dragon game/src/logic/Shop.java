package logic;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Shop{
    
    /**
     * Temporary shop setup at the moment for testing purposes.
     * Could be used as a permanent replacement though. Use a contrustructor
     * that takes an integer which would be the dragons level to create a 
     * shop with an inventory based on the level. Could be an easier solution than
     * reading from a text file
     */
     
     private ArrayList<Item> shopInventory;
     private int itemNum;
     
     public Shop(int level){
         shopInventory = new ArrayList<>();
         for(int i = 0; i <= level; i++) {
             try {
                 /*
                 File f = new File("src/file/item/item" + i);
                 Scanner in = new Scanner(f);
                 String name = in.nextLine();
                 String descript = in.nextLine();
                 int value = Integer.parseInt(in.nextLine());*/
                 Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dragon", "pdc", "pdc");
                 Statement stmt = con.createStatement();
                 ResultSet item = stmt.executeQuery("select * from PDC.ITEM where ID = " + i);
                 item.next();
                 addItem(new Item(item.getString("name"), item.getString("descript"), item.getInt("gold"), item.getInt("id")));
                 
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
         this.itemNum = 0;
     }
     
     public void addItem(Item item){
         shopInventory.add(item);
     }
     
    public Item findItem(String name){
        //System.out.println("select");
        Iterator it = this.shopInventory.iterator();
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
    
    public String[] getInventoryNames(){
        String[] names = new String[this.shopInventory.size()];
        for(int x = 0; x < this.shopInventory.size(); x++ ){
            Item temp = this.shopInventory.get(x);
            names[x] = temp.getName();
        }
        return names;
    }
    
    public String getItem(boolean fore) {
        if (this.shopInventory.isEmpty())
            return "null";
        if (fore) 
            itemNum++;
        else
            itemNum--;
        if (itemNum >= this.shopInventory.size())
            itemNum = 0;
        if (itemNum < 0)
            itemNum = this.shopInventory.size() -1;
        return this.shopInventory.get(itemNum).name;
    }
    
}