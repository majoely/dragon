
package logic;

/**
 * @version v0.1 - added skeleton code
 * @author Curtiis
 */
public class Enemy {
    
    //combat fields
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    
    //reward fields
    private int goldReward;
    private int expReward;
    private Item itemReward;
    
    /**
     * Constructor to create an enemy to battle in fights.
     * @param goldReward Potential Gold reward for defeating this enemy.
     * @param expReward Potential EXP reward for defeating this enemy.
     * @param itemReward Potential Item reward for defeating this enemy.
     */
    public Enemy(int goldReward, int expReward, Item itemReward)
    {
        this.health = 20;
        this.maxHealth = 20;
        this.attack = 2;
        this.defense = 2;
        this.goldReward = goldReward;
        this.expReward = expReward;
        this.itemReward = itemReward;
    }
    
    /*
     * retrieves the attack value of the creature
     * @returns attack
     */
    public int giveDmg(){
        return attack;
    }
    
    /*
     * Calculates how much damage the creature is going to take
     */
    public void takeDmg(int incoming){
        this.helath -= incoming;
    }
    
    /*
     * Returns the current health of the creature
     * @returns health
     */
    public int getHealth(){
        return health;
    }
    
    publid int getMaxHealth(){
        return this.maxHealth;
    }
    
    /*
     * Returns the gold reward for defeating the creature
     * @returns goldReward
     */
    public int getGold(){
        return goldReward;
    }
    
    /*
     * Returns the exp reward for the creature
     * @returns expReward
     */
    public int getExp(){
        return expReward;
    }
    
    /*
     * Returns the Item the creature is carrying
     * @return itemReward
     */
    public Item getItem(){
        return itemReward;
    }
}
