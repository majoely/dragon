/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import logic.Item;
import logic.Pack;

/**
 *
 * @author msg8758
 */
public class PackMain extends GameTemp implements ActionListener{
    
    private JTextArea talk;
    private JButton forward;
    private JButton back;
    private JButton butt1;
    private JButton butt2;
    private JButton butt3;
    private JButton butt4;
    private JButton butt5;
    private Pack p;
    private int itemNum;
    
    public PackMain(Pack p) {
        super();
        
        this.p = p;
        this.itemNum = 0;
        
        back = new JButton("<");
        back.setLocation(10,10);
        back.setSize(40, (texts.getHeight()/2)-15);
        back.addActionListener(this);
        texts.add(back);
        
        talk = new JTextArea(p.getItemNumNoBo());
        talk.setLocation(60, 10);
        talk.setSize(texts.getWidth()-140, (texts.getHeight()/2)-15);
        talk.setEditable(false);
        texts.add(talk);
        
        forward = new JButton(">");
        forward.setLocation(texts.getWidth()-50,10);
        forward.setSize(40, (texts.getHeight()/2)-15);
        forward.addActionListener(this);
        texts.add(forward);
        
        butt1 = new JButton("Use");
        butt1.setLocation(10, talk.getHeight()+20);
        butt1.setSize((texts.getWidth()-40)/3, talk.getHeight());
        butt1.addActionListener(this);
        texts.add(butt1);
        
        butt2 = new JButton("Sell");
        butt2.setLocation(butt1.getWidth()+20, talk.getHeight()+20);
        butt2.setSize((texts.getWidth()-40)/3, talk.getHeight());
        butt2.addActionListener(this);
        texts.add(butt2);
        
        butt3 = new JButton("Buy");
        butt3.setLocation((butt1.getWidth()*2)+30, talk.getHeight()+20);
        butt3.setSize((texts.getWidth()-40)/3, talk.getHeight());
        butt3.addActionListener(this);
        texts.add(butt3);
        
        butt4 = new JButton("Dragon");
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
            System.out.println("go to dragon");
            Container cont = (gui.Container) this.getParent();
            cont.playSwitch(0);
        } else if (source == butt5) {
            System.out.println("go to quest");
            Container cont = (gui.Container) this.getParent();
            cont.playSwitch(2);
        } else if (source == butt1) {
            System.out.println("use");
            Item temp = p.selectItem(talk.getText());
            if(temp != null){
                p.useItem(temp);
                    this.talk.setText(p.getItemNumNoBo());
                
            } else{
                this.talk.setText("You can't use that");
                repaint();
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PackMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.talk.setText(p.getItemNumNoBo());
            }
            repaint();
        } else if (source == butt2) {
            
            System.out.println("sell");
            Item temp = p.selectItem(talk.getText());
            if(temp == null){
                talk.setText("You don't own that - type cancel to continue");
            }
            else{
                p.sellItem(temp);
                talk.setText("You now have " + p.getGold() + " gold");
            }
            repaint();
            
            talk.setText(p.getItemNumNoBo());
            repaint();            
        } else if (source == butt3) {
            System.out.println("go to shop");
            Container cont = (Container) getParent();
            cont.playSwitch(3);            
        } else if (source == forward) {
            System.out.println("forward ");
            this.talk.setText(p.getItemNum(true));
            repaint();
        } else if (source == back) {
            System.out.println("backward ");
            this.talk.setText(p.getItemNum(false));
            repaint();
        }
    }
}
