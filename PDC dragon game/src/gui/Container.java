package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Container extends JPanel implements ActionListener {
	
	private JPanel stats;
	private JPanel buttons;
	private JPanel main;
	private JPanel view1;
	private JPanel view2;
	private JPanel view3;
	private JButton	b1;
	private JButton b2;
	private JButton b3;
	
	public Container() {
		setLayout(new BorderLayout(5,5));
		
		stats = new JPanel();
		stats.setBackground(Color.lightGray);
		add(stats,BorderLayout.NORTH);
		stats.add(new JLabel("name"));
		stats.add(new JLabel("     "));
		stats.add(new JLabel("level"));
		stats.add(new JLabel("     "));
		stats.add(new JLabel("exp"));
		
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(0, 1));
		add(buttons, BorderLayout.WEST);
		
		
		main = new JPanel();
		main.setLayout(new GridLayout());
		main.setBackground(Color.gray);
		add(main, BorderLayout.CENTER); 
		
		
		view1 = new DragonUI();
		main.add(view1, BorderLayout.CENTER);
		
		view2 = new PackUI();
		
		view3 = new QuestUI();
		
		
		b1 = new JButton("Dragon");
		b1.addActionListener(this);
		buttons.add(b1);
		
		b2 = new JButton("Pack");
		b2.addActionListener(this);
		buttons.add(b2);
		
		b3 = new JButton("Quests");
		b3.addActionListener(this);
		buttons.add(b3);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(b1)) {
			main.remove(0);
			main.add(view1);
			main.repaint();
			main.revalidate();
			System.out.println("dragon");
		} else if (source.equals(b2)) {
			main.remove(0);
			main.add(view2);
			main.repaint();
			main.revalidate();
			System.out.println("pack");
		} else if (source.equals(b3)){
			main.remove(0);
			main.add(view3);
			main.repaint();
			main.revalidate();
			System.out.println("quest");
		}
	}

}
