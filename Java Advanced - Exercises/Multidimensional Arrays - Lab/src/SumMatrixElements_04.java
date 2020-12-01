import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = inputMatrix(scanner);
        int columns = 0;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            columns = matrix[i].length;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(matrix.length);
        System.out.println(columns);
        System.out.println(sum);
    }

    private static int[][] inputMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] array = scanner.nextLine().split(", ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(array[j]);
            }
        }
        return matrix;
    }
}
