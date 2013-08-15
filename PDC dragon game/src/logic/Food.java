/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author msg8758
 */
public class Food extends Item{ 
    
    private int feedValue;
    
    public Food(String n, String d, int v, int fv)
    {
        super(n,d,v);
        this.feedValue = fv;
    }
    
    public int getFeedValue()
    {
        return this.feedValue;
    }
    
}
