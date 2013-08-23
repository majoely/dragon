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
        
        Quest testQuest = new Quest("First one done", "Test quest", null, null);
        Quest testQuest2 = new Quest("Second one done", "Test quest 2", null, null);
        this.completedQuests.add(testQuest);
        this.completedQuests.add(testQuest2);
    }
    
    /*
     * 
     */
    public void questLedger(ArrayList<Quest> unavail){
        
    }
    
    /*
     * 
     */
    public void goToQuest(Quest q){
        
    }
    
    /*
     * 
     */
    public void levelUp(int level){
        
    }
    
    /*
    *
    */
    public ArrayList<Quest> listCompleted(){
        return this.currentQuests;
    }
    
    /*
     * Return the list of quests completed by the player so far
     */
    public void getCompletedQuests(){
        String[] names = new String[completedQuests.size()];
        for(int x = 0; x < completedQuests.size(); x++){
            Quest temp = completedQuests.get(x);
            names[x] = temp.getName();
        }
        return names;
    }
}
