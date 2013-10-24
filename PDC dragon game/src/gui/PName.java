/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author msg8758
 */
public class PName extends Starter implements ActionListener{
    
    private JTextArea string;
    private JTextField name;
    private JButton butt;
    
    public PName(String s, String b) {
        super();
        
        string = new JTextArea(s);
        string.setBounds(10, 10, texts.getWidth()-20, texts.getHeight()-70);
        string.setWrapStyleWord(true);
        //string.setRows(10);
        string.setLineWrap(true);
        string.setEditable(false);
        texts.add(string);
        
        name = new JTextField();
        name.setBounds(10, texts.getHeight()-50, texts.getWidth()-20, 40);
        texts.add(name);
        
        butt = new JButton(b);
        buttons.add(butt);
        butt.setBounds(0,0, buttons.getWidth(), buttons.getHeight());
        butt.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container cont = (gui.Container) this.getParent();
        cont.getPlayer().setName(name.getText());
        cont.layoutSwitch();
    }
    
}
