package logic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public Player(Pack pack, Dragon dragon, QuestLedger ql)
    {
        this.name = "temp";
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
    
    public void setName(String name) {
        this.name = name;
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
    
    public void save() {
        String save = "UPDATE PDC.SAVE ";
        save += toString();
        save += getDragon().toString();
        save += getQuestLedger().toString();
        save += getPack().toString();
        save += " WHERE id = 1";
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dragon", "pdc", "pdc");
            Statement stmt = con.createStatement();
            //stmt.executeQuery(save);
            stmt.execute(save);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        System.out.println(save);
        //System.out.println(save.subSequence(0, 183));
        //PrintWriter pw = new PrintWriter(new FileOutputStream("src/main/save"));
        //pw.println(save);
        //pw.close();
    }
    
    @Override
    public String toString()
    {
        String save = "SET pname = \'" + this.name + "\'";
        return save;
    }
 
}
