/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author msg8758
 */
public class Starter extends JPanel{
    
    protected JPanel texts;
    protected JPanel buttons;
    
    public Starter() {
        setLayout(new GroupLayout(this));
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        setLocation(10, 10);
        setSize(574, 202);
        
        texts = new JPanel();
        texts.setLayout(new GroupLayout(texts));
        add(texts);
        texts.setLocation(10, 10);
        texts.setSize(424, 182);
        //text.setBackground(Color.CYAN);
        texts.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        
        buttons = new JPanel();
        buttons.setLayout(new GroupLayout(buttons));
        add(buttons);
        buttons.setLocation(444, 10);
        buttons.setSize(120, 182);
        //buttons.setBackground(Color.LIGHT_GRAY);
        buttons.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    }
}
