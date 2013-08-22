
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
    public ArrayList<Quest> listCompletedQuests(){
        return this.completedQuests;
    }
}
