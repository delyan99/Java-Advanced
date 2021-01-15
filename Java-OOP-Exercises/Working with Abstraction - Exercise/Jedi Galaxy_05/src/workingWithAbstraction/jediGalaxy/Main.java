package workingWithAbstraction.jediGalaxy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] size = IntegerArrayParser.parseToIntArray(scanner.nextLine());
            int rows = size[0];
            int cols = size[1];

            Matrix matrix = new Matrix(rows, cols);

            matrix.matrixFill();

            String command = scanner.nextLine();
            long starPowerCollected = 0;
            while (!command.equals("Let the Force be with you"))
            {
                int[] ivoCoordinates = IntegerArrayParser.parseToIntArray(command);
                int[] evilCoordinates = IntegerArrayParser.parseToIntArray(scanner.nextLine());

                EvilValuesAdding.addEvilValues(matrix, evilCoordinates);

                starPowerCollected += IvoSumReturning.returnIvoSum(matrix, ivoCoordinates);

                command = scanner.nextLine();
            }

        System.out.println(starPowerCollected);


    }
}
