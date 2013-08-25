package logic;

import java.util.ArrayList;
import java.util.Iterator;

/** 
 *
 * @author Curtis
 */
public class QuestLedger {
    
    private ArrayList<Quest> currentQuests;
    private ArrayList<Quest> completedQuests;
    private ArrayList<Quest> unavailQuests;
    
    /**
     * 
     * @param cQ
     * @param uQ 
     */
    public QuestLedger(ArrayList<Quest> cQ, ArrayList<Quest> uQ)
    {
        this.currentQuests = cQ;
        this.unavailQuests = uQ;
        this.completedQuests = new ArrayList<>();
        
        Quest test1 = new Quest("test", "it's a job", null, null);
        Quest test2 = new Quest("test2", "Another job", null, null);
        currentQuests.add(test1);
        currentQuests.add(test2);
    }
    
    /**
     * 
     */
    public void questLedger(ArrayList<Quest> unavail){
        
    }
    
    /**
     * Takes the index number of the quest to find it
     */
    public Quest goToQuest(int i){
        Quest choice = null;
        choice = currentQuests.get(i);
        return choice;
    }
    
    /**
     * 
     */
    public void levelUp(int level){
        
    }
    
    /**
     * Returns an array of the Current quests the player can go on
     * @returns String[] of quests names
     */
    public String[] getCurrent(){
        String[] names = new String[currentQuests.size()];
        for(int x = 0; x < currentQuests.size(); x++){
            Quest temp = currentQuests.get(x);
            names[x] = temp.getName();
        }
        return names;
    }
    
    /**
     * Return the list of quests completed by the player so far
     * @returns String[] of quest names
     */
    public String[] getCompletedQuests(){
        String[] names = new String[completedQuests.size()];
        for(int x = 0; x < completedQuests.size(); x++){
            Quest temp = completedQuests.get(x);
            names[x] = temp.getName();
        }
        return names;
    }
}
