/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import logic.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author msg8758
 */
public class GameTemp extends JPanel implements ActionListener {
    protected JLabel title;
    protected JButton help;
    protected JPanel hold;
    protected JPanel texts;
    protected JPanel buttons;
    protected String helpText;
    protected Player pla;
    
    public GameTemp(Player pla, String helpText) {
        setLayout(new GroupLayout(this));
        setLocation(10, 10);
        setSize(574, 202);
        this.helpText = helpText;
        this.pla = pla;
        title = new JLabel("Dragon: " + pla.getDragon().getName() + " Gold: " + pla.getPack().getGold() 
                + " Level: " + pla.getDragon().getLevel() + " Exp: " + pla.getDragon().getExp());
        
        title.setLocation(0, 0);
        title.setSize(this.getWidth()-50, 30);
        add(title);
        
        help = new JButton("?");
        help.setLocation(this.getWidth()-40, 0);
        help.setSize(40, 30);
        help.addActionListener(this);
        add(help);
        
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
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == help) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, helpText);
                }
            });
        }
    }
}
