
package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version v0.1 - Added skeleton code
 * @author Curtis
 */
public class Fight {
    
    private Dragon player;
    private Enemy badGuy; 
    private Pack pack;
    
    /*
     * starts the fight between the player and enemy
     */
    public Fight(Dragon d, Enemy bg, Pack p){
        this.player = d;
        this.badGuy = bg;  
        this.pack = p;
    }
    
    /**
     * Method to conduct the fight between the the player and the bad guy
     * it will use the two methods attackPlayer and attackBadGuy to conduct
     * the fight.
     * @return String Result of the fight
     */
    public void conductFight()
    {
        int strike = 0;
        while(player.getHealth() > 0 && badGuy.getHealth() > 0)
        {
            if (strike % 2 == 0)
            {
                System.out.println("Your foe strikes dealing " + badGuy.giveDmg() + " damage.");
                player.takeDmg(badGuy.giveDmg());
                printStats();
            } else
            {
                System.out.println("Your dragon attackes dealing " + player.giveDmg() + " damage.");
                badGuy.takeDmg(player.giveDmg());
                printStats();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            strike++;
        }
        if(player.getHealth() <= 0)
        {
            System.out.println("Your dragon has died, Game Over!");
        } else
        {
            System.out.println("Your foe has been defeated, and you live to fight another day.");
            System.out.println("You have recieved " + badGuy.getExp() + " xp!");
            player.addExp(badGuy.getExp());
            System.out.println("You have received " + badGuy.getGold() + " gold!");
            pack.addGold(badGuy.getGold());
            System.out.println("You have recieved " + badGuy.getItem().getName());
            pack.addItem(badGuy.getItem());
        }
    }
    
    private void printStats()
    {
        System.out.println("Dragon: " + player.getHealth() + "/" + player.getMaxHealth() + 
            " Enemy: " + badGuy.getHealth() + "/" + badGuy.getMaxHealth());
    }
}
