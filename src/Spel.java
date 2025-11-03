import Ljud.Ljudspelare;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spel extends JFrame implements ActionListener {

    Ljudspelare ljud = new Ljudspelare();
    Logik logik = new Logik();
    JFrame jf = new JFrame("15-Spel");
    JButton newGame = new JButton("NEW GAME");
    JPanel southPanel = new JPanel();
    JPanel centerPanel = new JPanel(new GridLayout(4, 4));
    JPanel northPanel = new JPanel();
    JLabel banner = new JLabel(" \uD835\uDC39\uD835\uDC52\uD835\uDCC2\uD835\uDCC9\uD835\uDC5C\uD835\uDCC3\uD835\uDCC8\uD835\uDCC5\uD835\uDC52\uD835\uDCC1");
    JButton[][] buttons;
    JLabel victoryLabel = victoryPanel();
    Timer timer;
    JLabel timeLabel;
    int secounds = 0;

    public Spel() {

        buttons = gameGridButtonArray(logik.gameGridArray);
        jf.add(timerPanel(), BorderLayout.WEST);
        jf.add(gameGridNorth(), BorderLayout.NORTH);
        jf.add(centerPanel, BorderLayout.CENTER);
        jf.add(gameGridSouth(), BorderLayout.SOUTH);
        centerPanel.setLayout(new GridLayout(4, 4));
        centerPanel.setPreferredSize(new Dimension(400, 400));
        jf.pack();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        timer.start();
    }

    public JButton[][] gameGridButtonArray(int[][] intArrayToButtons) {
        JButton[][] gameGridButtons = new JButton[4][4];
        Font buttonFont = new Font("", Font.PLAIN, 50);
        for (int i = 0; i < intArrayToButtons.length; i++) {
            for (int j = 0; j < intArrayToButtons.length; j++) {
                gameGridButtons[i][j] = new JButton();
                if (intArrayToButtons[i][j] != 0) {
                    gameGridButtons[i][j] = new JButton(String.valueOf(intArrayToButtons[i][j]));
                }
                gameGridButtons[i][j].setName("Button" + intArrayToButtons[i][j]);
                gameGridButtons[i][j].addActionListener(this);
                gameGridButtons[i][j].setFont(buttonFont);
                centerPanel.add(gameGridButtons[i][j]);
            }
        }
        logik.findEmptySpace(gameGridButtons);
        return gameGridButtons;
    }

    JPanel gameGridNorth() {
        Font font = new Font("", Font.PLAIN, 30);
        banner.setFont(font);
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

    JLabel victoryPanel() {

        ImageIcon victoryPicture = new ImageIcon("Pictures/Congratulations.jpg");
        //https://www.freepik.com/ royalty free picture
        JLabel victoryLabel = new JLabel();
        victoryLabel.setIcon(victoryPicture);
        victoryLabel.setSize(400, 400);

       return victoryLabel;
    }

    JLabel timerPanel() {
        if (timeLabel == null) {
            timeLabel = new JLabel("Time : 0");
            timeLabel.setFont(new Font("Arial", Font.BOLD, 20 ));
        }

        if (timer == null) {
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    secounds++;
                    timeLabel.setText("Time : " + secounds);
                }
            });
        }
        return timeLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newGame) {
            timer.restart();
            secounds = 0;
            ljud.playStartGameSound();

            jf.remove(victoryLabel);

            centerPanel.removeAll();
            logik.randomizeArray(logik.gameGridArray);
            buttons = gameGridButtonArray(logik.gameGridArray);

            jf.add(centerPanel, BorderLayout.CENTER);
            centerPanel.revalidate();
            centerPanel.repaint();
            jf.revalidate();
            jf.repaint();

        } else {
            JButton clickedButton = (JButton) e.getSource();

            if (clickedButton.getName().contains("Button")) {
                ljud.playBlockSound();

                for (int i = 0; i < buttons.length; i++) {
                    for (int j = 0; j < buttons[i].length; j++) {
                        if (buttons[i][j] == clickedButton) {
                            if (logik.isNextToEmpty(buttons, i, j)) {
                                logik.switchButtons(buttons, i, j, logik.gameGridArray);
                                ljud.playSwingSound();
                                if (logik.winLayout(logik.gameGridArray)) {
                                    ljud.playWinningSound();
                                    jf.remove(centerPanel);
                                    timer.stop();
                                    jf.add(victoryLabel, BorderLayout.CENTER);
                                    jf.revalidate();
                                    jf.repaint();
                                }
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
}
