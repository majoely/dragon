package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joel Compton
 */
public class Player implements Runnable {
    
    private String name;
    private Pack pack;
    private Dragon dragon;
    private QuestLedger ql;
    private boolean stop;
    
    /**
     * Constructor to create player
     * @param name Name of the Player 
     * @param pack The pack to hold the items
     * @param dragon The dragon
     * @param ql The quest ledger which will hold the quests.
     */
    public Player(String name, Pack pack, Dragon dragon, QuestLedger ql)
    {
        this.name = name;
        this.pack = pack;
        this.dragon = dragon;
        this.ql = ql;
        this.stop = false;
    }
    
    /**
     * Constructor to create player
     * @param name Name of the Player
     * @param pack The pack to hold the items
     * @param dragon The dragon
     */
    public Player(String name, Pack pack, Dragon dragon)
    {
        this.name = name;
        this.pack = pack;
        this.dragon = dragon;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public Pack getPack()
    {
        return this.pack;
    }
    
    public Dragon getDragon()
    {
        return this.dragon;
    }
    
    public QuestLedger getQuestLedger()
    {
        return this.ql;
    }

    @Override
    public void run() {
        while(!stop)
        {
            try { 
                Thread.sleep(60000 * 10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print("\nHere have some money.\nGold += " + (10 + (1 * this.dragon.getLevel())));
            pack.addGold(10 + (1 * this.dragon.getLevel()));
        }
    }
    
    public void stop()
    {
        this.stop = true;
    }
    
    @Override
    public String toString()
    {
        String save = this.name;
        save += "\n";
        return save;
    }
 
}
