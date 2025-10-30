import Ljud.Ljudspelare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spel extends JFrame implements ActionListener {

    Ljudspelare ljud = new Ljudspelare();

    JFrame jf = new JFrame("15-Spel");

    JButton jb0 = new JButton();
    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    JButton jb3 = new JButton();
    JButton jb4 = new JButton();
    JButton jb5 = new JButton();
    JButton jb6 = new JButton();
    JButton jb7 = new JButton();
    JButton jb8 = new JButton();
    JButton jb9 = new JButton();
    JButton jb10 = new JButton();
    JButton jb11 = new JButton();
    JButton jb12 = new JButton();
    JButton jb13 = new JButton();
    JButton jb14 = new JButton();
    JButton jb15 = new JButton();
    JButton newGame = new JButton();
    JPanel southPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JButton banner = new JButton();


    public Spel() {
        jb0.addActionListener(this);
        jf.add(gameGridLayout());
        jf.pack();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    JPanel gameGridLayout() {
        centerPanel.setLayout(new GridLayout(4, 4));
        southPanel.setLayout(new FlowLayout());
        centerPanel.setPreferredSize(new Dimension(400, 400));
        northPanel.setLayout(new FlowLayout());
        centerPanel.add(jb0);
        centerPanel.add(jb1);
        centerPanel.add(jb2);
        centerPanel.add(jb3);
        centerPanel.add(jb4);
        centerPanel.add(jb5);
        centerPanel.add(jb6);
        centerPanel.add(jb7);
        centerPanel.add(jb8);
        centerPanel.add(jb9);
        centerPanel.add(jb10);
        centerPanel.add(jb11);
        centerPanel.add(jb12);
        centerPanel.add(jb13);
        centerPanel.add(jb14);
        centerPanel.add(jb15);
        southPanel.add(newGame);
        northPanel.add(banner);

        return centerPanel;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb0) {
            ljud.playSound();
        }
    }
}
