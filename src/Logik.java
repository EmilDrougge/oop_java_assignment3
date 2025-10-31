import javax.swing.*;
import java.util.Random;

public class Logik {

    public boolean isNextToEmpty(JButton[][] grid, int row, int col) {
        int[] emptyPosition = findEmptySpace(grid);
        if (emptyPosition == null) return false;

        int emptyRow = emptyPosition[0];
        int emptyCol = emptyPosition[1];

        boolean sameRow = (row == emptyRow) && (Math.abs(col - emptyCol) == 1);
        boolean sameCol = (col == emptyCol) && (Math.abs(row - emptyRow) == 1);

        return sameRow || sameCol;
    }

    public void switchButtons(JButton[][] grid, int row, int col, int[][] intArray) {
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

    public int[] findEmptySpace(JButton[][] arrayToSearch) {
        for (int i = 0; i < arrayToSearch.length; i++) {
            for (int j = 0; j < arrayToSearch[i].length; j++) {
                if (arrayToSearch[i][j].getName().equals("Button0")) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // Failsafe
    }

    public int[][] gameGridArray = {
            {1, 2, 3, 4,},
            {5, 6, 7, 8,},
            {9, 10, 11, 12,},
            {13, 14, 15, 0}
    };

    //Tar array och kastar om
    public void randomizeArray(int[][] arrayToRandomize) {
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

    public boolean winLayout(int[][] currentGrid) {
        int expected = 1;

        for (int i = 0; i < currentGrid.length; i++) {
            for (int j = 0; j < currentGrid[i].length; j++) {
                if (i == currentGrid.length - 1 && j == currentGrid[i].length - 1) {
                    return currentGrid[i][j] == 0;
                }
                if (currentGrid[i][j] != expected) {
                    return false;
                }
                expected++;
            }
        }
        return true;
    }
}
