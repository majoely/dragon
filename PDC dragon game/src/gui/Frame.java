/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author msg8758
 */
public class Frame extends JFrame{
    
    private JPanel container;
    
    public Frame() {
        setTitle("Dragon Game: ");
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = new Container();
        add(container);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true); 
        System.out.println("Begin");
    }
    
    
    
    public static void main(String[] args) {
        

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        Frame f = new Frame();
    }
    
}
