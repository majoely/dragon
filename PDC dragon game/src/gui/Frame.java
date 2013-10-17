package gui;

import logic.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
    private Container c;

    public Frame(Player p) {
            setTitle("Dragon Game: " + p.getName());
            setSize(500, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            c = new Container(p);
            add(c);
            setLocationRelativeTo(null);
            //setLocation(1960, 0);
            setVisible(true);

    }
    
    /*
    public static void main(String[] args) {
            Frame f = new Frame();
    }*/

}
