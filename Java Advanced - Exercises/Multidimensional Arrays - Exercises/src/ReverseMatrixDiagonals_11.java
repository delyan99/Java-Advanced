import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int matrix[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = rows - 1; i >= 0; i--) {
            if (i == rows - 1) {
                for (int j = cols - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + " ");
                    int currentRow = i - 1;
                    int currentCol = j + 1;
                    while (isValid(matrix, currentRow, currentCol, rows, cols)) {
                        System.out.print(matrix[currentRow][currentCol] + " ");
                        currentCol++;
                        currentRow--;
                    }
                    System.out.println();
                }
            } else {
                    System.out.print(matrix[i][0] + " ");
                    int currentRow = i - 1;
                    int currentCol = 1;
                    while (isValid(matrix, currentRow, currentCol, rows, cols)) {
                        System.out.print(matrix[currentRow][currentCol] + " ");
                        currentCol++;
                        currentRow--;
                    }
                    System.out.println();

            }
        }
    }

    private static boolean isValid(int[][] matrix, int row, int col, int rows, int cols) {
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }
}
