package playing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuestUI extends JPanel implements ActionListener{
	
	private JPanel view;
	private JPanel buttons;
        private JPanel display;
        private JPanel quests;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	
	public QuestUI() {
		setLayout(new BorderLayout());
		
		view = new JPanel();
                view.setLayout(new GridLayout(0,1));
		add(view, BorderLayout.CENTER);
		
		buttons = new JPanel();
		add(buttons, BorderLayout.SOUTH);
                
                add(new JLabel("Quests panel"), BorderLayout.NORTH);
				
		b1 = new JButton("Go on Quest");
		b2 = new JButton("Review Quest");
		b3 = new JButton("List Finished");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		buttons.add(b1);
		buttons.add(b2);
		buttons.add(b3);
		
                display = new JPanel();
                display.setBackground(Color.CYAN);
                display.add(new JLabel("This will display the desciption of quest selected below"));
		view.add(display);
                
                quests = new JPanel();
                quests.setBackground(Color.GREEN);
                quests.add(new JLabel("Here the items will be a list of quests that can be selected"));
                view.add(quests);
                
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(b1)) {
			System.out.println("go on quest");
		} else if (source.equals(b2)) {
			System.out.println("review quest");
		} else if (source.equals(b3)){
			System.out.println("list finished quests");
		}
		
	}

}
