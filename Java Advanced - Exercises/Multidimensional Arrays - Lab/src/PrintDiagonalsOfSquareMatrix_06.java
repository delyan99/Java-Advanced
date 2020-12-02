import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = insertMatrix(scanner);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i == j){
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        System.out.println();
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix.length - 1 - i == j){
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }

    }

    private static int[][] insertMatrix(Scanner scanner) {
        int rowsAndColumns = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rowsAndColumns][rowsAndColumns];
        for (int i = 0; i < rowsAndColumns; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = input;
        }
        return matrix;
    }
}
