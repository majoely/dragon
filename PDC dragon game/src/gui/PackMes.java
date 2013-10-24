/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import logic.Player;

/**
 *
 * @author msg8758
 */
public class PackMes extends GameTemp {
    
    private JLabel talk;
    private JButton butt1;
    private JButton butt2;
    private JButton butt4;
    private JButton butt5;
    
    public PackMes() {
        super();
        
        talk = new JLabel("You do not have enough to buy item");
        talk.setLocation(10, 10);
        talk.setSize(texts.getWidth()-20, (texts.getHeight()/2)-15);
        texts.add(talk);
        
        butt1 = new JButton("OK");
        butt1.setLocation(10, talk.getHeight()+20);
        butt1.setSize((texts.getWidth()-20), talk.getHeight());
        texts.add(butt1);   
        
        butt4 = new JButton("Dragon");
        butt4.setLocation(10, 10);
        butt4.setSize(buttons.getWidth()-20, (buttons.getHeight()/2)-15);
        buttons.add(butt4);
        
        butt5 = new JButton("Quest");
        butt5.setLocation(10, butt4.getHeight()+20);
        butt5.setSize(butt4.getWidth(), butt4.getHeight());
        buttons.add(butt5);
    }
}