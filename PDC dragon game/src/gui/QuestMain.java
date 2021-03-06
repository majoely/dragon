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
import logic.Player;
import logic.QuestLedger;

/**
 *
 * @author msg8758
 */
public class QuestMain extends GameTemp implements ActionListener{
    
    private JLabel talk;
    private JButton butt1;
    private JButton butt2;
    private JButton butt4;
    private JButton butt5;
    private QuestLedger ql;
    
    public QuestMain(Player pla, QuestLedger ql, String h) {
        super(pla, h);
        
        this.ql = ql;
        
        talk = new JLabel(ql.goToQuest().getName());
        talk.setLocation(10, 10);
        talk.setSize(texts.getWidth()-20, (texts.getHeight()/2)-15);
        texts.add(talk);
        
        butt1 = new JButton("Info");
        butt1.setLocation(10, talk.getHeight()+20);
        butt1.setSize((texts.getWidth()-30)/2, talk.getHeight());
        butt1.addActionListener(this);
        texts.add(butt1);
        
        butt2 = new JButton("Start");
        butt2.setLocation(butt1.getWidth()+20, talk.getHeight()+20);
        butt2.setSize((texts.getWidth()-30)/2, talk.getHeight());
        butt2.addActionListener(this);
        texts.add(butt2);
        
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
            System.out.println("go to pack");
            Container cont = (gui.Container) this.getParent();
            cont.playSwitch(1);
        } else if (source == butt1 || source == butt2) {
            System.out.println("go to overview");
            Container cont = (gui.Container) this.getParent();
            cont.playSwitch(4);
        }else if (source == help) {
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
