package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PackUI extends JPanel implements ActionListener{
	
	private JPanel view;
	private JPanel buttons;
        private JPanel items;
        private JPanel display;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	
	public PackUI() {
		setLayout(new BorderLayout());
		view = new JPanel();
                view.setLayout(new GridLayout(0,1));
		add(view, BorderLayout.CENTER);
		
		buttons = new JPanel();
		add(buttons, BorderLayout.SOUTH);
		
		add(new JLabel("Pack panel"), BorderLayout.NORTH);
		
		b1 = new JButton("Use");
		b2 = new JButton("Buy");
		b3 = new JButton("Sell");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		buttons.add(b1);
		buttons.add(b2);
		buttons.add(b3);
                
                display = new JPanel();
                display.setBackground(Color.red);
                display.add(new JLabel("This will display the desciption of the items selected below"));
		view.add(display);
                
                items = new JPanel();
                items.setBackground(Color.ORANGE);
                //items.setLayout(new GridLayout(2,0));
                items.add(new JLabel("Here the items will be displayed as boxs that can be selected"));
                view.add(items);
                
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(b1)) {
			System.out.println("use item");
		} else if (source.equals(b2)) {
			System.out.println("buy item");
		} else if (source.equals(b3)){
			System.out.println("sell item");
		}
		
	}

}
