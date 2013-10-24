package logic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Joel Compton
 */
public class Quest {
     
    private String name;
    private String description;
    private ArrayList<Fight> fights;
    private boolean complete;
    
    /**
     * Constructor for a quest
     * 
     * @param name Name of the quest.
     * @param description Description of the quest.
     * @param fights List of fights that need to be completed
     * @param challenges List of challenges that need to be completed
     */
    public Quest(String name, String description, ArrayList<Fight> fights)
    {
        this.name = name;
        this.description = description;
        this.fights = fights;
        this.complete = false;
    }
     
    /**
     * Method to figure out what whether you are going to be going into a fight 
     * or challenge
     * 
     * [NOT COMPTLETED]
     */ 
    public void mission()
    {
        Fight f = fights.remove(0);
        f.conductFightV2();
        if (fights.isEmpty())
        {
            System.out.println("You have completed this quests");
            complete = true;
        } else
        {
            System.out.println("You have " + fights.size() + " fights left in the quest");
        }
        /*
        Iterator<Fight> f = fights.iterator();
        while(f.hasNext())
        {
            Fight fight = f.next();
            fight.conductFight();
        }
        complete = true;*/
    }
    
    /**
     * Method to check whether the Quest is completed
     * 
     * @return boolean To check whether the method is complete.
     */ 
    public boolean isComplete()
    {
        return complete;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public Iterator<Fight> getFights()
    {
        return fights.iterator();
    }
    
    public void complete()
    {
        this.complete = true;
    }
    
    public boolean isNext() {
        return !fights.isEmpty();
    }
    
    public Fight getNext() {
        return fights.remove(0);
    }
}
