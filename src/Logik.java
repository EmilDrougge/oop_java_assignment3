import java.util.Random;

public class Logik {

    //Metod för att kolla om knappen kan flytta på sig.
    /*
    Kolla om knappen man klickar på är bredvid 0an
     */


    //Metod för att flytta knapp om det går.
    /*
    Om metoden som kollar om knappen är bredvid 0an så kan knappen flytta på sig.
    Då ska denna metod flippa deras plats i arrayen.
     */


    //Metod som randomizar brädet.

    //Array som är rätt by default
    public int[][] gameGridArray = {
            {1, 2, 3, 4,},
            {5, 6, 7, 8,},
            {9, 10, 11, 12,},
            {13, 14, 15, 0}
    };

    //Tar array och kastar om
    void randomizeArray(int[][] gameGridArray) {
        Random rand = new Random();

        for (int i = gameGridArray.length - 1; i > 0; i--) {
            for (int j = gameGridArray[i].length - 1; j > 0; j--) {
                int m = rand.nextInt(i + 1);
                int n = rand.nextInt(j + 1);

                int temp = gameGridArray[i][j];
                gameGridArray[i][j] = gameGridArray[m][n];
                gameGridArray[m][n] = temp;
            }
        }
    }


    //Metod som kollar om nuvarande bräde matchar lösningen.
    //Spara en array som är rätt och jämför efter varje flytt kanske?

}
