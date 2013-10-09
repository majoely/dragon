package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	private Container c;
	
	public Frame() {
		setTitle("Dragon Game");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = new Container();
		add(c);
                setLocationRelativeTo(null);
		//setLocation(1960, 0);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Frame f = new Frame();
	}

}
