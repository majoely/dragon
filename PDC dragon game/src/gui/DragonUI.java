/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import logic.Dragon;
import logic.Item;
import logic.Pack;
import logic.Player;

/**
 *
 * @author msg8758
 */
public class DragonUI extends GameTemp implements ActionListener{
    
    private JTextArea talk;
    private JButton butt1;
    private JButton butt2;
    private JButton butt3;
    private JButton butt4;
    private JButton butt5;
    private Dragon d;
    private Pack p;
    
    
    public DragonUI(Player pla, Dragon dra, Pack pac, String h) {
        super(pla, h);
        
        this.d = dra;
        this.p = pac;
        
        talk = new JTextArea("What would you like to do");
        talk.setLocation(10, 10);
        talk.setSize(texts.getWidth()-20, (texts.getHeight()/2)-15);
        talk.setEditable(false);
        texts.add(talk);
        
        butt1 = new JButton("Feed");
        butt1.setLocation(10, talk.getHeight()+20);
        butt1.setSize((texts.getWidth()-40)/3, talk.getHeight());
        butt1.addActionListener(this);
        texts.add(butt1);
        
        butt2 = new JButton("Play");
        butt2.setLocation(butt1.getWidth()+20, talk.getHeight()+20);
        butt2.setSize((texts.getWidth()-40)/3, talk.getHeight());
        butt2.addActionListener(this);
        texts.add(butt2);
        
        butt3 = new JButton("Train");
        butt3.setLocation((butt1.getWidth()*2)+30, talk.getHeight()+20);
        butt3.setSize((texts.getWidth()-40)/3, talk.getHeight());
        butt3.addActionListener(this);
        texts.add(butt3);
        
        butt4 = new JButton("Pack");
        butt4.setLocation(10, 10);
        butt4.setSize(buttons.getWidth()-20, (buttons.getHeight()/2)-15);
        butt4.addActionListener(this);
        buttons.add(butt4);
        
        butt5 = new JButton("Quest");
        butt5.setLocation(10, butt4.getHeight()+20);
        butt5.setSize(butt4.getWidth(), butt4.getHeight());
        butt5.addActionListener(this);
        buttons.add(butt5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == butt4) {
            System.out.println("go to pack");
            Container cont = (gui.Container) this.getParent();
            cont.playSwitch(1);
        } else if (source == butt5) {
            System.out.println("go to quest");
            Container cont = (gui.Container) this.getParent();
            cont.playSwitch(2);
        } else if (source == butt1) {
            System.out.println("feed");
            String output = "";
            Item i = p.selectItem("Food");
            if (i != null)
            {
                output += "You try to feed " + d.getName() + "\n";
                p.useItem(i);
                output += d.addExp(3);
                output += d.addHealth(5);
            } else
            {
                output += "You do not have any food to feed " + d.getName() + "\n";
                output += "You have to buy some from the pack menu\n";
            }
            this.talk.setText(output);
            repaint();
        } else if (source == butt2) {
            System.out.println("play");
            String output = "";
            if (d.getLevel() > 0)
            {
                int xp = 5;
                Item i = p.selectItem("Toy");
                if (i != null)
                {
                    xp += 3;
                }
                output += "You try to play " + d.getName() + "\n";
                output += d.addExp(xp);
            } else
            {
                output += d.getName() + "is not a high enough level for you to play\n";
                output += "Try again when you are level 1 or above\n";
            }
            this.talk.setText(output);
        } else if (source == butt3) {
            System.out.println("train");
            String output = "";
            if (d.getLevel() > 2)
            {
                int xp = 8;
                Item i = p.selectItem("Chestplate");
                if (i != null)
                {
                    xp += 6;
                }
                output += "You try to train " + d.getName() + "\n";
                output += d.addExp(xp);
            } else
            {
                output += d.getName() + "is not a high enough level for you to train\n";
                output += "Try again when you are level 3 or above\n";
            }
            this.talk.setText(output);
        } else if (source == help) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, helpText);
                }
            });
        }
        repaint();
        revalidate();
    }
}
