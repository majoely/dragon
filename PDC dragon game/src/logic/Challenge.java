package logic;

/**
 *
 * @author Joel Compton
 */
public class Challenge {
    
    private String challenge;
    private String answer;
    private String hint;
    private Item reward;
    private boolean usedHint;
 
    /**
     * Constructor for the challenge
     * WIll take 4 parameters and store them in the objects attributes
     * 
     * @param challenge The challenge that the player will have to do
     * @param answer The answer to the challenge that the player will need to answer
     * @param hint A hint if the player doesn't know the answer
     * @param reward An item prize if the player answers the challenge correctly without using the hint
     */ 
    public Challenge(String challenge, String answer, String hint, Item reward)
    {
        this.challenge = challenge;
        this.answer = answer;
        this.hint = hint;
        this.reward = reward;
        this.usedHint = false;
    }
    
    /**
     * The question that the player will need to answer
     * 
     * @return String The question
     */ 
    public String question()
    {
        return this.challenge;
    }
    
    /**
     * Method to check the if the players answer is correct
     * 
     * @param answer Players guess at the answer
     * @return boolean Will return true if answer is correct
     */ 
    public boolean isAnswer(String answer)
    {
        boolean correct = false;
        if (this.answer.equals(answer))
        {
            correct = true;
        }
        return correct;
    }
    
    /**
     * Method to get the hint for the challenge
     * If used the player will not get the reward
     * 
     * @return String The hint.
     */ 
    public String getHint()
    {
        this.usedHint = true;
        return this.hint;
    }
    
    /**
     * The item to get the reward for correctly answering the question
     * If the hint was used the reward will be null
     * 
     * @return Item Reward is an Item or null if hint was used
     */ 
    public Item getReward()
    {
        Item item = null;
        if (!usedHint)
        {
            item = this.reward;
        }
        return item;
    }
    
}
