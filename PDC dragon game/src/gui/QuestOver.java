/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import logic.Quest;

/**
 *
 * @author msg8758
 */
public class QuestOver extends Starter implements ActionListener{
    
    private JTextArea string;
    private JButton start;
    private JButton back;
    private Quest q;
    private int level;
    
    public QuestOver(Quest q, int level) {
        this.level = level;
        this.q = q;
        String s = q.getName() + "\n" + q.getDescription();
        string = new JTextArea(s);
        string.setBounds(10, 10, texts.getWidth()-20, texts.getHeight()-20);
        string.setWrapStyleWord(true);
        string.setLineWrap(true);
        //string.setRows(10);
        string.setEditable(false);
        texts.add(string);
        
        start = new JButton("Start");
        start.setLocation(0, 0);
        start.setSize(buttons.getWidth(), (buttons.getHeight()/2)-5);
        start.addActionListener(this);
        buttons.add(start);
        
        back = new JButton("Back");
        back.setLocation(0, start.getHeight()+10);
        back.setSize(start.getWidth(), start.getHeight());
        back.addActionListener(this);
        buttons.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == start) {
            System.out.println("start");
            if (level < 5) {
                EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "Your dragon is too young to go on quests.");
                }});
            }else {
                Container cont = (Container) getParent();
                cont.playSwitch(5);
            }
        } else if (source == back) {
            System.out.println("back");
            Container cont = (Container) getParent();
            cont.playSwitch(2);
        }
    }
    
}
