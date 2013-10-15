package logic;

/**
 * @version v0.1 - add skeleton code for methods
 * @author Curtis
 */
public class Item {
    
    // All items will have these values
    protected int id;
    protected String name;
    protected String description; 
    protected int value;
    
    /*
     * Constructor for Items
     * @param n, name of the item
     * @param d, desccription of the item
     * @param v, value of the item
     */
    public Item(String n, String d, int v, int id){
        this.name = n;
        this.description = d;
        this.value = v;
        this.id = id;
    }
    
    /*
     * Method to return items name
     * @return name
     */
    public String getName(){
        return this.name;
    }
    
    /*
     * Gets the item description
     * @return description
     */
    public String getDescription(){
        return this.description;
    }
    
    /*
     * Gets the items value
     * @return value
     */
    public int getValue(){
        return this.value;
    }
    
    public int getID() {
        return this.id;
    }
}
