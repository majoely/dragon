package cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import logic.*;

/**
 * @version v0.1 - added most of the code
 * @author Curtis
 */
public class PackCLI {
    
    private Pack inventory;
    private String[] commands;
    
    @SuppressWarnings("empty-statement")
    public PackCLI(Pack inventory) throws FileNotFoundException{
        this.inventory = inventory;
        String[] com = {"help", "sell", "buy", "use", "list", "player"};
        this.commands = com;
        /*
        File file = new File("src/file/tutorial/packTutorial");
        Scanner out = new Scanner(file);
        while (out.hasNext())
        {
            
            System.out.println(out.nextLine());
            try {
                Thread.sleep(0);
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }*/
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dragon", "pdc", "pdc");
            Statement stmt = con.createStatement();
            ResultSet tut = stmt.executeQuery("select * from PDC.TUTORIAL where ID = 1");
            tut.next();
            System.out.print(tut.getString("tutor").replaceAll("\\\\n", "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.commandInterface();
    }
    
    private void commandInterface(){
        Scanner in = new Scanner(System.in);
        this.printCommands();
        String input =null;
        boolean exit = false;
        while(!exit){
            System.out.print("Pack: ");
            input = in.nextLine();
            switch(input){
                case "help" : printCommands();
                break;
                case "sell": sell();
                break;
                case "buy" : buy();
                break;
                case "use" : use();
                break;
                case "list" : printInventory();
                break;
                case "player" : exit = true;
                break; 
                default : System.out.println("invalid command");
                System.out.println("enter help to see commands");
                break;
            }
        }
    }
    
    /*
     * Method for printing all of the commands available in the pack menu
     */
    private void printCommands(){
        System.out.print("Commands: ");
        for(int i = 0; i < this.commands.length; i++){
            System.out.print(this.commands[i] + "  ");
        }
        System.out.print("\n");
    }
    
    /*
     * Method for selling an item
     */
    private void sell(){
        System.out.println("Please select an item to sell or type cancel to stop");
        printInventory();
        System.out.print("Sell: ");
        Scanner pick = new Scanner(System.in);
        String command = pick.nextLine();
        while(!command.equals("cancel")){
            Item temp = inventory.selectItem(command);
            if(temp != null){
                inventory.sellItem(temp);
                System.out.println("You now have " + inventory.getGold() + " gold");
            }
            else{
                System.out.println("You don't own that - type cancel to continue");
            }
            System.out.print("Sell: ");
            command = pick.nextLine();
        }
    }
    
    /*
     * Method for buying items
     */
    // private void buy(){
    //     System.out.println("Please select an item to buy- type cancel to stop");
    //     // add shop inventory
    //     System.out.println("Items for purchase: food:10g toy:35g equip:80g");
    //     Scanner pick = new Scanner(System.in);
    //     boolean finished = false;
    //     String command = pick.nextLine();
    //     while(!command.equals("cancel") && !finished){
    //         Item temp = null;
    //         System.out.print("Buy: ");
    //         switch(command)
    //         {
    //             case "food" : temp = new Item("food", "used to feed dragon", 10);
    //                 break;
    //             case "toy" : temp = new Item("toy", "used to play with dragon", 35);
    //                 break;
    //             case "equip" : temp = new Item("equip", "used to train dragon", 80);
    //                 break;
    //             default : System.out.println("Invalid item!");
    //         }
    //         if(temp != null && temp.getValue() < inventory.getGold()){
    //             inventory.buyItem(temp);
    //             finished = true;
    //             System.out.println("Congratulations you have just purchased a " + temp.getName());
    //             System.out.println("You currently have " + inventory.getGold() + " gold left");
    //         }
    //         else{
    //             System.out.println("You can't purchase that - type cancel to continue");
    //             command = pick.nextLine();
    //         }
            
    //     }
    // }
    
    /*
     * second buy attempt
     */
     private void buy(){
        System.out.println("Please select an item to buy- type cancel to stop");
        Shop shop = new Shop(1); // add method for getting dragon level
        printShop(shop);
        System.out.print("Buy: ");
        Scanner pick = new Scanner(System.in);
        String command = pick.nextLine();
        while(!command.equals("cancel")){
            Item temp = shop.findItem(command);
            if(temp != null && (inventory.getGold() > (temp.getValue() * 1.2))){
                inventory.buyItem(temp);
                System.out.println("You now own " + command + " and have " + inventory.getGold() + " gold");
            }
            else if(temp == null){
                System.out.println("We don't sell that here - type cancel to continue");
            }
            else{
                System.out.println("You don't have enough gold - type cancel to continue");
            }
            System.out.print("Buy: ");
            command = pick.nextLine();
        }
        shop = null;
     }
    
    /*
     * Method for using items
     */
    private void use(){
        System.out.println("Please select an item to use");
        printInventory();
        Scanner pick = new Scanner(System.in);
        System.out.print("Use:  ");
        String command = pick.nextLine();
        while(!command.equals("cancel")){
            Item temp = inventory.selectItem(command);
            if(temp != null){
                inventory.useItem(temp);
            }
            else{
                System.out.println("You can't use that - type cancel to continue");
            }
            System.out.print("Use:  ");
            command = pick.nextLine();
        }
    }
    
    /*
     * Method for printing all items in the inventory
     */
    private void printInventory(){
        String[] invent = inventory.getInventoryNames();
        System.out.print("Items:  ");
        for (int i = 0; i < invent.length; i++)
        {
            System.out.print(invent[i] + "  ");
        }
        System.out.print("\n");
        System.out.println("Gold: " + inventory.getGold());
    }
    
    private void printShop(Shop shop){
        String[] invent = shop.getInventoryNames();
        if(invent.length == 0){
            System.out.println("shop is closed");
        }
        else{
            System.out.print("Items:  ");
            for (int i = 0; i < invent.length; i++)
                {
                    System.out.print(invent[i] + "  ");
                }
            System.out.print("\n");
            System.out.println("Gold: " + inventory.getGold());
        }
    }
}
