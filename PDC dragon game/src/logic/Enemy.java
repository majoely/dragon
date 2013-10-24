
package logic;

/**
 * @version v0.1 - added skeleton code
 * @author Curtiis
 */
public class Enemy {
    
    //descriptive feilds
    private String name;
    
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
     * @param name The name of the enemy
     * @param goldReward Potential Gold reward for defeating this enemy.
     * @param expReward Potential EXP reward for defeating this enemy.
     * @param itemReward Potential Item reward for defeating this enemy.
     */
    public Enemy(String n, int goldReward, int expReward, Item itemReward)
    {
        this.name = n;
        this.health = 20;
        this.maxHealth = 20;
        this.attack = 2;
        this.defense = 2;
        this.goldReward = goldReward;
        this.expReward = expReward;
        this.itemReward = itemReward;
        checkStats();
    }
    
    /**
     * Constructor to create an enemy to battle in fights without Item.
     * @param name The name of the enemy
     * @param goldReward Potential Gold reward for defeating this enemy.
     * @param expReward Potential EXP reward for defeating this enemy.
     */
    public Enemy(String n, int goldReward, int expReward)
    {
        this.name = n;
        this.health = 20;
        this.maxHealth = 20;
        this.attack = 2;
        this.defense = 2;
        this.goldReward = goldReward;
        this.expReward = expReward;
        this.itemReward = null;
        checkStats();
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
        this.health -= incoming;
    }
    
    /*
     * Returns the current health of the creature
     * @returns health
     */
    public int getHealth(){
        return health;
    }
    
    public int getMaxHealth(){
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
    
    /**
     * Returns the name of the enemy
     * @return String name of the enemy
     */
     public String getName()
     {
         return this.name;
     }
     
     /**
      * Checks if enemy has an item that could be looted after defeat.
      * @return boolean 
      */
     public boolean hasItem()
     {
         return !(this.itemReward == null);
     }

    private void checkStats() {
        switch (this.name) {
            case "Dummy" :  this.attack=0;
                            this.health=15;
                            this.maxHealth=15;
                            this.defense=2;
                break;
            case "Bandit" :   this.attack=2;
                            this.health=20;
                            this.maxHealth=20;
                            this.defense=2;
                break;
            case "Knight" :   this.attack=4;
                            this.health=30;
                            this.maxHealth=30;
                            this.defense=6;
                break;
            case "Bunny" :   this.attack=0;
                            this.health=10;
                            this.maxHealth=10;
                            this.defense=0;
                break;
            case "Bandit Raider" :   this.attack=3;
                            this.health=30;
                            this.maxHealth=30;
                            this.defense=2;
                break;
            case "Bandit King" :   this.attack=5;
                            this.health=52;
                            this.maxHealth=52;
                            this.defense=4;
                break;
            case "Kings Guard" :   this.attack=13;
                            this.health=80;
                            this.maxHealth=80;
                            this.defense=10;
                break;
            case "King Jeffry" :   this.attack=20;
                            this.health=120;
                            this.maxHealth=120;
                            this.defense=6;
                break;
            case "Archer" :   this.attack=8;
                            this.health=40;
                            this.maxHealth=40;
                            this.defense=3;
                break;
        }
    }
}
