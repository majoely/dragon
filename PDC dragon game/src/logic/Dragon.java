 package logic;

/**
 * @version 0.1 - Skeleton code added.
 * @author Curtis
 * This class is to be used to create a players pet
 */
public class Dragon {
    //Other attributes
    private String name;
    private int experience;
    private int level;
    //Combat atributes
    private int maxHealth;
    private int health;
    private int attack;
    private int defense; 
    // High hunger is bad. 0.0 is a happy fed pet
    private int hunger;   
    private int[] levels;
    
    /*
     * Basic constructor creates a dragon with the specified name.
     * Base atributes include 100HP, 5ATK and 5DEF. Starts with exp and level at 0
     * @param name, dragons name
     */
    public Dragon(String name){
        this.name = name;
        this.health = 100;
        this.maxHealth = 100;
        this.defense = 1;
        this.attack = 2;
        this.experience = 0;
        this.level = 0;
        this.hunger = 0;
        int[] levs = {10, 20, 40, 80, 160, 320, 640, 1280, 2560, 5120};
        this.levels = levs;
    }
    
    public Dragon(){
        this.name = "temp";
        this.health = 100;
        this.maxHealth = 100;
        this.defense = 1;
        this.attack = 5;
        this.experience = 0;
        this.level = 0;
        this.hunger = 0;
        int[] levs = {10, 20, 40, 80, 160, 320, 640, 1280, 2560, 5120};
        this.levels = levs;
    }
    
    public Dragon(String name, int health, int maxH, int def, int att, int exp, int lev, int hung){
        this.name = name;
        this.health = health;
        this.maxHealth = maxH;
        this.defense = def;
        this.attack = att;
        this.experience = exp;
        this.level = lev;
        this.hunger = hung;
        int[] levs = {10, 20, 40, 80, 160, 320, 640, 1280, 2560, 5120};
        this.levels = levs;
    }
    
    /*
     * getter for Dragons current health
     * @return health
     */
    public int getHealth(){
        return this.health;
    }
    
    /*
     * Adds to the dragons health pool
     * @param health, amount added to dragon
     */
    public String addHealth(int health){
        String output = "";
        if((this.health + health) < this.maxHealth){
            this.health += health;
            output += "Your health is now " + this.health + "/" + this.maxHealth + "\n";
        }
        else{
            this.health = this.maxHealth;
            output += "You are full healed\n";
        }
        return output;
    }
    
    /*
     * Method for dealing damage to the dragon
     * @param incoming, flat attack value coming from opponent
     */
    public void takeDmg(int incoming){
        int dmg = incoming - this.defense;
        if (dmg < 0)
            dmg = 0;
        this.health -= dmg;
    }
    
    public int getMaxHealth()
    {
        return this.maxHealth;
    }
    
    /*
     * adds to the maximum health pool for the dragon.
     * @param health, value to increase pool by
     */
    public void addMaxHealth(int health){
        this.maxHealth += health;
        this.health += health;
    }
    
    /*
     * Retrieves the level of the dragon
     * @return level
     */
    public int getLevel(){
        return this.level;
    }
    
    /*
     * Method for adding levels to the dragon
     */
    private void addLevel(){
        this.level++;
        this.maxHealth += 10;
        this.health += 10;
        this.attack += 1;
        this.defense += 1;
    }
    
    /*
     * Returns the current exp points of the dragon
     * @return experience
     */
    public int getExp(){
        return this.experience;
    }
    
    /*
     * Add experience points to the dragon
     * @param expGain, experience reward from the quest
     */
    public String addExp(int expGain){
        String output = "";
        if (this.experience + expGain >= this.levels[this.level])
        {
            this.experience = (this.experience + expGain) - this.levels[this.level];
            addLevel();
            output += "Congratulations you are now at level " + this.level + "!!\n";
        } else
        {
            this.experience += expGain;
        }
        output += "You now have " + this.experience + "xp.\n";
        return output;
    }
    
    /*
     * Retrieves the attack value of the dragon
     * @return attack
     */
    public int giveDmg(){
        return this.attack;
    }
    
    /*
     * Retrieves the defense value of the dragon
     * @return defense
     */
    public int getDef(){
        return this.defense;
    }
    
    /*
     * Retrieves the hunger value of the dragon
     * @return hunger
     */
    public double getHunger(){
        return this.hunger;
    }
    
    /*
     * Feeds the dragon. Lower the total hunger level to make the dragon happier
     * @param food
     */
    public void reduceHunger(int food){
        this.hunger =- food;
    }
    
    /*
     * Returns the dragons name
     * @return name
     */
    public String getName(){
        return this.name;
    }
    
    /*
     * Sets the name of the dragon
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        String save = " , dname = \'" + this.name + "\'";
        save += " , exp = " + this.experience;
        save += " , level = " + this.level;
        save += " , mhealth = " +this.maxHealth;
        save += " , health = " + this.health;
        save += " , attack  = " + this.attack;
        save += " , defense = " + this.defense;
        save += " , hunger = " + this.hunger;
        return save;
    }
}
