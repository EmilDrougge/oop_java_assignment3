import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Logik implements ActionListener {


    boolean isNextToEmpty(JButton[][] grid, int row, int col) {
        int[] emptyPosition = findEmptySpace(grid);
        if (emptyPosition == null) return false;

        int emptyRow = emptyPosition[0];
        int emptyCol = emptyPosition[1];

        return true;
    }
    //Metod för att kolla om knappen kan flytta på sig.
    /*
    Kolla om knappen man klickar på är bredvid 0an
     */
    void switchButtons(JButton[][] grid, int row, int col, int[][] intArray) {
        int[] emptyPosition = findEmptySpace(grid);
        if (emptyPosition == null) return;

        int emptyRow = emptyPosition[0];
        int emptyCol = emptyPosition[1];

        /* JButton temporary = grid[row][col];
        grid[row][col] = grid[emptyRow][emptyCol];
        grid[emptyRow][emptyCol] = temporary; */

        int temporary = intArray[row][col];
        intArray[row][col] = intArray[emptyRow][emptyCol];
        intArray[emptyRow][emptyCol] = temporary;

        String temporaryText = grid[row][col].getText();
        String temporaryName = grid[row][col].getName();

        grid[row][col].setText(grid[emptyRow][emptyCol].getText());
        grid[row][col].setName(grid[emptyRow][emptyCol].getName());

        grid[emptyRow][emptyCol].setText(temporaryText);
        grid[emptyRow][emptyCol].setName(temporaryName);

    }

    //Metod för att flytta knapp om det går.
    /*
    Om metoden som kollar om knappen är bredvid 0an så kan knappen flytta på sig.
    Då ska denna metod flippa deras plats i arrayen.
     */



    int[] findEmptySpace(JButton[][] arrayToSearch) {
        for (int i = 0; i < arrayToSearch.length; i++) {
            for (int j = 0; j < arrayToSearch[i].length; j++) {
                if (arrayToSearch[i][j].getName().equals("Button0")) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // Failsafe
    }

    //Hittar 0an i en array
    /* void findEmptySpace(JButton[][] arrayToSearch) {

        for (int i = arrayToSearch.length - 1; i >= 0; i--) {
            for (int j = arrayToSearch[i].length - 1; j >= 0; j--) {
                if (arrayToSearch[i][j].getName().equals("Button0")) {
                    System.out.println("Hittat 0'an på arrayplats " + i + " " + j);
                }
            }
        }
    }*/

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
