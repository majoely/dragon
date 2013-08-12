package logic;

/**
 *
 * @author Joel Compton
 */
public class Player {
    
    private String name;
    private Pack pack;
    private Dragon dragon;
    private QuestLedger ql;
    
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
 
}
