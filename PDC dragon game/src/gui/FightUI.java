/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import logic.Fight;
import logic.Quest;
import logic.QuestLedger;

/**
 *
 * @author msg8758
 */
public class FightUI extends JPanel implements ActionListener{
    private JLabel dHealth;
    private JLabel bdHealth;
    private JPanel hold;
    private JPanel texts;
    private JPanel buttons;
    private JTextArea talk;
    private JButton butt1;
    private JButton butt2;
    private JButton butt3;
    private JLabel prog;
    private JProgressBar bar;
    private int dragonH;
    private int badguyH;
    private Quest q;
    private Fight nextFight;
    private QuestLedger ql;
    
    
    public FightUI(Quest q, QuestLedger ql) {
        this.q = q;
        this.nextFight = q.getNext();
        this.ql = ql;
        
        this.dragonH = nextFight.getDragon().getHealth();
        this.badguyH = nextFight.getEnemy().getHealth();
        
        setLayout(new GroupLayout(this));
        setLocation(10, 10);
        setSize(574, 202);
        
        dHealth = new JLabel("Dragon: " + dragonH);
        dHealth.setLocation(0, 0);
        dHealth.setSize((getWidth()/2)-5, 30);
        add(dHealth);
        
        bdHealth = new JLabel("BadGuy: " + badguyH);
        bdHealth.setLocation(dHealth.getWidth()+10, 0);
        bdHealth.setSize((getWidth()/2)-5, 30);
        add(bdHealth);
        
        hold = new JPanel();
        hold.setLayout(new GroupLayout(hold));
        hold.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        hold.setSize(574, 162);
        hold.setLocation(0, 40);
        add(hold);
        
        texts = new JPanel();
        texts.setLayout(new GroupLayout(texts));
        hold.add(texts);
        texts.setLocation(10, 10);
        texts.setSize(424, 142);
        //texts.setBackground(Color.CYAN);
        texts.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        
        buttons = new JPanel();
        buttons.setLayout(new GroupLayout(buttons));
        hold.add(buttons);
        buttons.setLocation(444, 10);
        buttons.setSize(120, 142);
        //buttons.setBackground(Color.LIGHT_GRAY);
        buttons.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        
        talk = new JTextArea("An enemy comes at you!!");
        talk.setEditable(false);
        talk.setLocation(10, 10);
        talk.setSize(texts.getWidth()-20, (texts.getHeight()/2)+7);
        texts.add(talk);
        
        butt1 = new JButton("Attack");
        butt1.setLocation(10, talk.getHeight()+20);
        butt1.setSize((texts.getWidth()-40)/3, talk.getHeight()-42);
        butt1.addActionListener(this);
        texts.add(butt1);
        
        butt2 = new JButton("Defend");
        butt2.setLocation(butt1.getWidth()+20, talk.getHeight()+20);
        butt2.setSize((texts.getWidth()-40)/3, talk.getHeight()-42);
        butt2.addActionListener(this);
        texts.add(butt2);
        
        butt3 = new JButton("Fire");
        butt3.setLocation((butt1.getWidth()*2)+30, talk.getHeight()+20);
        butt3.setSize((texts.getWidth()-40)/3, talk.getHeight()-42);
        butt3.addActionListener(this);
        texts.add(butt3);
        
        bar = new JProgressBar(SwingConstants.VERTICAL, 0, 20);
        bar.setValue(nextFight.getDragonEnergy());
        bar.setLocation(10, 10);
        bar.setSize(buttons.getWidth()-20, buttons.getHeight()-60);
        buttons.add(bar);
        
        prog = new JLabel("ENERGY");
        prog.setLocation(10, bar.getHeight()+20);
        prog.setSize(bar.getWidth(), 30);
        buttons.add(prog);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == butt1) {
            System.out.println("attack");
            talk.setText(nextFight.basicAttack());
        } else if (source == butt2) {
            System.out.println("defend");
            talk.setText(nextFight.defend());
        } else if (source == butt3) {
            System.out.println("fire");
            talk.setText(nextFight.advancedAttack());
        }
        if (nextFight.finished()) {
            if (q.isNext()) {
                nextFight = q.getNext();
                EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "Another enemy attack");
                }});
            }else {
                q.complete();
                EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "Your foes have been defeated!");
                }});
                ql.popNext();
                Container cont = (Container) this.getParent();
                cont.playSwitch(2);
            }
        }
        this.dragonH = nextFight.getDragon().getHealth();
        this.badguyH = nextFight.getEnemy().getHealth();
        bar.setValue(nextFight.getDragonEnergy());
        dHealth.setText("Dragon: " + dragonH);
        bdHealth.setText("BadGuy: " + badguyH);
        bar.repaint();
        repaint();
        
    }
}
