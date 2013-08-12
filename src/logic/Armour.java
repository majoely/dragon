package logic;

/**
 *
 * @author Joel Compton
 */
public class Armour extends Item{
    
    private int armourValue;
    
    /**
     * Constructor to create the item armour
     * Will call the super class Item's constructor on creation
     * 
     * @param name Name of the item.
     * @param description Description of the item.
     * @param value Value of the item in gold 
     * @param armourValue Protective value of the armour
     */
    public Armour(String name, String description, int value, int armourValue)
    {
        super(name, description, value);
        this.armourValue = armourValue;
    }
    
    /**
     * Method to get the value of the Armour
     * 
     * @return int The armour value
     */ 
    public int getArmourValue()
    {
        return this.armourValue;
    }
    
}