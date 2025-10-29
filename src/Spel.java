import Ljud.Ljudspelare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spel extends JFrame implements ActionListener {

    Ljudspelare ljud = new Ljudspelare();

    JFrame jf = new JFrame("15-Spel");


    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    JButton jb3 = new JButton();
    JButton jb4 = new JButton();
    JButton jb5 = new JButton();
    JButton jb6 = new JButton();


    public Spel() {
        jb1.addActionListener(this);
        jf.add(gameGrid());
        jf.pack();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    JPanel gameGrid() {
        JPanel jp = new JPanel(new GridLayout(4,4));
        jp.setPreferredSize(new Dimension(400, 400));
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);
        jp.add(jb5);
        jp.add(jb6);
        return jp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            ljud.playSound();
        }
    }
}
