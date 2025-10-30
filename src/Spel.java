import Ljud.Ljudspelare;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spel extends JFrame implements ActionListener {

    Ljudspelare ljud = new Ljudspelare();

    JFrame jf = new JFrame("15-Spel");

    /* JButton jb0 = new JButton();
    JButton jb1 = new JButton("1");
    JButton jb2 = new JButton("2");
    JButton jb3 = new JButton("3");
    JButton jb4 = new JButton("4");
    JButton jb5 = new JButton("5");
    JButton jb6 = new JButton("6");
    JButton jb7 = new JButton("7");
    JButton jb8 = new JButton("8");
    JButton jb9 = new JButton("9");
    JButton jb10 = new JButton("10");
    JButton jb11 = new JButton("11");
    JButton jb12 = new JButton("12");
    JButton jb13 = new JButton("13");
    JButton jb14 = new JButton("14");
    JButton jb15 = new JButton("15"); */
    JButton newGame = new JButton("NEW GAME");
    JPanel southPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JLabel banner = new JLabel("PLACEHOLDER");


    public Spel() {
        jf.add(gameGridNorth(), BorderLayout.NORTH);
        jf.add(gameGridCenter(), BorderLayout.CENTER);
        jf.add(gameGridSouth(), BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    JPanel gameGridCenter() {
        centerPanel.setLayout(new GridLayout(4, 4));
        centerPanel.setPreferredSize(new Dimension(400, 400));

        JButton[] buttons = new JButton[16];
        Font buttonFont = new Font("", Font.PLAIN, 50);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(buttonFont);
            buttons[i].setName("gameGridCenter");

            if(i >= 1 && i <= 15) {
                buttons[i].setText(String.valueOf(i));
            }
            buttons[i].addActionListener(this);
            centerPanel.add(buttons[i]);

        }
        return centerPanel;
    }
       /*
        centerPanel.add(jb0);
        centerPanel.add(jb1);
        jb1.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb2);
        jb2.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb3);
        jb3.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb4);
        jb4.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb5);
        jb5.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb6);
        jb6.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb7);
        jb7.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb8);
        jb8.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb9);
        jb9.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb10);
        jb10.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb11);
        jb11.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb12);
        jb12.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb13);
        jb13.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb14);
        jb14.setFont(new Font("", Font.PLAIN, 50));
        centerPanel.add(jb15);
        jb15.setFont(new Font("", Font.PLAIN, 50));

        return centerPanel;
    } */

    JPanel gameGridNorth() {
        banner.setPreferredSize(new Dimension(200, 50));
        northPanel.setLayout(new FlowLayout());
        northPanel.add(banner);
        return northPanel;
    }

    JPanel gameGridSouth() {
        newGame.setPreferredSize(new Dimension(200, 50));
        southPanel.setLayout(new FlowLayout());
        southPanel.add(newGame);
        newGame.addActionListener(this);
        return southPanel;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if ("gameGridCenter".equals(clickedButton.getName())) {
            ljud.playBlockSound();
        }
        if (e.getSource() == newGame) {
            //ljud.
        }
    }
}
