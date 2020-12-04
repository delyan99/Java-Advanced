import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] array = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(array[j]);
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int [][] outputMatrix = new int[3][3];
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int currentSum = matrix[i][j] + matrix[i + 1][j] + matrix[i][j + 1] + matrix[i + 1][j + 1] + matrix[i + 2][j] + matrix[i][j + 2] + matrix[i + 2][j + 2] + matrix[i + 2][j + 1] + matrix[i + 1][j + 2];
                if(currentSum > maxSum){
                    maxSum = currentSum;
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            outputMatrix[k][l] = matrix[i + k][j + l];
                        }
                    }
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int i = 0; i < outputMatrix.length; i++) {
            for (int j = 0; j < outputMatrix[i].length; j++) {
                System.out.print(outputMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
