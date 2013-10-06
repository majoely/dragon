package playing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DragonUI extends JPanel implements ActionListener{
	
	private JPanel view;
	private JPanel buttons;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	
	public DragonUI() {
		setLayout(new BorderLayout());
		
		view = new JPanel();
                view.setBackground(Color.YELLOW);
		add(view, BorderLayout.CENTER);
		
		buttons = new JPanel();
		add(buttons, BorderLayout.SOUTH);
		
		add(new JLabel("Here is where you will interact with the dragon."), BorderLayout.NORTH);
		
		b1 = new JButton("Feed");
		b2 = new JButton("Play");
		b3 = new JButton("Train");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		buttons.add(b1);
		buttons.add(b2);
		buttons.add(b3);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(b1)) {
			System.out.println("feed dragon");
		} else if (source.equals(b2)) {
			System.out.println("play with dragon");
		} else if (source.equals(b3)){
			System.out.println("train dragon");
		}
		
	}

}
