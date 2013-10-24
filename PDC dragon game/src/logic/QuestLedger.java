package logic;

import java.util.ArrayList;

/** 
 *
 * @author Curtis
 */
public class QuestLedger {
    
    private Quest quest;
    private ArrayList<Quest> com;
    private ArrayList<Quest> un;
    
    /**
     * Initial constructor for when the game is started.
     * @param uQ unavailble quests.
     */
    public QuestLedger(ArrayList<Quest> uQ)
    {
        this.un = uQ;
        this.com = new ArrayList<>();
        popNext();
        
    }
    
    /**
     * Constructor for when the game is loaded
     * @param uQ unavailable quests.
     * @param n the number quest you are up to.
     */ 
    public QuestLedger(ArrayList<Quest> uQ, int n)
    {
        this.un = uQ;
        this.com = new ArrayList<>();
        popNext();
        for(int i = 0; i < n; i++)
        {
            this.quest.complete();
            popNext();
        }
    }
    
    /**
     * Method to go to the next quest
     * @return Quest the next quest to complete
     */ 
    public Quest goToQuest()
    {
        return this.quest;
    }
    
    /**
     * Method to cycle through to the next quest
     */
    public void popNext()
    {
        System.out.println("pop");
        if(this.quest != null)
            this.com.add(this.quest);
        if (this.un.isEmpty())
            this.quest = null;
        else
            this.quest = this.un.remove(0);
        
    }
    
    public String[] listCompleted()
    {
        String[] complete = new String[this.com.size()];
        for(int i = 0; i <= this.com.size() - 1; i++)
        {
            complete[i] = this.com.get(i).getName();
        }
        return complete;
    }
    
    @Override
    public String toString()
    {
        return " , quest = " + this.com.size();
    }
}
