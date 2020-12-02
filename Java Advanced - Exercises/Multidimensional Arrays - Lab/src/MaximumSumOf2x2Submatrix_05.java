import java.util.Scanner;

public class MaximumSumOf2x2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = inputMatrix(scanner);
        int maxSum = Integer.MIN_VALUE;
        String firstLine = "";
        String secondLine = "";
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if(currentSum > maxSum){
                    maxSum = currentSum;
                    firstLine = matrix[i][j] + " " + matrix[i][j + 1];
                    secondLine = matrix[i + 1][j] + " " + matrix[i + 1][j + 1];
                }

            }
        }
        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println(maxSum);
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
