/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author msg8758
 */
public class Info extends Starter implements ActionListener{
    private JTextArea string;
    private JButton butt;
    
    public Info(String s, String b) {
        super();
                
        
        string = new JTextArea(s);
        string.setBounds(10, 10, texts.getWidth()-20, texts.getHeight()-20);
        string.setWrapStyleWord(true);
        //string.setRows(10);
        string.setEditable(false);
        texts.add(string);
        
        
        
        butt = new JButton(b);
        buttons.add(butt);
        butt.setBounds(0,0, buttons.getWidth(), buttons.getHeight());
        butt.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container cont = (gui.Container) this.getParent();
        cont.layoutSwitch();
    }
}
