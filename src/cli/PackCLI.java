package cli;

import java.util.*;
import logic.Item;
import logic.Pack;

/**
 * @version v0.1 - added most of the code
 * @author Curtis
 */
public class PackCLI {
    
    private Pack inventory;
    private String[] commands;
    
    @SuppressWarnings("empty-statement")
    public PackCLI(Pack inventory){
        this.inventory = inventory;
        String[] com = {"help", "sell", "buy", "use", "list", "player"};
        this.commands = com;
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
            System.out.print(this.commands[i] + " ");
        }
        System.out.print("\n");
    }
    
    /*
     * Method for selling an item
     */
    private void sell(){
        System.out.println("Please select an item to sell or type cancel to stop");
        printInventory();
        Scanner pick = new Scanner(System.in);
        String command = pick.nextLine();
        while(!command.equals("cancel")){
            Item temp = inventory.selectItem(command);
            if(temp != null){
                inventory.sellItem(temp);
                System.out.println("You now have" + inventory.getGold() + "gold");
            }
            else{
                System.out.println("You don't own that - type cancel to continue");
            }
            command = pick.nextLine();
        }
    }
    
    /*
     * Method for buying items
     */
    private void buy(){
        System.out.println("Please select an item to buy- type cancel to stop");
        //print items that can be purchased along with price
        Scanner pick = new Scanner(System.in);
        String command = pick.nextLine();
        while(!command.equals("cancel")){
            Item temp = inventory.selectItem(command);
            if(temp != null && temp.getValue() < inventory.getGold()){
                inventory.buyItem(temp);
            }
            else{
                System.out.println("You can't purchase that - type cancel to continue");
            }
            command = pick.nextLine();
        }
    }
    
    /*
     * Method for using items
     */
    private void use(){
        System.out.println("Please select an item to use");
        printInventory();
        Scanner pick = new Scanner(System.in);
        String command = pick.nextLine();
        while(!command.equals("cancel")){
            Item temp = inventory.selectItem(command);
            if(temp != null){
                inventory.useItem(temp);
            }
            else{
                System.out.println("You can't use that - type cancel to continue");
            }
            command = pick.nextLine();
        }
    }
    
    /*
     * Method for printing all items in the inventory
     */
    private void printInventory(){
        String[] invent = inventory.getInventoryNames();
        for (int i = 0; i < invent.length; i++)
        {
            System.out.print(invent[i] + " ");
        }
        System.out.print("\n");
        System.out.println("Gold: " + inventory.getGold());
    }
}
