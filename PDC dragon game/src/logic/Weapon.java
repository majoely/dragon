package logic;

/**
 *
 * @author Joel Compton
 */
public class Weapon extends Item{
    
    private int attackValue;
    
    /**
     * Constructor for Weapon, first calls constructor for super class
     *  
     * @param name Name of item.
     * @param description Description of item.
     * @param value Value of the item.
     * @param attackValue Value of the attack of the weapon.
     */ 
    public Weapon(String name, String description, int value, int attackValue)
    {
        super(name, description, value);
        this.value = value;
    }
    
    /**
     * Method to get the attack value of the Weapon
     * 
     * @return int Value of the attack.
     */ 
    public int getAttackValue()
    {
        return this.attackValue;
    }
    
}
