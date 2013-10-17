
package logic;

/**
 * @version v0.1 - Added Skeleton code
 * @author Curtis
 */
public class Potion extends Item
{
    int heal;
    int energize; //restores mana
    int feedValue;
    
    /*
     * when using this constructor to make a potion, set the value of variables not needed to 0 
     */
    public Potion(String n, String d, int v, int heal, int energize, int feedValue){
        super (n, d, v, -1);
        this.heal = heal;
        this.energize = energize;
        this.feedValue = feedValue;
    }
    
    /*
     * Returns the healing value of the potion
     * @return heal
     */
    public int getHeal(){
        return this.heal;
    }
    
    /*
     * Returns the amount of mana the potion will restore
     * @return energize
     */
    public int getEnergize(){
        return this.energize;
    }
    
    /*
     * Returns the feed value of the potion
     * @return feedValue
     */
    public int getFeedValue(){
        return this.feedValue;
    }
}
