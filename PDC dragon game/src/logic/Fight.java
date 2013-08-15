
package logic;

/**
 * @version v0.1 - Added skeleton code
 * @author Curtis
 */
public class Fight {
    
    private Dragon player;
    private Enemy badGuy; 
    
    /*
     * starts the fight between the player and enemy
     */
    public Fight(Dragon d, Enemy bg){
        this.player = d;
        this.badGuy = bg;        
    }
    
    /**
     * Method to conduct the fight between the the player and the bad guy
     * it will use the two methods attackPlayer and attackBadGuy to conduct
     * the fight.
     * @return String Result of the fight
     */
    public String conductFight()
    {
        return "This fight needs to be sorted out";
    }
    
    /*
     * Determines damage going to player
     * @returns badDmg
     */
    public int attackPlayer(){
        return 0;
    }
    
    /*
     * determines damage going to the badguy
     * @returns goodDmg
     */
    public int attackBadGuy(){
        return 0;
    }
    
    /*
     * Returns the amount of gold the player gets
     * @returns gold
     */
    public int getGold(){
        return 0;
    }
    
    /*
     * Returns the amount of exp the player gets
     * @return experience
     */
    public int getExp(){
        return 0;
    }

    /*
     * if the player gets an item from the battle, this mehtod retrieves it
     * @returns items
     */
    public Item getItem(){
        return null;
    }
}
