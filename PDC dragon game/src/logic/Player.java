package logic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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
                ex.printStackTrace();
            }
            System.out.print("\nHere have some money.\nGold += " + (10 + (1 * this.dragon.getLevel())));
            pack.addGold(10 + (1 * this.dragon.getLevel()));
        }
    }
    
    public void stop()
    {
        this.stop = true;
    }
    
    public void save() throws FileNotFoundException {
        String save = "" + System.currentTimeMillis() + "\n";
        save += toString();
        save += getDragon().toString();
        save += getQuestLedger().toString();
        save += getPack().toString();
        System.out.print(save);
        PrintWriter pw = new PrintWriter(new FileOutputStream("src/main/save"));
        pw.println(save);
        pw.close();
    }
    
    @Override
    public String toString()
    {
        String save = this.name;
        save += "\n";
        return save;
    }
 
}
