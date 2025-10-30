import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Logik implements ActionListener {


    boolean isNextToEmpty(int row, int col) {

        return true;
    }
    //Metod för att kolla om knappen kan flytta på sig.
    /*
    Kolla om knappen man klickar på är bredvid 0an
     */


    //Metod för att flytta knapp om det går.
    /*
    Om metoden som kollar om knappen är bredvid 0an så kan knappen flytta på sig.
    Då ska denna metod flippa deras plats i arrayen.
     */


    //Hittar 0an i en array
    void findEmptySpace(JButton[][] arrayToSearch) {

        for (int i = arrayToSearch.length - 1; i >= 0; i--) {
            for (int j = arrayToSearch[i].length - 1; j >= 0; j--) {
                if (arrayToSearch[i][j].getName().equals("Button0")) {
                    System.out.println("Hittat 0'an på arrayplats " + i + " " + j);
                }
            }
        }
    }

    public int[][] gameGridArray = {
            {1, 2, 3, 4,},
            {5, 6, 7, 8,},
            {9, 10, 11, 12,},
            {13, 14, 15, 0}
    };

    //Tar array och kastar om
    void randomizeArray(int[][] arrayToRandomize) {
        Random rand = new Random();

        for (int i = arrayToRandomize.length - 1; i > 0; i--) {
            for (int j = arrayToRandomize[i].length - 1; j > 0; j--) {

                int m = rand.nextInt(i + 1);
                int n = rand.nextInt(j + 1);

                int temp = arrayToRandomize[i][j];
                arrayToRandomize[i][j] = arrayToRandomize[m][n];
                arrayToRandomize[m][n] = temp;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    //Metod som kollar om nuvarande bräde matchar lösningen.
    //Spara en array som är rätt och jämför efter varje flytt kanske?

}
