/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import logic.Item;
import logic.Pack;
import logic.Shop;

/**
 *
 * @author msg8758
 */
public class PackShop extends GameTemp implements ActionListener{
    
    private JTextArea talk;
    private JButton forward;
    private JButton back;
    private JButton butt1;
    private JButton butt4;
    private JButton butt5;
    private Pack p;
    private Shop s;
    
    public PackShop(Pack p, int level) {
        super();
        
        this.p = p;
        this.s = new Shop(level);
        
        back = new JButton("<");
        back.setLocation(10,10);
        back.setSize(40, (texts.getHeight()/2)-15);
        back.addActionListener(this);
        texts.add(back);
        
        talk = new JTextArea(s.getItem(true));
        talk.setLocation(60, 10);
        talk.setSize(texts.getWidth()-140, (texts.getHeight()/2)-15);
        talk.setEditable(false);
        texts.add(talk);
        
        forward = new JButton(">");
        forward.setLocation(texts.getWidth()-50,10);
        forward .setSize(40, (texts.getHeight()/2)-15);
        forward.addActionListener(this);
        texts.add(forward);
        
        butt1 = new JButton("Buy");
        butt1.setLocation(10, talk.getHeight()+20);
        butt1.setSize(texts.getWidth()-20, talk.getHeight());
        butt1.addActionListener(this);
        texts.add(butt1);
        
        butt4 = new JButton("Dragon");
        butt4.setLocation(10, 10);
        butt4.setSize(buttons.getWidth()-20, (buttons.getHeight()/2)-15);
        butt4.addActionListener(this);
        buttons.add(butt4);
        
        butt5 = new JButton("Pack");
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
            cont.playSwitch(1);
        } else if (source == back) {
            System.out.println("back");
            this.talk.setText(s.getItem(false));
            repaint();
        } else if (source == forward) {
            System.out.println("forward");
            this.talk.setText(s.getItem(true));
            repaint();
        } else if (source == butt1) {
            System.out.println("buy");
            if (!talk.getText().equals("null")) {
                Item temp = p.selectItem(talk.getText());
                if (p.getGold() > (temp.getValue()*1.2)) {
                    p.buyItem(temp);
                } else {
                    System.out.println("no money fool");
                }
            }
        }
    }
    
}
