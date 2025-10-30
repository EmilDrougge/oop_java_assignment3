//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Spel start = new Spel();
        Logik logik = new Logik();

        int[][] array = logik.gameGridArray;
        logik.randomizeArray(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("| %2d ", array[i][j]);
            }
            System.out.println("|");
            System.out.println("─".repeat(array[0].length * 4 + 1));
        }



    }
}