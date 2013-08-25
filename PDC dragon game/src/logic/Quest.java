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
    private ArrayList<Challenge> challenges;
    private boolean complete;
    
    /**
     * Constructor for a quest
     * 
     * @param name Name of the quest.
     * @param description Description of the quest.
     * @param fights List of fights that need to be completed
     * @param challenges List of challenges that need to be completed
     */
    public Quest(String name, String description, ArrayList<Fight> fights, ArrayList<Challenge> challenges)
    {
        this.name = name;
        this.description = description;
        this.fights = fights;
        this.challenges = challenges;
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
        Iterator<Fight> f = fights.iterator();
        while(f.hasNext())
        {
            Fight fight = f.next();
            fight.conductFight();
        }
        complete = true;
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
}
