
package logic;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 * @version v0.1 - Added skeleton code
 * @author Curtis
 */
public class Fight {
    
    private Dragon player;
    private Enemy badGuy; 
    private Pack pack;
    private int pEnergy;
    private int bgEnergy;
    
    /*
     * starts the fight between the player and enemy
     */
    public Fight(Dragon d, Enemy bg, Pack p){
        this.player = d;
        this.badGuy = bg;  
        this.pack = p;
        this.pEnergy = 3;
        this.bgEnergy = 0;
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
            System.out.print(player.addExp(badGuy.getExp()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("You have received " + badGuy.getGold() + " gold!");
            pack.addGold(badGuy.getGold());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            if (badGuy.hasItem())
            {
                System.out.println("You have recieved " + badGuy.getItem().getName());
                pack.addItem(badGuy.getItem());
            } else
            {
                System.out.println("You have recieved no item from this foe");
            }
        }
    }
    
    private void printStats()
    {
        System.out.println("Dragon: " + player.getHealth() + "/" + player.getMaxHealth() + 
            " Enemy: " + badGuy.getHealth() + "/" + badGuy.getMaxHealth());
    }
    
    //Just putting the code for my fight method till I have it working. Will then put it to replace the other one.
    public void conductFightV2(){
        while(player.getHealth() > 0 && badGuy.getHealth() > 0){
            System.out.println(player.getName() + " has " + pEnergy + " Energy");
            System.out.println("What should " + player.getName() + " do? attack - firebreath - defend");
            Scanner in = new Scanner(System.in);
            String input = null;
            System.out.print("Fight: ");
            input = in.nextLine();
            switch(input){
                case "attack" : basicAttack();
                    break;
                case "firebreath" : advancedAttack();
                    break;
                case "defend" : defend();
                    break;
                default : System.out.println("You can't do that here!");
                    break;
            }
            System.out.println(player.getName() + " has " + player.getHealth() + " health remaining");
            System.out.println(badGuy.getName() + " has " + badGuy.getHealth() + " health remaining");
        }
        if(player.getHealth() <= 0)
        {
        System.out.println("Your dragon has died, Game Over!");
        } 
        else
        {
        System.out.println("Your foe has been defeated, and you live to fight another day.");
        System.out.print(player.addExp(badGuy.getExp()));
        try {
            Thread.sleep(1000);
        } 
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("You have received " + badGuy.getGold() + " gold!");
        pack.addGold(badGuy.getGold());
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        if (badGuy.hasItem())
        {
            System.out.println("You have recieved " + badGuy.getItem().getName());
            pack.addItem(badGuy.getItem());
        }
        else
        {
            System.out.println("You have recieved no item from this foe");
        }
        }
    }
    
    public void basicAttack(){
        if(pEnergy >= 2){
        System.out.println("Your Dragon dealt " + player.giveDmg() + " damage");
        badGuy.takeDmg(player.giveDmg());
        pEnergy += 1;
        enemyAttack();
        bgEnergy += 3;
        }
        else{
            System.out.println("You need 2 energy for this attack, you have " + pEnergy);
        }
    }
    
    public void advancedAttack(){
        if(pEnergy >= 10){
            pEnergy -= 7;
            int damage = player.giveDmg() + 10;
            System.out.println("Your dragon dealt " + damage + " damage");
            badGuy.takeDmg(damage);
            bgEnergy += 5;
        }
        else{
            System.out.println("You need 10 energy for this attack, you have " + pEnergy);
        }
    }
    
    public void defend(){
        System.out.println(player.getName() + " takes a defensive stance");
        int damage = badGuy.giveDmg() + (player.getDef() * 2);
        player.takeDmg(damage);
        pEnergy += 5;
        bgEnergy += 3;
    }
    
    public void enemyAttack(){
        if(bgEnergy < 20){
        System.out.println(badGuy.getName() + " dealt " + badGuy.giveDmg() + " to your dragon");
        player.takeDmg(badGuy.giveDmg());
        }
        else{
            bgEnergy -= 20;
            System.out.println(badGuy.getName() + " lunged at your dragon for more damage! He did " + badGuy.giveDmg() + 5);
            player.takeDmg(badGuy.giveDmg() + 5);
        }
    }
    
    public void addEnergy(){
        pEnergy += 10;
    }
    
    public void addBadEnergy(){
        bgEnergy += 20;
    }
}
