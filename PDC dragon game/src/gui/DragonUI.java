package gui;

import logic.*;
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
    private Dragon d;
    private Pack p;


    public DragonUI(Dragon d, Pack p) {
            this.d = d;
            this.p = p;
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
                    feed();
            } else if (source.equals(b2)) {
                    System.out.println("play with dragon");
                    play();
            } else if (source.equals(b3)){
                    System.out.println("train dragon");
                    train();
            }

    }

    private void feed() {
        String output = "";
        Item i = p.selectItem("Food");
        if (i != null)
        {
            output += "You try to feed " + d.getName() + "\n";
            p.useItem(i);
            output += d.addExp(3);
            output += d.addHealth(5);
        } else
        {
            output += "You do not have any food to feed " + d.getName() + "\n";
            output += "You have to buy some from the pack menu\n";
        }
        System.out.print(output);
    }

    private void play() {
        String output = "";
        if (d.getLevel() > 0)
        {
            int xp = 5;
            Item i = p.selectItem("Toy");
            if (i != null)
            {
                xp += 3;
            }
            output += "You try to play " + d.getName() + "\n";
            output += d.addExp(xp);
        } else
        {
            output += d.getName() + "is not a high enough level for you to play\n";
            output += "Try again when you are level 1 or above\n";
        }
        System.out.print(output);
    }  
    
    private void train() {
        String output = "";
        if (d.getLevel() > 2)
        {
            int xp = 8;
            Item i = p.selectItem("Chestplate");
            if (i != null)
            {
                xp += 6;
            }
            output += "You try to train " + d.getName() + "\n";
            output += d.addExp(xp);
        } else
        {
            output += d.getName() + "is not a high enough level for you to train\n";
            output += "Try again when you are level 3 or above\n";
        }
        System.out.print(output);
    }
}
